package DataAccess.BackOffice.ProductDetail;

import DataAccess.Dal_Super;
import Model.ProductDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class DalBo_EditPhysicalQty extends Dal_Super<ProductDetail> {

    public DalBo_EditPhysicalQty(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "UPDATE PRODUCTDETAIL SET "
                + "PHYSICALQTY = ? "
                + "WHERE PRODUCTDETAILID = ?";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, ProductDetail domain) throws SQLException {
        stmt.setInt(1, domain.getPhysicalQty());
        stmt.setInt(2, domain.getProductDetailId());
    }

}
