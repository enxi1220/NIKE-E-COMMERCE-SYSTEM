package DataAccess.BackOffice.Payment;

import DataAccess.Dal_Super;

import Model.Payment;
import Model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class DalBo_Get extends Dal_Super<Payment> {

    public DalBo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "PYT.PAYMENTID, "
                + "PYT.PAYMENTNO, "
                + "OD.ORDERNO, "
                + "PYT.CUSTOMERNAME, "
                + "PYT.PAYMENTMETHOD, "
                + "PYT.BANKTYPE, "
                + "PYT.PRICE, "
                + "PYT.DELIVERYFEE "
                + "FROM PAYMENT PYT "
                + "JOIN \"ORDER\" OD ON PYT.ORDERID = OD.ORDERID "
                + "WHERE PYT.PAYMENTID = ?";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Payment domain) throws SQLException {
        stmt.setInt(1, domain.getPaymentId());
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected Payment domainMapping(ResultSet rs) throws SQLException {
        return new Payment()
                .setPaymentId(rs.getInt("PAYMENTID"))
                .setPaymentNo(rs.getString("PAYMENTNO"))
                .setOrder(new Order().setOrderNo(rs.getString("ORDERNO")))
                .setCustomerName(rs.getString("CUSTOMERNAME"))
                .setPaymentMethod(rs.getString("PAYMENTMETHOD"))
                .setBankType(rs.getString("BANKTYPE"))
                .setPrice(rs.getDouble("PRICE"))
                .setDeliveryFee(rs.getDouble("DELIVERYFEE"));

    }
}
