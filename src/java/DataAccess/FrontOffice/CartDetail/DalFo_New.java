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
public class DalFo_New extends Dal_Super<CartDetail>{

    public DalFo_New(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "INSERT INTO CARTDETAIL ("
                + "CARTID, "
                + "PRODUCTDETAILID, "
                + "QUANTITY, "
                + "CREATEDDATE, "
                + "CREATEDBY) "
                + "VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, CartDetail domain) throws SQLException {
        stmt.setInt(1, domain.getCartId());
        stmt.setInt(2, domain.getProductDetailId());
        stmt.setInt(3, domain.getQuantity());
        stmt.setTimestamp(4, domain.getCreatedDate());
        stmt.setString(5, domain.getCreatedBy());
    }
    
}