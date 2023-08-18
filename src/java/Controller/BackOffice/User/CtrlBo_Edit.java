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
@WebServlet(name = "EditUser", urlPatterns = {"/EditUser"})
public class CtrlBo_Edit extends HttpServlet {

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
        
        String username = request.getParameter("username");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String mail = request.getParameter("mail");
        
        User user = new User()
                .setUsername(username)
                .setName(name)
                .setPhone(phone)
                .setMail(mail)
                .setUpdatedDate(Helper.CurrentDate.getDate())
                .setUpdatedBy((String) session.getAttribute("username"));

        try {
            new BusinessLogic.BackOffice.User.BllBo_Edit().businessLogic(user);
            out.print("<script>window.location.href = '/Nike_E-Commerce_System/Views/BackOffice/User/Bo.UserSummary.jsp' </script>");

        } catch (Exception ex) {
            System.out.println("Message: " + ex.getMessage());
            StackTraceElement[] elements = ex.getStackTrace();

            for (StackTraceElement e : elements) {
                System.out.println("File Name: " + e.getFileName());
                System.out.println("Class Name: " + e.getClassName());
                System.out.println("Method Name: " + e.getMethodName());
                System.out.println("Line Number: " + e.getLineNumber());
                System.out.println("");
            }
        }

    }
}
