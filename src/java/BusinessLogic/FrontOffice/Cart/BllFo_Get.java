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
public class BllFo_Get extends Bll_Super<Cart>{

    @Override
    public ArrayList<Cart> businessLogic(Cart domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Cart> execute(Connection conn, Cart domain) throws SQLException {
        return new DataAccess.FrontOffice.Cart.DalFo_Get(conn).run(domain);
    }
    
}
