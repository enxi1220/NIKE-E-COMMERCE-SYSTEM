package DataAccess.FrontOffice.Courier;

import DataAccess.Dal_Super;
import Helper.Constant;
import Model.Courier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_GetFull extends Dal_Super<Courier>{

    public DalFo_GetFull(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                    + "COURIERID, "
                    + "COURIERNAME, "
                    + "COURIERPRICE "
                + "FROM COURIER "
                + "WHERE STATUS = ?"
                ;
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Courier domain) throws SQLException {
        stmt.setString(1, Helper.Constant.getStatus(Constant.StatusEnum.Activate));
    }
    
    @Override
    protected Courier domainMapping(ResultSet rs) throws SQLException {
        return new Courier()
                .setCourierId(rs.getInt("COURIERID"))
                .setCourierName(rs.getString("COURIERNAME"))
                .setCourierPrice(rs.getDouble("COURIERPRICE"))
                ;
    }
    
}
