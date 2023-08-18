package BusinessLogic.BackOffice.Order;

import Model.Order;
import BusinessLogic.Bll_Super;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class BllBo_Get extends Bll_Super<Order> {

    @Override
    public ArrayList<Order> businessLogic(Order domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Order> execute(Connection conn, Order domain) throws SQLException {
        return new DataAccess.BackOffice.Order.DalBo_Get(conn).run(domain);
    }
}
