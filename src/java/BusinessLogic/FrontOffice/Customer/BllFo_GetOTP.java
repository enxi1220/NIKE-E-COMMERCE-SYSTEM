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
public class BllFo_GetOTP extends Bll_Super<Customer> {
    
    public String checkOTP(Customer domain) throws Exception {
        ArrayList<Customer> customer = this.businessLogic(new Customer().setMail(domain.getMail()).setRandomOTP(domain.getRandomOTP()));
        
        if (customer.isEmpty()) {
            throw new Exception("The OTP entered is incorrect. Please check again.");
        }
        
        return customer.get(0).getUsername();
    }
    
    @Override
    public ArrayList<Customer> businessLogic(Customer domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Customer> execute(Connection conn, Customer domain) throws SQLException {
        return new DataAccess.FrontOffice.Customer.DalFo_GetOTP(conn).run(domain);

    }

}
