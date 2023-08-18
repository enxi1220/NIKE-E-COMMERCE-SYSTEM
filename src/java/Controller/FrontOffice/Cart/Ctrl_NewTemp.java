package Controller.FrontOffice.Cart;

import Model.Cart;
import Model.CartDetail;
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
 * @author Lim En Xi
 */
@WebServlet(name = "BuyNow", urlPatterns = {"/BuyNow"})
public class Ctrl_NewTemp extends HttpServlet {

    
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
        
        String intputData = request.getReader().lines().collect(Collectors.joining());

        try {

            JSONParser parser = new JSONParser();
            JSONObject addCartData = (JSONObject) parser.parse(intputData);

            int productDetailId = Integer.parseInt((String) addCartData.get("productDetailId"));
            int quantity = Integer.parseInt((String) addCartData.get("quantity"));

            CartDetail cartDetail = new CartDetail()
                    .setProductDetailId(productDetailId)
                    .setQuantity(quantity)
                    .setCreatedDate(Helper.CurrentDate.getDate())
                    .setCreatedBy((String) session.getAttribute("username"))
                    .setCustomerId((Integer) session.getAttribute("customerId"));
            ArrayList<CartDetail> cartDetails = new ArrayList<>();
            cartDetails.add(cartDetail);
            Cart cart = new Cart()
                            .setCustomerId((Integer) session.getAttribute("customerId"))
                            .setCartDetail(cartDetails);

            ArrayList<Cart> carts = new BusinessLogic.FrontOffice.Cart.Bll_NewTemp().businessLogic(cart);
            
            out.print(carts.get(0).getCartId());

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
