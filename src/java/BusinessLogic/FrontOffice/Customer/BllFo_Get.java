/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic.FrontOffice.Customer;

import BusinessLogic.Bll_Super;
import Model.Customer;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinnie chin
 */
public class BllFo_Get extends Bll_Super<Customer>{

    @Override
    public ArrayList<Customer> businessLogic(Customer domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Customer> execute(Connection conn, Customer domain) throws SQLException {

        ArrayList<Customer> customerDetails = new DataAccess.FrontOffice.Customer.DalFo_Get(conn).run(domain);

        //set profile image to customer data retrieved
        //separated as the sql statement of get customer data has "ORDER BY", image blob data type cannot be with the keyword
        for (Customer cust : customerDetails) {
            ArrayList<Customer> image = new DataAccess.FrontOffice.Customer.DalFo_GetImage(conn).run(domain);
        
            if(image != null)
                cust.setImageAsBase64(image.get(0).getImageAsBase64());
        }
        
        return customerDetails;
    }
    
}
