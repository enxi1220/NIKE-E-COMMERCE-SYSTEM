package BusinessLogic.BackOffice.ProductImage;

import BusinessLogic.Bll_Super;
import Model.ProductImage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class BllBo_Get extends Bll_Super<ProductImage>{

    @Override
    public ArrayList<ProductImage> businessLogic(ProductImage domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<ProductImage> execute(Connection conn, ProductImage domain) throws SQLException {
        return new DataAccess.BackOffice.ProductImage.DalBo_Get(conn).run(domain);
    }
    
}
