package DataAccess.FrontOffice.Order;

import DataAccess.Dal_Super;
import Model.Courier;
import Model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_GetFull extends Dal_Super<Order> {

    public DalFo_GetFull(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT O.ORDERID, "
                    + "O.ORDERNO, "
                    + "O.STATUS, "
                    + "C.COURIERNAME, "
                    + "O.TRACKINGNO, "
                    + "O.CREATEDDATE, "
                    + "O.PRICE, "
                    + "COUNT(OD.ORDERID) AS COUNT "
                + "FROM \"ORDER\" O "
                + "JOIN COURIER C ON O.COURIERID = C.COURIERID "
                + "JOIN ORDERDETAIL OD ON O.ORDERID = OD.ORDERID "
                + "JOIN CUSTOMER CU ON O.CUSTOMERID = CU.CUSTOMERID "
                + "WHERE CU.USERNAME = ? "
                + "GROUP BY O.ORDERID, O.ORDERNO, O.STATUS, C.COURIERNAME, O.TRACKINGNO, O.CREATEDDATE, O.PRICE "
                + "ORDER BY O.CREATEDDATE DESC";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Order domain) throws SQLException {
        stmt.setString(1, domain.getCustomer().getUsername());
    }

    @Override
    protected Order domainMapping(ResultSet rs) throws SQLException {
        return new Order().setOrderId(rs.getInt("ORDERID"))
                .setOrderNo(rs.getString("ORDERNO"))
                .setStatus(rs.getString("STATUS"))
                .setTrackingNo(rs.getString("TRACKINGNO"))
                .setCreatedDate(rs.getTimestamp("CREATEDDATE"))
                .setPrice(rs.getDouble("PRICE"))
                .setCount(rs.getInt("COUNT"))
                .setCourier(new Courier().setCourierName(rs.getString("COURIERNAME")));

    }
}
