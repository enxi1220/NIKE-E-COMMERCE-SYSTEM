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
public class DalFo_Edit extends Dal_Super<Order>{

    public DalFo_Edit(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "UPDATE \"ORDER\" SET "
                + "STATUS = ?,"
                + "UPDATEDDATE = ?, "
                + "UPDATEDBY = ? "
                + "WHERE ORDERID = ?";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Order domain) throws SQLException {
        stmt.setString(1, domain.getStatus());
        stmt.setTimestamp(2, domain.getUpdatedDate());
        stmt.setString(3, domain.getUpdatedBy());
        stmt.setInt(4, domain.getOrderId());
    }
    
}
