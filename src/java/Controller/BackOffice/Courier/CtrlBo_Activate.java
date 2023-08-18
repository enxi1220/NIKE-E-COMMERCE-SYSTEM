package Controller.BackOffice.Courier;

import Model.Courier;
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
 * @author Alvin Chan Ee Aun
 */
@WebServlet(name = "BoCourierActivate", urlPatterns = {"/BoCourierActivate"})
public class CtrlBo_Activate extends HttpServlet {

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

        // retrieve input for normal form
        String dataPosted = request.getReader().lines().collect(Collectors.joining());

        //declaration for parser 
        JSONParser parser = new JSONParser();
        try {

            JSONObject courierData = (JSONObject) parser.parse(dataPosted);

            int courierId = Integer.parseInt((String) courierData.get("courierId"));

            Courier courier = new Courier()
                    .setCourierId(courierId)
                    .setUpdatedBy((String) session.getAttribute("username"));

            new BusinessLogic.BackOffice.Courier.BllBo_Activate().businessLogic(courier);
            out.print("This Courier has been Activated.");

        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }
}
