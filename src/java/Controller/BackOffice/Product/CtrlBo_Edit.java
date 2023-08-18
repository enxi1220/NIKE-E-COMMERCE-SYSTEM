/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.BackOffice.Product;

import Model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author User
 */
@WebServlet(name = "EditProduct", urlPatterns = {"/EditProduct"})
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
        
        String dataPosted = request.getReader().lines().collect(Collectors.joining());
        
        JSONParser parser = new JSONParser();
        try {

            JSONObject inputData = (JSONObject) parser.parse(dataPosted);

            String productName = (String) inputData.get("productName");
            String productDesc = (String) inputData.get("productDesc");
            String productCategory = (String) inputData.get("productCategory");

            double productPrice = Double.parseDouble((String) inputData.get("productPrice"));
            
            int isFeatured = Integer.parseInt((String)inputData.get("isFeatured"));
            int productId = Integer.parseInt((String)inputData.get("productId"));

            Product product = new Product()
                    .setProductId(productId)
                    .setUpdatedBy((String) session.getAttribute("username"))
                    .setProductName(productName)
                    .setProductDesc(productDesc)
                    .setCategory(productCategory)
                    .setPrice(productPrice)
                    .setIsFeatured(isFeatured);

            new BusinessLogic.BackOffice.Product.BllBo_Edit().businessLogic(product);
            
        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
            System.out.println("Message: " + e.getMessage());
            StackTraceElement[] elements = e.getStackTrace();

            for (StackTraceElement s : elements) {
                System.out.println("File Name: " + s.getFileName());
                System.out.println("Class Name: " + s.getClassName());
                System.out.println("Method Name: " + s.getMethodName());
                System.out.println("Line Number: " + s.getLineNumber());
                System.out.println("");
            }
        }

    }
   

}
