/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess.FrontOffice.Product;

import Model.Product;
import DataAccess.Dal_Super;
import Model.ProductDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinnie chin
 */
public class DalFo_Get extends Dal_Super<Product> {

    public DalFo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "PRO.PRODUCTID, "
                + "PRO.PRODUCTNAME, "
                + "PRO.PRODUCTDESC, "
                + "PRO.CATEGORY, "
                + "PRO.PRICE, "
                + "PRODETAILS.COLOR, "
                + "PRODETAILS.PRODUCTDETAILID, "
                + "PRODETAILS.SIZE, "
                + "PRODETAILS.PHYSICALQTY "
                + "FROM PRODUCT PRO "
                + "LEFT JOIN PRODUCTDETAIL PRODETAILS ON PRO.PRODUCTID = PRODETAILS.PRODUCTID "
                + "WHERE PRO.PRODUCTID = ? ";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Product domain) throws SQLException {
        stmt.setInt(1, domain.getProductId());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected Product domainMapping(ResultSet rs) throws SQLException {
        ArrayList<ProductDetail> productDetails = new ArrayList<>();
        productDetails.add(new ProductDetail()
                .setProductDetailId(rs.getInt("PRODUCTDETAILID"))
                .setColor(rs.getString("COLOR"))
                .setSize(rs.getString("SIZE"))
                .setPhysicalQty(rs.getInt("PHYSICALQTY"))
        );

        return new Product()
                .setProductId(rs.getInt("PRODUCTID"))
                .setProductName(rs.getString("PRODUCTNAME"))
                .setProductDesc(rs.getString("PRODUCTDESC"))
                .setCategory(rs.getString("CATEGORY"))
                .setPrice(rs.getDouble("PRICE"))
                .setProductDetail(productDetails);
    }

}
