package Controller.FrontOffice.Customer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author vinnie chin
 */
@WebServlet(name = "FoCustLogOut", urlPatterns = {"/FoCustLogOut"})
public class CtrlFo_DelLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            HttpSession session = request.getSession();
            //store the username in session first so after remove attribute 
            //still can response to the customer with their usrname
            String username = (String) session.getAttribute("username");
            
            if (session != null)
                session.removeAttribute("username");
                session.removeAttribute("customerId");
            
            out.print("See you next time " + username);
            
        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }
}