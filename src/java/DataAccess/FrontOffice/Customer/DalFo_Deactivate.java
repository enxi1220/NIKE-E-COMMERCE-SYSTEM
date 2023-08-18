package DataAccess.FrontOffice.Customer;

import Model.Customer;
import DataAccess.Dal_Super;
import Helper.Constant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author vinnie chin
 */
public class DalFo_Deactivate extends Dal_Super<Customer>{

    public DalFo_Deactivate(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
      return "UPDATE CUSTOMER SET "
              + "STATUS = ? "
           + "WHERE USERNAME = ? ";
    }
    
    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
        stmt.setString(1, Constant.getStatus(Constant.StatusEnum.Deactivate));
        stmt.setString(2, domain.getUsername());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
      return Dal_Super.ExecutionTypeEnum.Update;
    }
}
