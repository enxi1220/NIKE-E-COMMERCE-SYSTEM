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
public class DalFo_Delete extends Dal_Super<CartDetail>{

    public DalFo_Delete(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "DELETE FROM CARTDETAIL WHERE CARTDETAILID = ?";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, CartDetail domain) throws SQLException {
        stmt.setInt(1, domain.getCartDetailId());
    }
    
}
