package DataAccess.FrontOffice.Customer;

import Model.Customer;
import DataAccess.Dal_Super;
import Helper.Constant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author vinnie chin
 */
public class DalFo_GetCustomerLogin extends Dal_Super<Customer>{

    public DalFo_GetCustomerLogin(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
      return "SELECT * "
           + "FROM CUSTOMER CUST "
           + "WHERE CUST.USERNAME = ? "
           + "AND CUST.PASSWORD = ? "
           + "AND CUST.STATUS = ? ";

    }
    
    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
          stmt.setString(1, domain.getUsername());
          stmt.setString(2, domain.getPassword());
          stmt.setString(3, Constant.getStatus(Constant.StatusEnum.Activate));
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
      return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected Customer domainMapping(ResultSet rs) throws SQLException {
        return
        new Customer()
        .setUsername(rs.getString("USERNAME"))
        .setCustomerId(rs.getInt("CUSTOMERID"))
        .setStatus(rs.getString("STATUS"));
    }
}
