package DataAccess.FrontOffice.Customer;

import DataAccess.FrontOffice.Customer.*;
import DataAccess.Dal_Super;
import Model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vinnie chin
 */
public class DalFo_GetPassword extends Dal_Super<Customer>{

    public DalFo_GetPassword(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT PASSWORD "
                + "FROM CUSTOMER "
                + "WHERE USERNAME = ?";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
          stmt.setString(1, domain.getUsername());
    }
    
    @Override
    protected Customer domainMapping(ResultSet rs) throws SQLException {
        return new Customer().setPassword(rs.getString("PASSWORD"));      
    }
}
