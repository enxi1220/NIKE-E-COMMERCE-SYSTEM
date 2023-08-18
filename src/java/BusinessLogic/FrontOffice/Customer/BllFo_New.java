package BusinessLogic.FrontOffice.Customer;

import Model.Customer;
import BusinessLogic.Bll_Super;
import Model.Cart;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author vinnie chin
 */
public class BllFo_New extends Bll_Super<Customer> {

    @Override
    public ArrayList<Customer> businessLogic(Customer domain) throws Exception {
        
        registerCheck(domain);
        
        domain.setCreatedBy(domain.getUsername()); 
        domain.setCreatedDate(Helper.CurrentDate.getDate());
        return super.run(domain);
    }

    @Override
    protected ArrayList<Customer> execute(Connection conn, Customer domain) throws SQLException {

        new DataAccess.FrontOffice.Customer.DalFo_New(conn).run(domain);
        
        ArrayList<Customer> customer = new DataAccess.FrontOffice.Customer.DalFo_GetPrimaryKey(conn).run(domain);
        int customerId = customer.get(0).getCustomerId();

        new DataAccess.FrontOffice.Cart.DalFo_New(conn).run(
                new Cart().setCustomerId(customerId)
                .setCreatedBy(domain.getCreatedBy())
                .setCreatedDate(Helper.CurrentDate.getDate())
            );

        return null;
    }
    
    public void registerCheck(Customer domain) throws Exception {
        
        String duplicateData="";
        
        ArrayList<Customer> customers = new BllFo_GetFull().businessLogic(new Customer());
        // Loop through all customers record to check if 
        // the new registration username and email have duplicate
        for (Customer cust : customers) {
            if (domain.getUsername().equals(cust.getUsername()))
                duplicateData += "Username has been registered, try again.";
           
            if (domain.getMail().equals(cust.getMail()))
                duplicateData +="Email has been registered, try again.";
        }
        
        if(!duplicateData.isEmpty())
            throw new Exception(duplicateData);
    }
    
}
