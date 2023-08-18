/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.BackOffice.Product;

import Model.Product;
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
@WebServlet(name = "ProductActivate", urlPatterns = {"/ProductActivate"})
public class CtrlBo_Activate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        
        HttpSession session = request.getSession();
        
        PrintWriter out = response.getWriter();
        
        String dataPosted = request.getReader().lines().collect(Collectors.joining());
        
        JSONParser parser = new JSONParser();
        
        try {

            JSONObject productData = (JSONObject) parser.parse(dataPosted);
            
            int productId = Integer.parseInt((String)productData.get("productId"));
            
            Product product = new Product()
                    .setProductId(productId)
                    .setUpdatedBy((String) session.getAttribute("username"));
            
            new BusinessLogic.BackOffice.Product.BllBo_Activate().businessLogic(new Product().setProductId(productId));
           
            out.print("Product has been Activated.");
            
        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }

}
