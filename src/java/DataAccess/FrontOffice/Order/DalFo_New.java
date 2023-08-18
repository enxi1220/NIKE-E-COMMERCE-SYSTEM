package DataAccess.FrontOffice.Order;

import DataAccess.Dal_Super;
import Model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_New extends Dal_Super<Order>{

    public DalFo_New(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "INSERT INTO \"ORDER\" ("
                    + "CUSTOMERID, "
                    + "COURIERID, "
                    + "ORDERNO, "
                    + "RECEIVERNAME, "
                    + "STATUS, "
                    + "PRICE, "
                    + "DELIVERYADDRESS, "
                    + "DELIVERYFEE, "
                    + "CREATEDDATE, "
                    + "CREATEDBY )"
                + "VALUES (?,?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Order domain) throws SQLException {
        stmt.setInt(1, domain.getCustomerId());
        stmt.setInt(2, domain.getCourierId());
        stmt.setString(3, domain.getOrderNo());
        stmt.setString(4, domain.getReceiverName());
        stmt.setString(5, domain.getStatus());
        stmt.setDouble(6, domain.getPrice());
        stmt.setString(7, domain.getDeliveryAddress());
        stmt.setDouble(8, domain.getDeliveryFee());
        stmt.setTimestamp(9, domain.getCreatedDate());
        stmt.setString(10, domain.getCreatedBy());
    }
    
}
