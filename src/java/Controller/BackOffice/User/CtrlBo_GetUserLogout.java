package Controller.BackOffice.User;

import Model.User;
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
 * @author Linyi
 */
@WebServlet(name = "BoUserLogout", urlPatterns = {"/BoUserLogout"})
public class CtrlBo_GetUserLogout extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        try {
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username");
            
            if (session != null){
                session.removeAttribute("username");
                session.removeAttribute("userId");
             }
            out.print("See you next time ");
           
        } catch (Exception e) {
            
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }
}
