package Controller.BackOffice.Product;

import Model.Product;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Tham Jun Yuan
 */
@WebServlet(name = "ProductView", urlPatterns = {"/ProductView"})
public class CtrlBo_GetFull extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Product product = new Product();
        
        try {
            
            
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
