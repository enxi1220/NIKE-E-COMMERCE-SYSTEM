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
public class DalBo_Edit extends Dal_Super<User> {

    public DalBo_Edit(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "UPDATE \"USER\" SET "
                + "\"NAME\" = ?, "
                + "PHONE = ?, "
                + "MAIL = ?, "
                + "UPDATEDDATE = ?, "
                + "UPDATEDBY = ?  "
                + "WHERE USERNAME = ? "
             ;
    }

     @Override
    protected void prepareParameters(PreparedStatement stmt, User domain) throws SQLException {
        stmt.setString(1, domain.getName());
        stmt.setString(2, domain.getPhone());
        stmt.setString(3, domain.getMail());
        stmt.setTimestamp(4, domain.getUpdatedDate());
        stmt.setString(5, domain.getUpdatedBy());
        stmt.setString(6, domain.getUsername()); 
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Update;
    }
}


