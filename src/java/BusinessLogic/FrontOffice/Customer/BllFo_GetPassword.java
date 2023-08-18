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
public class BllFo_GetPassword extends Bll_Super<Customer> {

    @Override
    public ArrayList<Customer> businessLogic(Customer domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Customer> execute(Connection conn, Customer domain) throws SQLException {
        return new DataAccess.FrontOffice.Customer.DalFo_GetPassword(conn).run(domain);

    }
    
    public void checkPassword(Customer domain) throws Exception {
        //check customer current password
        ArrayList<Customer> customer = this.businessLogic(new Customer().setUsername(domain.getUsername()));
        String dbCurrentPass = customer.get(0).getPassword();

        //throw error if not same with record in db
        if (!domain.getPassword().equals(dbCurrentPass)) {
            throw new Exception("This is not your current password, please try again.");
        }
    }

}
