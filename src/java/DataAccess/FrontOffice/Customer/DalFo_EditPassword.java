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
public class DalFo_EditPassword extends Dal_Super<Customer>{

    public DalFo_EditPassword(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        
      return "UPDATE CUSTOMER SET "
              + "PASSWORD = ?, "
              + "UPDATEDBY = ?, "
              + "UPDATEDDATE = ? "
           + "WHERE USERNAME = ? ";
    }
    
    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
        stmt.setString(1, domain.getPassword());
        stmt.setString(2, domain.getUpdatedBy());
        stmt.setTimestamp(3, domain.getUpdatedDate());
        stmt.setString(4, domain.getUsername());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
      return Dal_Super.ExecutionTypeEnum.Update;
    }

}
