package Controller.BackOffice.Product;

import Model.Product;

import java.io.IOException;
import java.io.InputStream;
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
 * @author Tham Jun Yuan
 */
@WebServlet(name = "ProductNew", urlPatterns = {"/ProductNew"})
//@MultipartConfig(maxFileSize = 16177215) // upload file's size up to 16MB
public class CtrlBo_New extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

//        
//        if(request.getParameter("product_add")!= null){
//            String productColor = request.getParameter("productColor");
//            String productSize = request.getParameter("productSize");
//            
//            int phyQty = Integer.parseInt(request.getParameter("phyQty"));
//            int minQty = Integer.parseInt(request.getParameter("minQty"));
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

            Product product = new Product()
                    .setProductName(productName)
                    .setCreatedBy((String) session.getAttribute("username"))
                    .setProductDesc(productDesc)
                    .setCategory(productCategory)
                    .setPrice(productPrice)
                    .setIsFeatured(isFeatured);

            ArrayList<Product> products = new BusinessLogic.BackOffice.Product.BllBo_New().businessLogic(product);
            out.print(products.get(0).getProductId());
        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }

    }
}
