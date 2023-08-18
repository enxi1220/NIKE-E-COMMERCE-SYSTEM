package DataAccess.FrontOffice.Cart;

import DataAccess.Dal_Super;
import Model.Cart;
import Model.CartDetail;
import Model.Customer;
import Model.Product;
import Model.ProductDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_GetFull extends Dal_Super<Cart>{

    public DalFo_GetFull(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                    + "C.CARTID, "
                    + "C.CUSTOMERID, "
                    + "CD.CARTDETAILID, "
                    + "CD.QUANTITY, "
                    + "CD.PRODUCTDETAILID, "
                    + "P.PRODUCTID, "
                    + "P.PRODUCTNO, "
                    + "P.PRODUCTNAME, "
                    + "P.PRICE, "
                    + "PD.SIZE, "
                    + "PD.COLOR, "
                    + "PD.PHYSICALQTY "
                + "FROM CART C "
                + "JOIN CARTDETAIL CD ON C.CARTID = CD.CARTID "
                + "JOIN PRODUCTDETAIL PD ON CD.PRODUCTDETAILID = PD.PRODUCTDETAILID "
                + "JOIN PRODUCT P ON P.PRODUCTID = PD.PRODUCTID "
                + "JOIN CUSTOMER CU ON C.CUSTOMERID = CU.CUSTOMERID "
                + "WHERE CU.USERNAME = ?";
        
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Cart domain) throws SQLException {
        stmt.setString(1, domain.getCustomer().getUsername());
    }
    
    @Override
    protected Cart domainMapping(ResultSet rs) throws SQLException {
        ArrayList<ProductDetail> productDetails = new ArrayList<>();
        productDetails.add(new ProductDetail()
                              .setProductDetailId(rs.getInt("PRODUCTDETAILID"))
                              .setPhysicalQty(rs.getInt("PHYSICALQTY"))
                              .setColor(rs.getString("COLOR"))
                              .setSize(rs.getString("SIZE"))
        );
        
        ArrayList<CartDetail> cartDetails = new ArrayList<>();
        cartDetails.add(new CartDetail()
                            .setCartDetailId(rs.getInt("CARTDETAILID"))
                            .setQuantity(rs.getInt("QUANTITY"))
                            .setProduct(new Product()
                                            .setProductName(rs.getString("PRODUCTNAME"))
                                            .setProductNo(rs.getString("PRODUCTNO"))
                                            .setProductId(rs.getInt("PRODUCTID"))
                                            .setPrice(rs.getDouble("PRICE"))
                                            .setProductDetail(productDetails)
                                            )
        );
        
        return new Cart()
                .setCartId(rs.getInt("CARTID"))
                .setCustomer(new Customer().setCustomerId(rs.getInt("CUSTOMERID")))
                .setCartDetail(cartDetails)
        ;
        
    }
    
}