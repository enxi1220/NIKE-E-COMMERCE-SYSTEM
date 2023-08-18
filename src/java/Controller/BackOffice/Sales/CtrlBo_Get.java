/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.BackOffice.Sales;

import Model.Report;
import Model.Product;
import Model.ProductDetail;
import Model.Order;
import Model.OrderDetail;
import Model.Payment;
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
 * @author Junyuan
 */

@WebServlet(name = "Sales", urlPatterns = {"/Sales"})
public class CtrlBo_Get extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        Product product = new Product().setProduct(new Product());
        Report report = new Report();

        try {
            ArrayList<Report> reports = new BusinessLogic.BackOffice.SalesReport.BllBo_Get().businessLogic(report);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            
            reports.forEach(r -> {
                r.getOrderDetail().forEach(od -> {
                    
                    out.println("<br /> ............................................. ");
                    out.println("<br /> Color: " + od.getColor());
                    out.println("<br /> Size: " + od.getSize());
                
                    
                });
            });
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


