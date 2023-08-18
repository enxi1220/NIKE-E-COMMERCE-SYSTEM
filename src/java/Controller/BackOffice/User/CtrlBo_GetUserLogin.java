package Controller.BackOffice.User;

import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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


@WebServlet(name = "BoUserLogin", urlPatterns = {"/BoUserLogin"})
public class CtrlBo_GetUserLogin extends HttpServlet {

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

        //retrieve input 
        String dataPosted = request.getReader().lines().collect(Collectors.joining());
        //json parser
        JSONParser parser = new JSONParser();
        try {

            JSONObject userData = (JSONObject) parser.parse(dataPosted);

            String username = (String) userData.get("username");
            String password = (String) userData.get("password");

            ArrayList<User> userLogin = new BusinessLogic.BackOffice.User.BllBo_GetUserLogin().checkUserLogin(new User().setUsername(username).setPassword(password));
            
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            session.setAttribute("userId", userLogin.get(0).getUserId());
            session.setAttribute("status", userLogin.get(0).getStatus());
            
            out.print("Welcome back " + username);
            
        } catch (Exception e) {
                System.out.println("Message: " + e.getMessage());
            StackTraceElement[] elements = e.getStackTrace();

            for (StackTraceElement s : elements) {
                System.out.println("File Name: " + s.getFileName());
                System.out.println("Class Name: " + s.getClassName());
                System.out.println("Method Name: " + s.getMethodName());
                System.out.println("Line Number: " + s.getLineNumber());
                System.out.println("");
            }
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }
}