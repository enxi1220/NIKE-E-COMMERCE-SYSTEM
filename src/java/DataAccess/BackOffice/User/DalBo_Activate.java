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
public class DalBo_Activate extends Dal_Super<User> {

    public DalBo_Activate(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "UPDATE \"USER\" SET "
                + "STATUS = 'Activate', "   
                 + "UPDATEDDATE = ?, "
                + "UPDATEDBY = ?  "
                + "WHERE USERNAME = ? "
             ;
    }

     @Override
    protected void prepareParameters(PreparedStatement stmt, User domain) throws SQLException {
        stmt.setTimestamp(1, domain.getUpdatedDate());
        stmt.setString(2, domain.getUpdatedBy());
        stmt.setString(3, domain.getUsername()); 
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Update;
    }
}


