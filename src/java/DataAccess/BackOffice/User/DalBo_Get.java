package DataAccess.BackOffice.User;

import DataAccess.Dal_Super;

import Model.User;
import Model.UserGroup;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Linyi
 */
public class DalBo_Get extends Dal_Super<User> {

    public DalBo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "USR.USERNAME, "
                + "USR.\"NAME\", "
                + "USR.MAIL, "
                + "USR.PHONE, "
                + "USRG.USERGROUPNAME, "
                + "USR.STATUS "
                + "FROM \"USER\" USR "
                + "JOIN USERGROUP USRG ON USR.USERGROUPID = USRG.USERGROUPID "
                + "WHERE USR.USERNAME = ?" ;
            
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, User domain) throws SQLException {
        stmt.setString(1,domain.getUsername());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected User domainMapping(ResultSet rs) throws SQLException {
        return new User()
                .setUsername(rs.getString("USERNAME"))
                .setName(rs.getString("NAME"))
                .setPhone(rs.getString("PHONE"))
                .setMail(rs.getString("MAIL"))
                .setStatus(rs.getString("STATUS"))
                .setUserGroup(new UserGroup().setUserGroupName(rs.getString("USERGROUPNAME")))
                ;
        
    }

}
