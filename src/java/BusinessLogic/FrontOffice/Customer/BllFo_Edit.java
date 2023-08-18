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
public class BllFo_Edit extends Bll_Super<Customer> {

    @Override
    public ArrayList<Customer> businessLogic(Customer domain) throws Exception {

        editCheck(domain);

        domain.setUpdatedDate(Helper.CurrentDate.getDate());
        domain.setUpdatedBy(domain.getUsername());

        return super.run(domain);
    }

    @Override
    protected ArrayList<Customer> execute(Connection conn, Customer domain) throws SQLException {

        return new DataAccess.FrontOffice.Customer.DalFo_Edit(conn).run(domain);

    }

    public void editCheck(Customer domain) throws Exception {

        //Get the customer username with email
        ArrayList<Customer> custUsername = new BllFo_GetEmail().businessLogic(new Customer().setMail(domain.getMail()));
        String username = "";
        if (custUsername != null && custUsername.size() != 0) {
            username = custUsername.get(0).getUsername();
        }

        //If the username get is different with the current customer
        if (!username.equals(domain.getUsername())) {
            //Get all customer data
            ArrayList<Customer> customers = new BllFo_GetFull().businessLogic(new Customer());
            //Loop through to see if the edited email is same with other customers
            for (Customer cust : customers) {
                if (domain.getMail().equals(cust.getMail())) {
                    throw new Exception("This email is belongs to others, try again.");
                }
            }
        }
    }

}
