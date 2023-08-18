package DataAccess.FrontOffice.Customer;

import Model.Customer;
import DataAccess.Dal_Super;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author vinnie chin
 */
public class DalFo_NewOTP extends Dal_Super<Customer>{

    public DalFo_NewOTP(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        
      return "UPDATE CUSTOMER SET "
           + "OTP = ? "
           + "WHERE MAIL = ? ";
    }
    
    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
        stmt.setString(1, domain.getRandomOTP());
        stmt.setString(2, domain.getMail());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
      return Dal_Super.ExecutionTypeEnum.Update;
    }

}
