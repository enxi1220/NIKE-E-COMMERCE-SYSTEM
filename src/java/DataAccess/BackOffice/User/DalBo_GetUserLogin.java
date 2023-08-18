package DataAccess.BackOffice.User;

import Model.User;
import DataAccess.Dal_Super;
import Helper.Constant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Linyi
 */
public class DalBo_GetUserLogin extends Dal_Super<User>{

    public DalBo_GetUserLogin(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
      return "SELECT * "
           + "FROM \"USER\" USR "
           + "WHERE USR.USERNAME = ? "
           + "AND USR.PASSWORD = ? "
           + "AND USR.STATUS = ? ";

    }
    
    @Override
    protected void prepareParameters(PreparedStatement stmt, User domain) throws SQLException {
          stmt.setString(1, domain.getUsername());
          stmt.setString(2, domain.getPassword());
          stmt.setString(3, Constant.getStatus(Constant.StatusEnum.Activate));
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
      return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected User domainMapping(ResultSet rs) throws SQLException {
        return
        new User()
        .setUsername(rs.getString("USERNAME"))
        .setUserId(rs.getInt("USERID"))
        .setStatus(rs.getString("STATUS"));
    }
}
