package Controller.FrontOffice.CartDetail;

import Model.CartDetail;
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
 * @author Lim En Xi
 */
@WebServlet(name = "EditCartDetail", urlPatterns = {"/EditCartDetail"})
public class CtrlFo_Edit extends HttpServlet {

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

            int cdId = Integer.parseInt((String) inputData.get("cartDetailId"));
            int qty = Integer.parseInt((String) inputData.get("quantity"));

            CartDetail cartDetail = new CartDetail()
                    .setCartDetailId(cdId)
                    .setQuantity(qty)
                    .setUpdatedDate(Helper.CurrentDate.getDate())
                    .setUpdatedBy((String) session.getAttribute("username"))
            ;

            new BusinessLogic.FrontOffice.CartDetail.BllFo_Edit().businessLogic(cartDetail);
            out.print("Changes saved.");
        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }
}
