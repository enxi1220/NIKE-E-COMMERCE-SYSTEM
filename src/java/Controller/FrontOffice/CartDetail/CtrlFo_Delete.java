package Controller.FrontOffice.CartDetail;

import Helper.Constant;
import Model.CartDetail;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Lim En Xi
 */
@WebServlet(name = "DeleteCartDetail", urlPatterns = {"/DeleteCartDetail"})
public class CtrlFo_Delete extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        //retrieve input
        String dataPosted = request.getReader().lines().collect(Collectors.joining());
        //json parser 
        JSONParser parser = new JSONParser();
        try {

            JSONObject inputData = (JSONObject) parser.parse(dataPosted);

            int cdId = Integer.parseInt((String) inputData.get("cartDetailId"));
            
            CartDetail cartDetail = new CartDetail()
                    .setCartDetailId(cdId)
                    ;
            
            new BusinessLogic.FrontOffice.CartDetail.BllFo_Delete().businessLogic(cartDetail);
            out.print("Item is deleted");
        } catch (Exception e) {
            response.setStatus(500);
            out.print(e.getMessage());
        }
    }
}
