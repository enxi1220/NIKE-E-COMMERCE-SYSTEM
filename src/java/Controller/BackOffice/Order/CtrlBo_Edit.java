package Controller.BackOffice.Order;

import Model.Order;
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
 * @author Alvin Chan Ee Aun
 */
@WebServlet(name = "EditOrder", urlPatterns = {"/EditOrder"})
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

        String trackingNo = request.getParameter("trackingNo");
        String orderStatus = request.getParameter("orderStatus");
        int orderId = Integer.parseInt(request.getParameter("orderId"));

        Order order = new Order()
                .setTrackingNo(trackingNo)
                .setStatus(orderStatus)
                .setOrderId(orderId)
                .setUpdatedBy((String) session.getAttribute("username"));

        try {
            new BusinessLogic.BackOffice.Order.BllBo_Edit().businessLogic(order);
            out.print("<script>window.location.href = '/Nike_E-Commerce_System/Views/BackOffice/Order/Bo.OrderSummary.jsp' </script>");

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
