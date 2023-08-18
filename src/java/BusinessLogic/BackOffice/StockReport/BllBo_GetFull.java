package BusinessLogic.BackOffice.StockReport;

import Model.Product;
import BusinessLogic.Bll_Super;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Linyi
 */
public class BllBo_GetFull extends Bll_Super<Product> {

    @Override
    public ArrayList<Product> businessLogic(Product domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Product> execute(Connection conn, Product domain) throws SQLException {
        ArrayList<Product> products = new DataAccess.BackOffice.StockReport.DalBo_GetFull(conn).run(domain);
        return products;
    }
}
