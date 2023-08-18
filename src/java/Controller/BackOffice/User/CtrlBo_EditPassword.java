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
@WebServlet(name = "BoUserEditPass", urlPatterns = {"/BoUserEditPass"})
public class CtrlBo_EditPassword extends HttpServlet {

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

//      retrieve input for normal form
        String dataPosted = request.getReader().lines().collect(Collectors.joining());

        //declaration for parser 
        JSONParser parser = new JSONParser();
        try {

            JSONObject userData = (JSONObject) parser.parse(dataPosted);

            HttpSession session = request.getSession();
            String username = (String) userData.get("username");
            String newPass = (String) userData.get("newPass");

            User user = new User()
                    .setUsername(username)
                    .setPassword(newPass)
                    .setUpdatedDate(Helper.CurrentDate.getDate())
                    .setUpdatedBy((String) session.getAttribute("username"));
            new BusinessLogic.BackOffice.User.BllBo_NewPassword().businessLogic(user);

        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
            StackTraceElement[] elements = ex.getStackTrace();

            for (StackTraceElement e : elements) {
                System.out.println("File Name: " + e.getFileName());
                System.out.println("Class Name: " + e.getClassName());
                System.out.println("Method Name: " + e.getMethodName());
                System.out.println("Line Number: " + e.getLineNumber());
                System.out.println("");
            }

            response.setStatus(500);
            out.print(ex.getMessage());
        }
    }
}
