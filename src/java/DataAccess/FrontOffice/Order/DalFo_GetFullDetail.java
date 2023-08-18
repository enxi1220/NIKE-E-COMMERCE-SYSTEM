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
 * @author Lim En Xi
 */
public class DalFo_GetFullDetail extends Dal_Super<Order>{

    public DalFo_GetFullDetail(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT O.ORDERID, "
                    + "O.ORDERNO, "
                    + "O.STATUS, "
                    + "O.PRICE AS ORDERPRICE, "
                    + "O.DELIVERYFEE, "
                    + "OD.PRODUCTNAME, "
                    + "OD.PRODUCTDETAILID, "
                    + "OD.COLOR, "
                    + "OD.SIZE, "
                    + "OD.PRICE, "
                    + "OD.QUANTITY, "
                    + "OD.PRODUCTNO, "
                    + "OD.PRODUCTID "
                + "FROM ORDERDETAIL OD "
                + "JOIN \"ORDER\" O ON OD.ORDERID = O.ORDERID "
                + "WHERE O.ORDERID = ?";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Order domain) throws SQLException {
        stmt.setInt(1, domain.getOrderId());
    }
    
    
    @Override
    protected Order domainMapping(ResultSet rs) throws SQLException {
        
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetail().setColor(rs.getString("COLOR"))
                                          .setPrice(rs.getDouble("PRICE"))
                                          .setSize(rs.getString("SIZE"))
                                          .setQuantity(rs.getInt("QUANTITY"))
                                          .setProductName(rs.getString("PRODUCTNAME"))
                                          .setProductNo(rs.getString("PRODUCTNO"))
                                          .setProductId(rs.getInt("PRODUCTID"))
                                          .setProductDetailId(rs.getInt("PRODUCTDETAILID"))
        );
        
        return new Order().setOrderId(rs.getInt("ORDERID"))
                          .setOrderNo(rs.getString("ORDERNO"))
                          .setStatus(rs.getString("STATUS"))
                          .setPrice(rs.getDouble("ORDERPRICE"))
                          .setDeliveryFee(rs.getDouble("DELIVERYFEE"))
                          .setOrderDetail(orderDetails)
                ;
    }
}
