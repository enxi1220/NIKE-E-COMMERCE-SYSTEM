package Controller.BackOffice.User;

import Model.User;
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
 * @author Linyi
 */
@WebServlet(name = "BoUserDeactivate", urlPatterns = {"/BoUserDeactivate"})
public class CtrlBo_Deactivate extends HttpServlet {

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
        
        // retrieve input for normal form
        String dataPosted = request.getReader().lines().collect(Collectors.joining());

        //declaration for parser 
        JSONParser parser = new JSONParser();
        try {
            HttpSession session = request.getSession();
            JSONObject userData = (JSONObject) parser.parse(dataPosted);

            String username = (String) userData.get("username");

            User user = new User()
                     .setUsername(username)
                    .setUpdatedDate(Helper.CurrentDate.getDate())
                    .setUpdatedBy((String) session.getAttribute("username"));

            new BusinessLogic.BackOffice.User.BllBo_Deactivate().businessLogic(user);
            out.print("Account " + username + " deactivated.");

        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }
}
