package BusinessLogic.FrontOffice.Customer;

import Model.Customer;
import BusinessLogic.Bll_Super;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author vinnie chin
 */
public class BllFo_DelOTP extends Bll_Super<Customer> {

    @Override
    public ArrayList<Customer> businessLogic(Customer domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Customer> execute(Connection conn, Customer domain) throws SQLException {
  
        return new DataAccess.FrontOffice.Customer.DalFo_DelOTP(conn).run(domain);

    }

}
