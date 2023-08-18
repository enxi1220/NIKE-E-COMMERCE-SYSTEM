package BusinessLogic.FrontOffice.Customer;

import Model.Customer;
import BusinessLogic.Bll_Super;
import Helper.Constant;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author vinnie chin
 */
public class BllFo_GetLogin extends Bll_Super<Customer> {
    
    @Override
    public ArrayList<Customer> businessLogic(Customer domain) throws Exception {
        return super.run(domain);
    }
    
    @Override
    protected ArrayList<Customer> execute(Connection conn, Customer domain) throws SQLException {
        return new DataAccess.FrontOffice.Customer.DalFo_GetLogin(conn).run(domain);
    }
    
    public ArrayList<Customer> checkCustLogin(Customer domain) throws Exception {
        
        // Validate if the username is exist in db
        ArrayList<Customer> customerExist = new BusinessLogic.FrontOffice.Customer.BllFo_Get().businessLogic(new Customer().setUsername(domain.getUsername()));
        if(customerExist.isEmpty()){
           throw new Exception("This username has not been registered yet.");
        }
        
        ArrayList<Customer> customerLogin = this.businessLogic(domain);
        // Validate if the username and password are matched in db
        if(customerLogin.isEmpty()){
            throw new Exception("Username and Password Not Matched.");
        // Check the customer status, 
        // deactivate (deleted account) cannot login anymore without assistance of staff / admin
        }else if(customerLogin.get(0).getStatus().equals(Constant.getStatus(Constant.StatusEnum.Deactivate))) {
            throw new Exception("This account has been deactivated, you can contact us for further assist.");
        }
        
        return customerLogin;
    }

}
