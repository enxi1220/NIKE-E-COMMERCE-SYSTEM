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
public class BllFo_EditPassword extends Bll_Super<Customer> {

    @Override
    public ArrayList<Customer> businessLogic(Customer domain) throws Exception {
        domain.setUpdatedDate(Helper.CurrentDate.getDate());
        domain.setUpdatedBy(domain.getUsername());
        return super.run(domain);
    }
    
    @Override
    protected ArrayList<Customer> execute(Connection conn, Customer domain) throws SQLException {

        return new DataAccess.FrontOffice.Customer.DalFo_EditPassword(conn).run(domain);

    }

}
