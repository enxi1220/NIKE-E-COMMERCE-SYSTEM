package DataAccess.BackOffice.ReorderReport;

import DataAccess.Dal_Super;

import Model.Product;
import Model.ProductDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Linyi
 */
public class DalBo_GetFull extends Dal_Super<Product> {

    public DalBo_GetFull(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "P.PRODUCTID, "
                + "P.PRODUCTNAME, "
                + "P.PRODUCTNO, "
                + "PD.PRODUCTDETAILID,  "
                + "PD.COLOR, "
                + "PD.\"SIZE\", "
                + "PD.PHYSICALQTY, "
                + "PD.MINSTOCKQTY "
                + "FROM PRODUCT P "
                + "JOIN PRODUCTDETAIL PD ON PD.PRODUCTID = P.PRODUCTID "
                + "WHERE PD.PHYSICALQTY < PD.MINSTOCKQTY "
                ;

    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Product domain) throws SQLException {
        
    }

    @Override
    protected Product domainMapping(ResultSet rs) throws SQLException {
        ArrayList<ProductDetail> productDetails = new ArrayList<>();
        productDetails.add(new ProductDetail()
                .setProductDetailId(rs.getInt("PRODUCTDETAILID"))
                .setPhysicalQty(rs.getInt("PHYSICALQTY"))
                .setMinStockQty(rs.getInt("MINSTOCKQTY"))
                .setColor(rs.getString("COLOR"))
                .setSize(rs.getString("SIZE"))
               
        );

        return new Product()
                .setProductId(rs.getInt("PRODUCTID"))
                .setProductName(rs.getString("PRODUCTNAME"))
                .setProductNo(rs.getString("PRODUCTNO"))
                .setProductDetail(productDetails);
    }

}
