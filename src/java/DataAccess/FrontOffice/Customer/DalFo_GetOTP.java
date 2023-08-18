package DataAccess.FrontOffice.Customer;

import Model.Customer;
import DataAccess.Dal_Super;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author vinnie chin
 */
public class DalFo_GetOTP extends Dal_Super<Customer>{

    public DalFo_GetOTP(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
      return "SELECT USERNAME "
           + "FROM CUSTOMER "
           + "WHERE MAIL = ? "
           + "AND OTP = ? ";

    }
    
    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
          stmt.setString(1, domain.getMail());
          stmt.setString(2, domain.getRandomOTP());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
      return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected Customer domainMapping(ResultSet rs) throws SQLException {
        return
        new Customer().setUsername(rs.getString("USERNAME"));
  
    }
}
