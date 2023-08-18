package BusinessLogic.FrontOffice.Cart;

import BusinessLogic.Bll_Super;
import Model.Cart;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public class Bll_NewTemp extends Bll_Super<Cart>{

    @Override
    public ArrayList<Cart> businessLogic(Cart domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Cart> execute(Connection conn, Cart domain) throws SQLException {
        new DataAccess.FrontOffice.Cart.DalFo_New(conn).run(domain);
        ArrayList<Cart> carts = new DataAccess.FrontOffice.Cart.DalFo_GetPrimaryKey(conn).run(domain);
        int cartId = carts.get(0).getCartId();
        new DataAccess.FrontOffice.CartDetail.DalFo_New(conn).run(domain.getCartDetail().get(0)
                                                                        .setCartId(cartId));
        return carts;
    }
    
}
