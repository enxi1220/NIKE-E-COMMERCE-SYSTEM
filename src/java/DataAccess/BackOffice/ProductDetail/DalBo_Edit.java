package DataAccess.BackOffice.ProductDetail;

import DataAccess.Dal_Super;
import Model.ProductDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DalBo_Edit extends Dal_Super<ProductDetail>{

    public DalBo_Edit(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "UPDATE PRODUCTDETAIL SET "
                + "COLOR = ?, "
                + "\"SIZE\" = ?, "
                + "PHYSICALQTY = ?, "
                + "MINSTOCKQTY = ?, "
                + "UPDATEDDATE = ?, "
                + "UPDATEDBY = ? "
                + "WHERE PRODUCTDETAILID = ? ";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, ProductDetail domain) throws SQLException {
        stmt.setString(1, domain.getColor());
        stmt.setString(2, domain.getSize());
        stmt.setInt(3, domain.getPhysicalQty());
        stmt.setInt(4, domain.getMinStockQty());
        stmt.setTimestamp(5, domain.getUpdatedDate());
        stmt.setString(6, domain.getUpdatedBy());
        stmt.setInt(7, domain.getProductDetailId());
    }
    
}
