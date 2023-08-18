package DataAccess.FrontOffice.Cart;

import DataAccess.Dal_Super;
import Model.Cart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_Get extends Dal_Super<Cart>{

    public DalFo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                    + "CARTID "
                + "FROM CART "
                + "WHERE CUSTOMERID = ?";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Cart domain) throws SQLException {
        stmt.setInt(1, domain.getCustomerId());
    }
 
    @Override
    protected Cart domainMapping(ResultSet rs) throws SQLException {
        return new Cart().setCartId(rs.getInt("CARTID"));
    }
}
