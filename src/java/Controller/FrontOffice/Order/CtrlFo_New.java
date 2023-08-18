package Controller.FrontOffice.Order;

import Helper.Constant;
import Model.Order;
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
@WebServlet(name = "FoNewOrder", urlPatterns = {"/FoNewOrder"})
public class CtrlFo_New extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        //retrieve input
        String dataPosted = request.getReader().lines().collect(Collectors.joining());
        //json parser 
        JSONParser parser = new JSONParser();
        try {

            JSONObject inputData = (JSONObject) parser.parse(dataPosted);

            int crId = Integer.parseInt((String) inputData.get("courierId"));
            int caId = Integer.parseInt((String) inputData.get("cartId"));
            String deliveryAddr = (String) inputData.get("deliveryAddress");
            String receiver = (String) inputData.get("recipient");

            Order order = new Order()
                    .setStatus(Helper.Constant.getStatus(Constant.StatusEnum.Pending))
                    .setCourierId(crId)
                    .setDeliveryAddress(deliveryAddr)
                    .setReceiverName(receiver)
                    .setCartId(caId)
                    .setUpdatedDate(Helper.CurrentDate.getDate())
                    .setUpdatedBy((String) session.getAttribute("username"))
                    .setCreatedDate(Helper.CurrentDate.getDate())
                    .setCreatedBy((String) session.getAttribute("username"))
                    .setCustomerId((Integer) session.getAttribute("customerId"));

            ArrayList<Order> orders = new BusinessLogic.FrontOffice.Order.BllFo_New().businessLogic(order);
            out.print(orders.get(0).getOrderId());
        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }

}
