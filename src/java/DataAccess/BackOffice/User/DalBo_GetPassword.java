package DataAccess.BackOffice.User;


import DataAccess.Dal_Super;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Linyi
 */

public class DalBo_GetPassword extends Dal_Super<User>{

    public DalBo_GetPassword(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT PASSWORD "
                + "FROM \"USER\" "
                + "WHERE USERNAME = ?";
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, User domain) throws SQLException {
          stmt.setString(1, domain.getUsername());
    }
    
    @Override
    protected User domainMapping(ResultSet rs) throws SQLException {
        return new User().setPassword(rs.getString("PASSWORD"));      
    }
}
