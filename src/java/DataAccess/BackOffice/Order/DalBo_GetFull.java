package DataAccess.BackOffice.Order;

import DataAccess.Dal_Super;

import Model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class DalBo_GetFull extends Dal_Super<Order> {

    public DalBo_GetFull(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "OD.ORDERID, "
                + "OD.ORDERNO, "
                + "OD.PRICE, "
                + "OD.STATUS, "
                + "OD.CREATEDDATE, "
                + "OD.CREATEDBY, "
                + "OD.UPDATEDDATE, "
                + "OD.UPDATEDBY "
                + "FROM \"ORDER\" OD ";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Order domain) throws SQLException {

    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected Order domainMapping(ResultSet rs) throws SQLException {
        return new Order()
                .setOrderId(rs.getInt("ORDERID"))
                .setOrderNo(rs.getString("ORDERNO"))
                .setPrice(rs.getDouble("PRICE"))
                .setStatus(rs.getString("STATUS"))
                .setCreatedDate(rs.getTimestamp("CREATEDDATE"))
                .setCreatedBy(rs.getString("CREATEDBY"))
                .setUpdatedDate(rs.getTimestamp("UPDATEDDATE"))
                .setUpdatedBy(rs.getString("UPDATEDBY"));

    }

}
