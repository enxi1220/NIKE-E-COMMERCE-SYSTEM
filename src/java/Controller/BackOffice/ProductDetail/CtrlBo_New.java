/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.BackOffice.ProductDetail;

import Model.Product;
import Model.ProductDetail;
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
@WebServlet(name = "NewProductDetail", urlPatterns = {"/NewProductDetail"})
public class CtrlBo_New extends HttpServlet {

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

            ProductDetail productDetail = new ProductDetail()
                    .setColor(productColor)
                    .setUpdatedBy((String) session.getAttribute("username"))
                    .setSize(productSize)
                    .setPhysicalQty(physicalQty)
                    .setMinStockQty(minimumQty)
                    .setProductId(productId);

            new BusinessLogic.BackOffice.ProductDetail.BllBo_New().businessLogic(productDetail);
            out.print(productDetail.getProductId());
        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }

    }

    

}
