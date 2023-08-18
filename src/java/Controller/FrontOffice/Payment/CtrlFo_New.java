package Controller.FrontOffice.Payment;

import Model.Payment;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Lim En Xi
 */
@WebServlet(name = "NewPayment", urlPatterns = {"/NewPayment"})
public class CtrlFo_New extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        //retrieve input
        String dataPosted = request.getReader().lines().collect(Collectors.joining());
        //json parser 
        JSONParser parser = new JSONParser();
        try {

            JSONObject inputData = (JSONObject) parser.parse(dataPosted);

            int oId = Integer.parseInt((String) inputData.get("orderId"));
            String payMethod = (String) inputData.get("payMethod");

            Payment payment = new Payment()
                    .setOrderId(oId)
                    .setPaymentMethod(payMethod)
                    .setCreatedDate(Helper.CurrentDate.getDate())
                    .setCreatedBy((String) session.getAttribute("username"));

            new BusinessLogic.FrontOffice.Payment.BllFo_New().businessLogic(payment);
            out.print("");

        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }
}
