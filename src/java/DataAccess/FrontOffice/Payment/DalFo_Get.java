package DataAccess.FrontOffice.Payment;

import DataAccess.Dal_Super;
import Model.Order;
import Model.OrderDetail;
import Model.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_Get extends Dal_Super<Payment>{

    public DalFo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                    + "P.PAYMENTNO, "
                    + "O.DELIVERYADDRESS, "
                    + "P.PAYMENTMETHOD, "
                    + "P.PRICE, "
                    + "P.DELIVERYFEE, "
                    + "P.CREATEDDATE, "
                    + "P.CUSTOMERNAME, "
                    + "O.STATUS, "
                    + "OD.PRODUCTNAME, "
                    + "OD.QUANTITY, "
                    + "OD.COLOR, "
                    + "OD.SIZE, "
                    + "OD.PRICE AS UNITPRICE "
                + "FROM PAYMENT P "
                + "JOIN \"ORDER\" O ON P.ORDERID = O.ORDERID "
                + "JOIN ORDERDETAIL OD ON O.ORDERID = OD.ORDERID "
                + "WHERE O.ORDERID = ?";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Payment domain) throws SQLException {
        stmt.setInt(1, domain.getOrderId());
    }
    
    @Override
    protected Payment domainMapping(ResultSet rs) throws SQLException {
        ArrayList<OrderDetail> orderDetail = new ArrayList<>();
        orderDetail.add(new OrderDetail().setProductName(rs.getString("PRODUCTNAME"))
                                         .setQuantity(rs.getInt("QUANTITY"))
                                         .setPrice(rs.getDouble("UNITPRICE"))
                                         .setColor(rs.getString("COLOR"))
                                         .setSize(rs.getString("SIZE"))
        );
        
        
        return new Payment().setPaymentNo(rs.getString("PAYMENTNO"))
                            .setCustomerName(rs.getString("CUSTOMERNAME"))
                            .setPaymentMethod(rs.getString("PAYMENTMETHOD"))
                            .setPrice(rs.getDouble("PRICE"))
                            .setDeliveryFee(rs.getDouble("DELIVERYFEE"))
                            .setCreatedDate(rs.getTimestamp("CREATEDDATE"))
                            .setOrder(new Order()
                                    .setDeliveryAddress(rs.getString("DELIVERYADDRESS"))
                                    .setStatus(rs.getString("STATUS"))
                                    .setOrderDetail(orderDetail)
                            )
                ;
    }
}
