package BusinessLogic.FrontOffice.CartDetail;

import BusinessLogic.Bll_Super;
import Model.CartDetail;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**maybe useless
 *
 * @author Lim En Xi
 */
public class BllFo_Edit extends Bll_Super<CartDetail>{

    @Override
    public ArrayList<CartDetail> businessLogic(CartDetail domain) throws Exception {      
        return super.run(domain);
    }

    @Override
    public ArrayList<CartDetail> execute(Connection conn, CartDetail domain) throws SQLException {
        return new DataAccess.FrontOffice.CartDetail.DalFo_Edit(conn).run(domain);
    }
    
}
