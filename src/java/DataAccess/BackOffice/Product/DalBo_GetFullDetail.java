package DataAccess.BackOffice.Product;

import DataAccess.Dal_Super;
import Model.Product;
import Model.ProductDetail;
import Model.ProductImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DalBo_GetFullDetail extends Dal_Super<Product> {

    public DalBo_GetFullDetail(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "P.PRODUCTID,"
                + "P.PRODUCTNO,"
                + "P.PRODUCTNAME,"
                + "P.PRICE,"
                + "P.PRODUCTDESC,"
                + "P.CATEGORY,"
                + "P.ISFEATURED,"
                + "PD.PRODUCTDETAILID,"
                + "PD.COLOR,"
                + "PD.\"SIZE\","
                + "PD.MINSTOCKQTY,"
                + "PD.PHYSICALQTY,"
                + "PD.SALESOUTQTY "
                + "FROM PRODUCT P "
                + "LEFT JOIN PRODUCTDETAIL PD "
                + "ON P.PRODUCTID = PD.PRODUCTID "
                + "WHERE P.PRODUCTID = ?";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Product domain) throws SQLException {
        stmt.setInt(1, domain.getProductId());
    }
    
    protected Product domainMapping(ResultSet rs) throws SQLException {
        
        ArrayList<ProductDetail> productDetails = new ArrayList<>();
        productDetails.add(new ProductDetail()
                              .setProductDetailId(rs.getInt("PRODUCTDETAILID"))
                              .setPhysicalQty(rs.getInt("PHYSICALQTY"))
                              .setColor(rs.getString("COLOR"))
                              .setSize(rs.getString("SIZE"))
                              .setSalesOutQty(rs.getInt("SALESOUTQTY"))
                              .setMinStockQty(rs.getInt("MINSTOCKQTY"))
        );
        
        return new Product().setCategory(rs.getString("CATEGORY"))
                            .setProductNo(rs.getString("PRODUCTNO"))
                            .setProductName(rs.getString("PRODUCTNAME"))
                            .setPrice(rs.getDouble("PRICE"))
                            .setProductDesc(rs.getString("PRODUCTDESC"))
                            .setIsFeatured(rs.getInt("ISFEATURED"))
                            .setProductDetail(productDetails);
                            
    }

}
