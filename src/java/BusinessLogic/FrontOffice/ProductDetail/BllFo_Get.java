package BusinessLogic.FrontOffice.ProductDetail;

import BusinessLogic.Bll_Super;
import Model.ProductDetail;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public class BllFo_Get extends Bll_Super<ProductDetail>{

    @Override
    public ArrayList<ProductDetail> businessLogic(ProductDetail domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<ProductDetail> execute(Connection conn, ProductDetail domain) throws SQLException {
        return new DataAccess.FrontOffice.ProductDetail.DalFo_Get(conn).run(domain);
    }
    
}
