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
public class DalBo_GetFull extends Dal_Super<Courier> {

    public DalBo_GetFull(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "CR.COURIERID, "
                + "CR.COURIERNAME, "
                + "CR.COURIERPRICE, "
                + "CR.STATUS, "
                + "CR.CREATEDDATE, "
                + "CR.CREATEDBY, "
                + "CR.UPDATEDDATE, "
                + "CR.UPDATEDBY "
                + "FROM COURIER CR ";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Courier domain) throws SQLException {

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
                .setStatus(rs.getString("STATUS"))
                .setCreatedDate(rs.getTimestamp("CREATEDDATE"))
                .setCreatedBy(rs.getString("CREATEDBY"))
                .setUpdatedDate(rs.getTimestamp("UPDATEDDATE"))
                .setUpdatedBy(rs.getString("UPDATEDBY"));

    }

}
