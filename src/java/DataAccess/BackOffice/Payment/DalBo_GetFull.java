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
public class DalBo_GetFull extends Dal_Super<Payment> {

    public DalBo_GetFull(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "PYT.PAYMENTID, "
                + "PYT.PAYMENTNO, "
                + "OD.ORDERNO, "
                + "PYT.PRICE, "
                + "PYT.CREATEDDATE, "
                + "PYT.CREATEDBY, "
                + "PYT.UPDATEDDATE, "
                + "PYT.UPDATEDBY "
                + "FROM PAYMENT PYT "
                + "JOIN \"ORDER\" OD ON PYT.ORDERID = OD.ORDERID ";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Payment domain) throws SQLException {

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
                .setPrice(rs.getDouble("PRICE"))
                .setCreatedDate(rs.getTimestamp("CREATEDDATE"))
                .setCreatedBy(rs.getString("CREATEDBY"))
                .setUpdatedDate(rs.getTimestamp("UPDATEDDATE"))
                .setUpdatedBy(rs.getString("UPDATEDBY"));

    }

}
