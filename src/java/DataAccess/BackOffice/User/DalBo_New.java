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
public class DalBo_New extends Dal_Super<User> {

    public DalBo_New(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return 
                "INSERT INTO \"USER\" ("
                + "USERGROUPID, "
                + "USERNAME, "       
                + "\"NAME\", "
                + "PASSWORD, "
                + "STATUS, "
                + "PHONE, "
                + "MAIL, "
                + "CREATEDDATE, "
                + "CREATEDBY) "
             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, User domain) throws SQLException {
        stmt.setInt(1, domain.getUserGroupId());
        stmt.setString(2, domain.getUsername()); 
        stmt.setString(3, domain.getName());
        stmt.setString(4, domain.getPassword());
        stmt.setString(5, domain.getStatus());
        stmt.setString(6, domain.getPhone());
        stmt.setString(7, domain.getMail());
        stmt.setTimestamp(8, domain.getCreatedDate());
        stmt.setString(9, domain.getCreatedBy());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Update;
    }

}
