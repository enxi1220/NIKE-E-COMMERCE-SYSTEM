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
public class BllFo_GetEmail extends Bll_Super<Customer> {

    @Override
    public ArrayList<Customer> businessLogic(Customer domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Customer> execute(Connection conn, Customer domain) throws SQLException {
        return new DataAccess.FrontOffice.Customer.DalFo_GetEmail(conn).run(domain);

    }
    
    public String checkEmail(Customer domain) throws Exception {
        //Call the business logic layer of this class for checking 
        //if the email customer submitted to get OTP is an existing email in db
        ArrayList<Customer> customer = this.businessLogic(new Customer().setMail(domain.getMail()));
        
        if (customer.isEmpty()) {
            throw new Exception("This email has not been registered.");
        }
        
        //If exist call the email sender in helper package to send random number OTP to customer
        //Store the sent OTP 
        String randomOTP = new Helper.ResetPassEmailSender().sendMail(domain.getMail());
        //Insert the OTP to the customer record for later validation purpose
        new BusinessLogic.FrontOffice.Customer.BllFo_NewOTP().businessLogic(new Customer().setMail(domain.getMail()).setRandomOTP(randomOTP));

        return randomOTP;
        
    }

}
