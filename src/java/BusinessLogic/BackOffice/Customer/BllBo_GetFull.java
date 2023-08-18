/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BusinessLogic.BackOffice.Customer;

import Model.Customer;

import BusinessLogic.Bll_Super;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author Tham Jun Yuan
 */
public class BllBo_GetFull extends Bll_Super<Customer>{
    
    @Override
    public ArrayList<Customer> businessLogic(Customer domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Customer> execute(Connection conn, Customer domain) throws SQLException{
       return new DataAccess.BackOffice.Customer.DalBo_GetFull(conn).run(domain);
    }
    
}
