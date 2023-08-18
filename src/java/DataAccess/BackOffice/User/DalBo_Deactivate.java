package DataAccess.BackOffice.User;

import Model.User;
import DataAccess.Dal_Super;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Linyi
 */
public class DalBo_Deactivate extends Dal_Super<User> {

    public DalBo_Deactivate(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "UPDATE \"USER\" SET "
                + "STATUS = ?, "  
               + "UPDATEDDATE = ?, "
                + "UPDATEDBY = ?  "
                + "WHERE USERNAME = ? "
             ;
    }

     @Override
    protected void prepareParameters(PreparedStatement stmt, User domain) throws SQLException {
        
        stmt.setString(1, domain.getStatus());
        stmt.setTimestamp(2, domain.getUpdatedDate());
        stmt.setString(3, domain.getUpdatedBy());
        stmt.setString(4, domain.getUsername()); 
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Update;
    }
}


