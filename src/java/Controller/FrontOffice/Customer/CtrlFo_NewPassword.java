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
@WebServlet(name = "FoCustResetPass", urlPatterns = {"/FoCustResetPass"})
public class CtrlFo_NewPassword extends HttpServlet {

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

            String action = (String) customerData.get("action");

            switch (action) {
                //check the email customer submitted
                case "checkEmail":
                    // Get the value of data posted by their name
                    String email = (String) customerData.get("email");
                    
                    new BusinessLogic.FrontOffice.Customer.BllFo_GetEmail().checkEmail(new Customer().setMail(email));
                    out.print("Please check your email and enter OTP to reset password.");
                    session.setAttribute("email", email);
                    break;

                //check the OTP customer submitted
                case "checkOTP":
                    // Get the value of data posted by their name
                    String otpNum = (String) customerData.get("otpNum");
                    String username = new BusinessLogic.FrontOffice.Customer.BllFo_GetOTP().checkOTP(new Customer().setMail((String) session.getAttribute("email")).setRandomOTP(otpNum));
                    out.print("You can now reset your password.");

                    // Store the return username to session so later reset password can be used
                    session.setAttribute("username", username);
                    session.setAttribute("otpEntered", "yes");
                    break;

                //customer submmitted new password to reset password
                case "resetPass":
                    if (session.getAttribute("otpEntered") != null) {
                        String custResetPass = (String) customerData.get("custResetPass");
                        
                        //call business logic layer (BLL) to invoke data access layer (DAL) and execute sql statement
                        new BusinessLogic.FrontOffice.Customer.BllFo_EditPassword().businessLogic(new Customer().setUsername((String) session.getAttribute("username")).setPassword(custResetPass));
                        //delete the OTP after reseting pass
                        new BusinessLogic.FrontOffice.Customer.BllFo_DelOTP().businessLogic(new Customer().setUsername((String) session.getAttribute("username")));

                        // Remove all attributes set after reseting password
                        session.removeAttribute("email");
                        session.removeAttribute("username");
                        session.removeAttribute("otpEntered");

                        out.print("Password has been reset. You may login with the new password now.");

                    } else {
                        throw new Exception("No OTP has been entered.");
                    }

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
