package Controller.FrontOffice.Customer;

import Model.Customer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author vinnie chin
 */
@WebServlet(name = "FoCustRegAcc", urlPatterns = {"/FoCustRegAcc"})

@MultipartConfig(maxFileSize = 16777215)

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
        
        // Store the multipart formData() object posted from jsp ajax post
        String dataPosted = (new BufferedReader(new InputStreamReader(request.getPart("customerData").getInputStream()))).readLine();

        // Retrieve file input posted
        Part profileImg = request.getPart("profileImg");
        
        // Declaration for JSON parser to parse dataPosted  
        JSONParser parser = new JSONParser();

        try {
            // Turn the parsed data into JSON Object so value can be retrieve with name  
            JSONObject customerData = (JSONObject) parser.parse(dataPosted);
            
            // Get the value of data posted by their name
            String name = (String) customerData.get("name");
            String username = (String) customerData.get("username");
            String mail = (String) customerData.get("mail");
            String phone = (String) customerData.get("phone");
            String deliveryAddress = (String) customerData.get("deliveryAddress");
            String password = (String) customerData.get("password");
            
            // Turn Part into input stream so that it can be inserted into blob datatype
            InputStream inStr = profileImg.getInputStream();
            
            Customer customer = new Customer()
                            .setName(name)
                            .setUsername(username)
                            .setMail(mail)
                            .setPassword(password)
                            .setInputStream(inStr)  
                            .setPhone(phone)
                            .setDeliveryAddress(deliveryAddress);
            
            // pass the Customer object to the method in business logic layer, invoke data access layer to execute sql statements
            new BusinessLogic.FrontOffice.Customer.BllFo_New().businessLogic(customer);

            out.print("You can login now");

        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }
}
