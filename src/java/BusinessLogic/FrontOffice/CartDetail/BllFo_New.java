package BusinessLogic.FrontOffice.CartDetail;

import BusinessLogic.Bll_Super;
import Model.Cart;
import Model.CartDetail;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.http.HttpSession;

public class BllFo_New extends Bll_Super<CartDetail> {

    @Override
    public ArrayList<CartDetail> businessLogic(CartDetail domain) throws Exception {
//        get cart id into domain
        ArrayList<Cart> carts = new BusinessLogic.FrontOffice.Cart.BllFo_Get().businessLogic(
                new Cart().setCustomerId(domain.getCustomerId())
        );
        System.out.println("1");
        domain.setCartId(carts.get(0).getCartId());
        System.out.println("1");
        
//        check if the item already in cart
        ArrayList<CartDetail> cartdetail = new BllFo_Get().businessLogic(domain);
        if (!cartdetail.isEmpty()) {
            throw new Exception("The item has been in the cart");
        }

        return super.run(domain);
    }

    @Override
    protected ArrayList<CartDetail> execute(Connection conn, CartDetail domain) throws SQLException {
        return new DataAccess.FrontOffice.CartDetail.DalFo_New(conn).run(domain);
    }

}
