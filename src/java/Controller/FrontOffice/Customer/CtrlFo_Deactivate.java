package Controller.FrontOffice.Customer;

import Model.Customer;
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
 * @author vinnie chin
 */
@WebServlet(name = "FoCustDeactivate", urlPatterns = {"/FoCustDeactivate"})
public class CtrlFo_Deactivate extends HttpServlet {

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

        // Store the JSON stringify data posted from jsp ajax post
        String dataPosted = request.getReader().lines().collect(Collectors.joining());
        
        // Declaration for JSON parser to parse dataPosted 
        JSONParser parser = new JSONParser();
        try {
            // Turn the parsed data into JSON Object so value can be retrieve with name
            JSONObject customerData = (JSONObject) parser.parse(dataPosted);

            String username = (String) session.getAttribute("username");
            String action = (String) customerData.get("action");

            switch(action){
                //customer submitted password to delete account
                case "checkCurrentPass": 
                    String currentPass = (String) customerData.get("currentPass");
                    
                    //call business logic layer (BLL) to invoke data access layer (DAL) and execute sql statement
                    new BusinessLogic.FrontOffice.Customer.BllFo_GetPassword().checkPassword(new Customer().setUsername(username).setPassword(currentPass));
                    break;
                
                //customer confirm to delete
                case "confirmDeactivate": 
                    //call business logic layer (BLL) to invoke data access layer (DAL) and execute sql statement
                    new BusinessLogic.FrontOffice.Customer.BllFo_Deactivate().businessLogic(new Customer().setUsername(username));
                    out.print("Account deleted. This account can't be used anymore. Bye...");

                    //remove attribute set during customer login
                    session.removeAttribute("username");
                    session.removeAttribute("customerId");
                    break;
                
                default:
                    throw new Exception("Something wrong...Please check again.");
            }
            
        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }
}