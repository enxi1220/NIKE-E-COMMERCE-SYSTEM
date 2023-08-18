package BusinessLogic.BackOffice.Product;

import BusinessLogic.Bll_Super;
import Model.Product;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tham Jun Yuan
 */
public class BllBo_Deactivate extends Bll_Super<Product>{

    @Override
    public ArrayList<Product> businessLogic(Product domain) throws Exception {
        domain.setUpdatedDate(Helper.CurrentDate.getDate());
        return super.run(domain);
    }

    @Override
    protected ArrayList<Product> execute(Connection conn, Product domain) throws SQLException {
        return new DataAccess.BackOffice.Product.DalBo_Deactivate(conn).run(domain);
    }
    
}
