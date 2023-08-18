package DataAccess.BackOffice.Order;

import Model.Order;
import DataAccess.Dal_Super;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class DalBo_Edit extends Dal_Super<Order> {

    public DalBo_Edit(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "UPDATE \"ORDER\" SET "
                + "TRACKINGNO = ?, "
                + "STATUS = ?, "
                + "UPDATEDDATE = ?, "
                + "UPDATEDBY = ?  "
                + "WHERE ORDERID = ? ";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Order domain) throws SQLException {
        stmt.setString(1, domain.getTrackingNo());
        stmt.setString(2, domain.getStatus());
        stmt.setTimestamp(3, domain.getUpdatedDate());
        stmt.setString(4, domain.getUpdatedBy());
        stmt.setInt(5, domain.getOrderId());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Update;
    }
}
