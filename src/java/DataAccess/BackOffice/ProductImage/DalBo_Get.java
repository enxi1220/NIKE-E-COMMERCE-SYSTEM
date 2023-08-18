package DataAccess.BackOffice.ProductImage;

import DataAccess.Dal_Super;
import Model.ProductImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DalBo_Get extends Dal_Super<ProductImage>{

    public DalBo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "PRODUCTIMAGEID, "
                + "IMAGE, "
                + "IMAGETYPE "
                + "FROM PRODUCTIMAGE "
                + "WHERE PRODUCTID = ? ";
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, ProductImage domain) throws SQLException {
        stmt.setInt(1, domain.getProductId());
    }
    
    @Override
    protected ProductImage domainMapping(ResultSet rs) throws SQLException {
        ProductImage productImage = new ProductImage();
        try {
            productImage =  new ProductImage()
                    .setProductImageId(rs.getInt("PRODUCTIMAGEID"))
                    .setImageType(rs.getString("IMAGETYPE"))
                    .setImageAsBase64(Helper.ImageConvertor.getImage(rs.getBlob("IMAGE")));
        } catch (IOException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        
        return productImage;
    }
}
