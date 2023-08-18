package Controller.FrontOffice.Order;

import Helper.Constant;
import Model.Order;
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
@WebServlet(name = "CancelOrder", urlPatterns = {"/CancelOrder"})
public class CtrlFo_Delete extends HttpServlet {

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

            int orId = Integer.parseInt((String) inputData.get("orderId"));

            Order order = new Order().setOrderId(orId)
                    .setStatus(Helper.Constant.getStatus(Constant.StatusEnum.Cancelled))
                    .setUpdatedDate(Helper.CurrentDate.getDate())
                    .setUpdatedBy((String) session.getAttribute("username"));

            new BusinessLogic.FrontOffice.Order.BllFo_Edit().businessLogic(order);
            out.print("Your order was cancelled. Thank you for your support.");
        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }
}
