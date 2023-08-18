package DataAccess.BackOffice.Courier;

import DataAccess.Dal_Super;

import Model.Courier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class DalBo_Get extends Dal_Super<Courier> {

    public DalBo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "COURIERID, "
                + "COURIERNAME, "
                + "COURIERPRICE, "
                + "STATUS "
                + "FROM COURIER "
                + "WHERE COURIERID = ?";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Courier domain) throws SQLException {
        stmt.setInt(1, domain.getCourierId());
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected Courier domainMapping(ResultSet rs) throws SQLException {
        return new Courier()
                .setCourierId(rs.getInt("COURIERID"))
                .setCourierName(rs.getString("COURIERNAME"))
                .setCourierPrice(rs.getDouble("COURIERPRICE"))
                .setStatus(rs.getString("STATUS"));

    }

}
