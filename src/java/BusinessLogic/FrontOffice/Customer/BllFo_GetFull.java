package BusinessLogic.FrontOffice.Customer;

import BusinessLogic.Bll_Super;
import Model.Customer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinnie chin
 */
public class BllFo_GetFull extends Bll_Super<Customer>{

    @Override
    public ArrayList<Customer> businessLogic(Customer domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Customer> execute(Connection conn, Customer domain) throws SQLException {
        return new DataAccess.FrontOffice.Customer.DalFo_GetFull(conn).run(domain);
    }
}
