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
public class DalFo_DelOTP extends Dal_Super<Customer>{

    public DalFo_DelOTP(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
      return "UPDATE CUSTOMER SET "
              + "OTP = NULL "
           + "WHERE USERNAME = ? ";
    }
    
    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
        stmt.setString(1, domain.getUsername());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
      return Dal_Super.ExecutionTypeEnum.Update;
    }
}
