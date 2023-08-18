package BusinessLogic.FrontOffice.ProductImage;

import BusinessLogic.Bll_Super;
import Model.ProductImage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public class BllFo_Get extends Bll_Super<ProductImage>{

    @Override
    public ArrayList<ProductImage> businessLogic(ProductImage domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<ProductImage> execute(Connection conn, ProductImage domain) throws SQLException {
        return new DataAccess.FrontOffice.ProductImage.DalFo_GetById(conn).run(domain);
    }
    
}
