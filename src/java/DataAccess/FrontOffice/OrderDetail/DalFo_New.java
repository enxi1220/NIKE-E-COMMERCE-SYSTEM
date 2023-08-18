package DataAccess.FrontOffice.OrderDetail;

import DataAccess.Dal_Super;
import Model.OrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_New extends Dal_Super<OrderDetail>{

    public DalFo_New(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "INSERT INTO ORDERDETAIL ("
                    + "ORDERID, "
                    + "PRODUCTDETAILID, "
                    + "PRODUCTNAME, "
                    + "PRICE, "
                    + "QUANTITY, "
                    + "\"SIZE\",  "
                    + "COLOR, "
                    + "PRODUCTNO, "
                    + "PRODUCTID, "
                    + "CREATEDDATE, "
                    + "CREATEDBY) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, OrderDetail domain) throws SQLException {
        stmt.setInt(1, domain.getOrderId());
        stmt.setInt(2, domain.getProductDetailId());
        stmt.setString(3, domain.getProductName());
        stmt.setDouble(4, domain.getPrice());
        stmt.setInt(5, domain.getQuantity());
        stmt.setString(6, domain.getSize());
        stmt.setString(7, domain.getColor());
        stmt.setString(8, domain.getProductNo());
        stmt.setInt(9, domain.getProductId());
        stmt.setTimestamp(10, domain.getCreatedDate());
        stmt.setString(11, domain.getCreatedBy());
    }
    
}
