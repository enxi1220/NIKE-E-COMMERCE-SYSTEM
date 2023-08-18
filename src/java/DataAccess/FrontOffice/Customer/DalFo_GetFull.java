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
public class DalFo_GetFull extends Dal_Super<Customer>{

    public DalFo_GetFull(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
      return "SELECT *"
           + "FROM CUSTOMER";
    }
    
    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
         
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
      return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected Customer domainMapping(ResultSet rs) throws SQLException {
        return
        new Customer().setUsername(rs.getString("USERNAME")).setMail(rs.getString("MAIL"));
    }
}
