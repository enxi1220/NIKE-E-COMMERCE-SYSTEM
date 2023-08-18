package DataAccess.FrontOffice.ProductImage;

import DataAccess.Dal_Super;
import Model.ProductImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_GetByNo extends Dal_Super<ProductImage>{

    public DalFo_GetByNo(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                    + "PI.PRODUCTIMAGEID, "
                    + "PI.IMAGE, "
                    + "PI.IMAGETYPE "
                + "FROM PRODUCTIMAGE PI "
                + "JOIN PRODUCT P ON P.PRODUCTID = PI.PRODUCTID "
                + "WHERE P.PRODUCTNO = ? "
                + "FETCH FIRST 1 ROWS ONLY";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, ProductImage domain) throws SQLException {
        stmt.setString(1, domain.getProductNo());
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
