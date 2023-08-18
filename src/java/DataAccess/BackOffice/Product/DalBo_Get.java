package DataAccess.BackOffice.Product;

import Model.Product;
import Model.ProductDetail;
import Model.ProductImage;

import DataAccess.Dal_Super;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tham Jun Yuan
 */
public class DalBo_Get extends Dal_Super<Product>{
    
    public DalBo_Get(Connection conn) {
        super(conn);
    }
    
    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "PD.PRODUCTID, "
                + "PD.PRODUCTNO, "
                + "PD.PRODUCTNAME, "
                + "PD.PRODUCTDESC, "
                + "PD.PRICE, "
                + "PDDETAILS.COLOR, "
                + "PDDETAILS.PRODUCTDETAILID, "
                + "PDDETAILS.SIZE, "
                + "PDDETAILS.PHYSICALQTY "
                + "PDIMAGE.IMAGE "
                + "FROM PRODUCT PD "
                + "JOIN PRODUCTDETAIL PDDETAILS ON PD.PRODUCTID = PDDETAILS.PRODUCTID "
                + "JOIN PRODUCTIMAGE PDIMAGE ON PD.PRODUCTID = PDIMAGE.PRODUCTID "
                + "WHERE PD.PRODUCTID = ? ";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Product domain) throws SQLException {

    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected Product domainMapping(ResultSet rs) throws SQLException {
        
        ArrayList<ProductImage> productImages = new ArrayList<>();
        productImages.add(new ProductImage()
                .setProductImageId(rs.getInt("PRODUCTIMAGEID"))
                .setImage(rs.getBlob("IMAGE"))
        );
        
        ArrayList<ProductDetail> productDetails = new ArrayList<>();
        productDetails.add(new ProductDetail()
                .setProductDetailId(rs.getInt("PRODUCTDETAILID"))
                .setColor(rs.getString("COLOR"))
                .setSize(rs.getString("SIZE"))
                .setPhysicalQty(rs.getInt("PHYSICALQTY"))
        );
        
        return new Product()
                .setProductName(rs.getString("PRODUCTNAME"))
                .setProductDesc(rs.getString("PRODUCTDESC"))
                .setCategory(rs.getString("CATEGORY"))
                .setPrice(rs.getDouble("PRICE"))
                .setProductDetail(productDetails)
                .setProductImage(productImages);
        
    }
}
