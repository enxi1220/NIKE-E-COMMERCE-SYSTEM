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
public class DalBo_GetFull extends Dal_Super<User> {

    public DalBo_GetFull(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "USR.USERNAME, "
                + "USR.\"NAME\", "
                + "USRG.USERGROUPNAME, "
                + "USR.STATUS, "
                + "USR.CREATEDDATE, "
                + "USR.CREATEDBY, "
                + "USR.UPDATEDDATE, "
                + "USR.UPDATEDBY "
                + "FROM \"USER\" USR "
                + "JOIN USERGROUP USRG ON USR.USERGROUPID = USRG.USERGROUPID ";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, User domain) throws SQLException {

    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected User domainMapping(ResultSet rs) throws SQLException {
        return new User()
                .setUsername(rs.getString("USERNAME"))
                .setName(rs.getString("NAME"))
                .setStatus(rs.getString("STATUS"))
                .setUserGroup(new UserGroup().setUserGroupName(rs.getString("USERGROUPNAME")))
                .setCreatedDate(rs.getTimestamp("CREATEDDATE"))
                .setCreatedBy(rs.getString("CREATEDBY"))
                .setUpdatedDate(rs.getTimestamp("UPDATEDDATE"))
                .setUpdatedBy(rs.getString("UPDATEDBY"));
        
    }

}
