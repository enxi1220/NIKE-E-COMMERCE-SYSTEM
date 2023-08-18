package DataAccess.FrontOffice.Customer;

import Model.Customer;
import DataAccess.Dal_Super;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author vinnie chin
 */
public class DalFo_GetLogin extends Dal_Super<Customer>{

    public DalFo_GetLogin(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
      return "SELECT * "
           + "FROM CUSTOMER CUST "
           + "WHERE CUST.USERNAME = ? "
           + "AND CUST.PASSWORD = ? ";

    }
    
    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
          stmt.setString(1, domain.getUsername());
          stmt.setString(2, domain.getPassword());
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
