package DataAccess.FrontOffice.CartDetail;

import DataAccess.Dal_Super;
import Model.CartDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_Edit extends Dal_Super<CartDetail>{

    public DalFo_Edit(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "UPDATE CARTDETAIL "
                + "SET QUANTITY = ?, "
                + "UPDATEDDATE = ?, "
                + "UPDATEDBY = ? "
                + "WHERE CARTDETAILID = ? ";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, CartDetail domain) throws SQLException {
        stmt.setInt(1, domain.getQuantity());
        stmt.setTimestamp(2, domain.getUpdatedDate());
        stmt.setString(3, domain.getUpdatedBy());
        stmt.setInt(4, domain.getCartDetailId());
    }
    
}
