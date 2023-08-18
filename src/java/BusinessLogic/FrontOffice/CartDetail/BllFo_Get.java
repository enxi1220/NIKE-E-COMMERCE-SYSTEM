package BusinessLogic.FrontOffice.CartDetail;

import BusinessLogic.Bll_Super;
import Model.CartDetail;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public class BllFo_Get extends Bll_Super<CartDetail>{

    @Override
    public ArrayList<CartDetail> businessLogic(CartDetail domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<CartDetail> execute(Connection conn, CartDetail domain) throws SQLException {
        return new DataAccess.FrontOffice.CartDetail.DalFo_Get(conn).run(domain);
    }
    
}
