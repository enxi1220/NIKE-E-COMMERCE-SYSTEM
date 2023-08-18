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
public class DalFo_New extends Dal_Super<Cart> {

    public DalFo_New(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "INSERT INTO CART ("
                + "CUSTOMERID, "
                + "CREATEDDATE, "
                + "CREATEDBY) "
            + "VALUES (?, ?, ?)";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Cart domain) throws SQLException {
        stmt.setInt(1, domain.getCustomerId());
        stmt.setTimestamp(2, domain.getCreatedDate());
        stmt.setString(3, domain.getCreatedBy());
    }

}
