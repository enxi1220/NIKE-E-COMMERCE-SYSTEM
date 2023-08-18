/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.BackOffice.ProductDetail;

import Model.ProductDetail;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "EditProductDetail", urlPatterns = {"/EditProductDetail"})
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

            String productColor = (String) inputData.get("color");
            String productSize = (String) inputData.get("size");
            
            int physicalQty = Integer.parseInt((String)inputData.get("phyQty"));
            int minimumQty = Integer.parseInt((String)inputData.get("minQty"));
            int productId = Integer.parseInt((String)inputData.get("productId"));
            int productDetailId = Integer.parseInt((String)inputData.get("productDetailId"));

            ProductDetail productDetail = new ProductDetail()
                    .setColor(productColor)
                    .setUpdatedBy((String) session.getAttribute("username"))
                    .setSize(productSize)
                    .setPhysicalQty(physicalQty)
                    .setMinStockQty(minimumQty)
                    .setProductId(productId)
                    .setProductDetailId(productDetailId);

            new BusinessLogic.BackOffice.ProductDetail.BllBo_Edit().businessLogic(productDetail);
            
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
