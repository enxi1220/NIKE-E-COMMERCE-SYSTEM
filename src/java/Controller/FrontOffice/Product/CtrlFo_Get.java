/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controller.FrontOffice.Product;

import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinnie chin
 */
@WebServlet(name = "GetProduct", urlPatterns = {"/GetProduct"})
public class CtrlFo_Get extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Product product = new Product();

        try {
//            ArrayList<Product> products = new BusinessLogic.FrontOffice.Product.BllFo_GetFull().businessLogic(product);

            request.setAttribute("products", new BusinessLogic.FrontOffice.Product.BllFo_GetFull().businessLogic(product));

//            response.sendRedirect("<%=request.getContextPath()%>/Views/FrontOffice/Product%>/Fo.ProductSummary.jsp");
            response.sendRedirect("${pageContext.servletContext.contextPath}/Views/FrontOffice/Product/Fo.ProductSummary.jsp");
            
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

