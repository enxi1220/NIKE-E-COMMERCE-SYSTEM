package DataAccess.FrontOffice.Payment;

import DataAccess.Dal_Super;
import Model.Order;
import Model.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_GetUniqueNo extends Dal_Super<Payment>{
    public DalFo_GetUniqueNo(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT PAYMENTNO "
                + "FROM PAYMENT "
                + "ORDER BY PAYMENTID DESC "
                + "FETCH FIRST 1 ROWS ONLY";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Payment domain) throws SQLException {
        
    }
    
    @Override
    protected Payment domainMapping(ResultSet rs) throws SQLException {
        return new Payment().setPaymentNo(rs.getString("PAYMENTNO"));
    }
}
