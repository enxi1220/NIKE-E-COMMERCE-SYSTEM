package DataAccess.FrontOffice.Cart;

import DataAccess.Dal_Super;
import Model.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_Delete extends Dal_Super<Cart>{

    public DalFo_Delete(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "DELETE FROM CARTDETAIL WHERE CARTID = ?";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Cart domain) throws SQLException {
        stmt.setInt(1, domain.getCartId());
    }
    
}
