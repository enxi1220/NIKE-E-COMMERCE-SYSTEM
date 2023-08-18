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
public class DalFo_Edit extends Dal_Super<Cart>{

    public DalFo_Edit(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "UPDATE CART "
                + "SET UPDATEDDATE = ?, "
                + "UPDATEDBY = ? "
                + "WHERE CUSTOMERID = "
                + "(SELECT "
                    + "CUSTOMERID "
                    + "FROM CUSTOMER "
                    + "WHERE USERNAME = ?)";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Cart domain) throws SQLException {
        stmt.setTimestamp(1, domain.getUpdatedDate());
        stmt.setString(2, domain.getUpdatedBy());
        stmt.setString(3, domain.getUpdatedBy());
    }
    
}
