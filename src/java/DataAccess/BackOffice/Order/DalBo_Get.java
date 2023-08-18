package DataAccess.BackOffice.Order;

import DataAccess.Dal_Super;
import Model.Order;
import Model.Customer;
import Model.Courier;
import Model.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class DalBo_Get extends Dal_Super<Order> {

    public DalBo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "O.ORDERID, "
                + "O.ORDERNO, "
                + "O.TRACKINGNO, "
                + "O.RECEIVERNAME, "
                + "O.PRICE, "
                + "O.DELIVERYADDRESS, "
                + "CTM.MAIL, "
                + "CTM.PHONE, "
                + "CR.COURIERNAME, "
                + "O.DELIVERYFEE, "
                + "O.STATUS, "
                + "OD.PRODUCTNAME, "
                + "OD.COLOR, "
                + "OD.\"SIZE\", "
                + "OD.QUANTITY, "
                + "OD.PRICE AS ODPRICE, "
                + "OD.PRODUCTDETAILID "
                + "FROM \"ORDER\" O "
                + "JOIN CUSTOMER CTM ON CTM.CUSTOMERID = O.CUSTOMERID "
                + "JOIN COURIER CR ON O.COURIERID = CR.COURIERID "
                + "JOIN ORDERDETAIL OD ON OD.ORDERID = O.ORDERID "
                + "WHERE O.ORDERID = ?";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Order domain) throws SQLException {
        stmt.setInt(1, domain.getOrderId());
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected Order domainMapping(ResultSet rs) throws SQLException {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetail()
                .setProductName(rs.getString("PRODUCTNAME"))
                .setColor(rs.getString("COLOR"))
                .setSize(rs.getString("SIZE"))
                .setQuantity(rs.getInt("QUANTITY"))
                .setPrice(rs.getDouble("ODPRICE"))
                .setProductDetailId(rs.getInt("PRODUCTDETAILID"))
        );

        return new Order()
                .setOrderId(rs.getInt("ORDERID"))
                .setOrderNo(rs.getString("ORDERNO"))
                .setTrackingNo(rs.getString("TRACKINGNO"))
                .setReceiverName(rs.getString("RECEIVERNAME"))
                .setPrice(rs.getDouble("PRICE"))
                .setDeliveryAddress(rs.getString("DELIVERYADDRESS"))
                .setCustomer(new Customer().setMail(rs.getString("MAIL"))
                        .setPhone(rs.getString("PHONE")))
                .setCourier(new Courier().setCourierName(rs.getString("COURIERNAME")))
                .setDeliveryFee(rs.getDouble("DELIVERYFEE"))
                .setStatus(rs.getString("STATUS"))
                .setOrderDetail(orderDetails);
    }

}
