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
@WebServlet(name = "FoCustLoginOrNot", urlPatterns = {"/FoCustLoginOrNot"})
public class CtrlFo_CheckLogin extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter(); 
        HttpSession session = request.getSession();
        try {
            // Check the session, if no attribute set means no login yet
            if (session.getAttribute("customerId") == null) {
                throw new Exception("Please login to proceed.");
            }
            
        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }
}