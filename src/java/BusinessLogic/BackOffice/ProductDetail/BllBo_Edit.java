package BusinessLogic.BackOffice.ProductDetail;

import BusinessLogic.Bll_Super;
import Model.Product;
import Model.ProductDetail;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class BllBo_Edit extends Bll_Super<ProductDetail>{

    @Override
    public ArrayList<ProductDetail> businessLogic(ProductDetail domain) throws Exception {
        
        domain.setUpdatedDate(Helper.CurrentDate.getDate());
        
        return super.run(domain);
    }

    @Override
    protected ArrayList<ProductDetail> execute(Connection conn, ProductDetail domain) throws SQLException {
        new DataAccess.BackOffice.ProductDetail.DalBo_Edit(conn).run(domain);
        
        new DataAccess.BackOffice.Product.DalBo_Update(conn).run(new Product().setUpdatedDate(domain.getUpdatedDate())
                                                                                .setUpdatedBy(domain.getUpdatedBy())
                                                                                .setProductId(domain.getProductId()));
        
        return null;
    }
    
}
