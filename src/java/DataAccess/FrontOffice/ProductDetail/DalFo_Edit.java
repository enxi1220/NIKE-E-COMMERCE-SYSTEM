package DataAccess.FrontOffice.ProductDetail;

import DataAccess.Dal_Super;
import Model.ProductDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_Edit extends Dal_Super<ProductDetail>{

    public DalFo_Edit(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "UPDATE PRODUCTDETAIL SET "
                + "SALESOUTQTY = ? "
                + "WHERE PRODUCTDETAILID = ?";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, ProductDetail domain) throws SQLException {
        stmt.setInt(1, domain.getSalesOutQty());
        stmt.setInt(2, domain.getProductDetailId());
    }
    
}
