package Controller.BackOffice.User;

import Model.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Linyi
 */

@WebServlet(name = "BoUserEditAcc", urlPatterns = {"/BoUserEditAcc"})

@MultipartConfig(maxFileSize = 16777215)

public class CtrlBo_NewPassword extends HttpServlet {

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
       
        // retrieve text input
        String dataPosted = (new BufferedReader(new InputStreamReader(request.getPart("userEditedAcc").getInputStream()))).readLine();

        
        //declaration for parser 
        JSONParser parser = new JSONParser();
        String errList = null;

        try {
            if (request.getContentType() == null) {
                throw new Exception("No data has been submitted.");
            }

            JSONObject userData = (JSONObject) parser.parse(dataPosted);
            
             String username = (String) userData.get("username");
            String name = (String) userData.get("name");
            String password = (String) userData.get("password");
            String phone = (String) userData.get("phone");
            String mail = (String) userData.get("mail");
            int userGroupId = (Integer) userData.get("userGroupId");

            
            User user = new User()
                    .setUsername(username)
                    .setName(name)
                    .setPassword(password)
                    .setPhone(phone)
                    .setMail(mail)
                    .setUserGroupId(userGroupId);
            
            if(errList==null){
                    new BusinessLogic.BackOffice.User.BllBo_Edit().businessLogic(user);
            }

            out.print(userData.get("name"));

        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
            out.flush();
        }
    }
}

