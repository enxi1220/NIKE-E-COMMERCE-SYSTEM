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
@WebServlet(name = "FoCustEditPass", urlPatterns = {"/FoCustEditPass"})
public class CtrlFo_EditPassword extends HttpServlet {

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
                //check customer submitted old password
                case "checkCurrentPass":
                    // Get the value of data posted by their name
                    String currentPass = (String) customerData.get("currentPass");
                     
                    //call business logic layer (BLL) to invoke data access layer (DAL) and execute sql statement
                    new BusinessLogic.FrontOffice.Customer.BllFo_GetPassword().checkPassword(new Customer().setUsername(username).setPassword(currentPass));
                    break;
                
                //customer changed a new password
                case "custChangeNewPass":
                    // Get the value of data posted by their name
                    String newPass= (String) customerData.get("newPass");
                     
                    //call business logic layer (BLL) to invoke data access layer (DAL) and execute sql statement
                    new BusinessLogic.FrontOffice.Customer.BllFo_EditPassword().businessLogic(new Customer().setUsername(username).setPassword(newPass));
                    out.print("Password Updated");
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