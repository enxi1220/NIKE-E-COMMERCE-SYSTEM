package DataAccess.FrontOffice.Order;

import DataAccess.Dal_Super;
import Model.Order;
import Model.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinnie chin
 */
public class DalFo_GetRecent extends Dal_Super<Order> {

    public DalFo_GetRecent(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "OD.PRODUCTID, "
                + "OD.PRODUCTNAME, "
                + "OD.COLOR, "
                + "OD.SIZE, "
                + "OD.QUANTITY, "
                + "OD.PRICE, "
                + "OD.CREATEDDATE AS CREATEDDATE "
                + "FROM ORDERDETAIL OD "
                + "JOIN \"ORDER\" O ON O.ORDERID = OD.ORDERID "
                + "JOIN CUSTOMER C ON C.CUSTOMERID = O.CUSTOMERID "
                + "WHERE C.CUSTOMERID = ? "
                + "ORDER BY OD.CREATEDDATE DESC "
                + "FETCH FIRST 8 ROWS ONLY ";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Order domain) throws SQLException {
        stmt.setInt(1, domain.getCustomerId());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected Order domainMapping(ResultSet rs) throws SQLException {
        ArrayList<OrderDetail> recentOrders = new ArrayList<>();
        recentOrders.add(new OrderDetail()
                .setProductId(rs.getInt("PRODUCTID"))
                .setProductName(rs.getString("PRODUCTNAME"))
                .setColor(rs.getString("COLOR"))
                .setSize(rs.getString("SIZE"))
                .setQuantity(rs.getInt("QUANTITY"))
                .setPrice(rs.getDouble("PRICE"))
                .setCreatedDate(rs.getTimestamp("CREATEDDATE"))
        );

        return new Order().setOrderDetail(recentOrders);

    }
}
