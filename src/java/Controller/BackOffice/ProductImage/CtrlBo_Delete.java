package Controller.BackOffice.ProductImage;

import Model.ProductImage;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
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
@WebServlet(name = "DeleteProductImage", urlPatterns = {"/DeleteProductImage"})
public class CtrlBo_Delete extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
       
        HttpSession session = request.getSession();
        
        String dataPosted = request.getReader().lines().collect(Collectors.joining());
        
        //declaration for parser 
        JSONParser parser = new JSONParser();

        try {

            JSONObject imageData = (JSONObject) parser.parse(dataPosted);
            
            int productImageId = Integer.parseInt((String)imageData.get("productImageId"));

            ProductImage img = new ProductImage().setProductImageId(productImageId).setUpdatedBy((String) session.getAttribute("username"));
            
            new BusinessLogic.BackOffice.ProductImage.BllBo_Delete().businessLogic(img);

        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
        
    }

    

}
