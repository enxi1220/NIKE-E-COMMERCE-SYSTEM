/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller.BackOffice.ProductImage;

import Model.ProductImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author User
 */
@WebServlet(name = "NewProductImage", urlPatterns = {"/NewProductImage"})
@MultipartConfig(maxFileSize = 16777215)
public class CtrlBo_New extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       
        HttpSession session = request.getSession();
        
        String dataPosted = (new BufferedReader(new InputStreamReader(request.getPart("productId").getInputStream()))).readLine();

        Part productImg = request.getPart("productImg");
        
        String imgName = productImg.getSubmittedFileName();
        System.out.print(imgName);
        String imgType = productImg.getContentType();
        System.out.print(imgType);
        String imgFileExt = imgName.substring((imgName.lastIndexOf("."))+1);
        System.out.print(imgFileExt);
        
        //declaration for parser 
        JSONParser parser = new JSONParser();

        try {

            JSONObject imageData = (JSONObject) parser.parse(dataPosted);
            
            int productId = Integer.parseInt((String)imageData.get("productId"));
            InputStream productImgInStr = productImg.getInputStream();

            ProductImage img = new ProductImage().setInputStream(productImgInStr)
                                                 .setUpdatedBy((String) session.getAttribute("username"))
                                                 .setProductId(productId);
//                                                 .setImageType(imgType);
            
            
            new BusinessLogic.BackOffice.ProductImage.BllBo_New().businessLogic(img);
         
   

            out.print(productId);

        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }
    }

  


