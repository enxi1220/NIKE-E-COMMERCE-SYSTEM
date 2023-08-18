package DataAccess.FrontOffice.ProductDetail;

import DataAccess.Dal_Super;
import Model.ProductDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_Get extends Dal_Super<ProductDetail>{

    public DalFo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                    + "PRODUCTDETAILID, "
                    + "SALESOUTQTY, "
                    + "PHYSICALQTY "
                + "FROM PRODUCTDETAIL "
                + "WHERE PRODUCTDETAILID = ?";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, ProductDetail domain) throws SQLException {
        stmt.setInt(1, domain.getProductDetailId());
    }
    
    @Override
    protected ProductDetail domainMapping(ResultSet rs) throws SQLException {
        return new ProductDetail()
                .setProductDetailId(rs.getInt("PRODUCTDETAILID"))
                .setSalesOutQty(rs.getInt("SALESOUTQTY"))
                .setPhysicalQty(rs.getInt("PHYSICALQTY"))
                ;
    }
}
