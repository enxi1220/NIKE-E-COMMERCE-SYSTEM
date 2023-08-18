package BusinessLogic.FrontOffice.Order;

import BusinessLogic.Bll_Super;
import Model.Order;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public class BllFo_Edit extends Bll_Super<Order> {

    @Override
    public ArrayList<Order> businessLogic(Order domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Order> execute(Connection conn, Order domain) throws SQLException {
        return new DataAccess.FrontOffice.Order.DalFo_Edit(conn).run(domain);
    }

}
