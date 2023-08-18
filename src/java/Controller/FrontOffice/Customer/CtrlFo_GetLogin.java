package Controller.FrontOffice.Customer;

import Model.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author vinnie chin
 */
@WebServlet(name = "FoCustLogin", urlPatterns = {"/FoCustLogin"})
public class CtrlFo_GetLogin extends HttpServlet {

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
        
        try {

            if (session.getAttribute("customerId") != null) {
                throw new Exception("You have already login!");
            }

            // Store the JSON stringify data posted from jsp ajax post
            String dataPosted = request.getReader().lines().collect(Collectors.joining());
            
            // Declaration for JSON parser to parse dataPosted 
            JSONParser parser = new JSONParser();

            // Turn the parsed data into JSON Object so value can be retrieve with name
            JSONObject customerData = (JSONObject) parser.parse(dataPosted);

            // Get the value of data posted by their name
            String username = (String) customerData.get("username");
            String password = (String) customerData.get("password");
            int rememberMe = Integer.parseInt((String) customerData.get("rememberMe"));

            //call business logic layer (BLL) to invoke data access layer (DAL) and execute sql statement        
            ArrayList<Customer> customerLogin = new BusinessLogic.FrontOffice.Customer.BllFo_GetLogin().checkCustLogin(new Customer().setUsername(username).setPassword(password));

            //set attribute if business logic method invoked no throw error
            session.setAttribute("username", username);
            session.setAttribute("customerId", customerLogin.get(0).getCustomerId());
            
            //set cookies if customer has tick remember me
            if (rememberMe == 1) {
                Cookie cUser = new Cookie("cookuser", username);
                cUser.setMaxAge(24 * 60 * 60);
                response.addCookie(cUser);  
            }else{
                //set cookies if customer didn't tick remember me
                Cookie userNameCookieRemove = new Cookie("cookuser", "");
                userNameCookieRemove.setMaxAge(0);
                response.addCookie(userNameCookieRemove);
            }

            out.print("Welcome " + username);

        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }
}
