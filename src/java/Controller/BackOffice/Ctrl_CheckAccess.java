package Controller.BackOffice;

import Model.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Lim En Xi
 */
@WebServlet(name = "CheckAccess", urlPatterns = {"/CheckAccess"})
public class Ctrl_CheckAccess extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        HttpSession session = request.getSession();
        System.out.print("Session username");
        System.out.print((String) session.getAttribute("username"));
        try {
            System.out.println("pageName");
            String pageName = request.getParameter("pageName");
            System.out.println(pageName);

            User user = new User().setUsername((String) session.getAttribute("username"));
            ArrayList<User> users = new BusinessLogic.BackOffice.User.BllBo_Get().businessLogic(user);
            String loginUserRole = users.get(0).getUserGroup().getUserGroupName();
            boolean accessible = Helper.RoleBaseAccessControl.CheckAccess(pageName, loginUserRole);
            if (!accessible) {
                throw new Exception("Access restricted.");
            }
        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
