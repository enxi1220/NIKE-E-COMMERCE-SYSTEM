package DataAccess.FrontOffice.Payment;

import DataAccess.Dal_Super;
import Model.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_New extends Dal_Super<Payment>{

    public DalFo_New(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "INSERT INTO PAYMENT ("
                    + "ORDERID,"
                    + "PAYMENTNO,"
                    + "CUSTOMERNAME,"
                    + "PAYMENTMETHOD,"
                    + "PRICE,"
                    + "DELIVERYFEE,"
                    + "CREATEDDATE,"
                    + "CREATEDBY)"
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Payment domain) throws SQLException {
        stmt.setInt(1, domain.getOrderId());
        stmt.setString(2, domain.getPaymentNo());
        stmt.setString(3, domain.getCustomerName());
        stmt.setString(4, domain.getPaymentMethod());
        stmt.setDouble(5, domain.getPrice());
        stmt.setDouble(6, domain.getDeliveryFee());
        stmt.setTimestamp(7, domain.getCreatedDate());
        stmt.setString(8, domain.getCreatedBy());
    }
    
}
