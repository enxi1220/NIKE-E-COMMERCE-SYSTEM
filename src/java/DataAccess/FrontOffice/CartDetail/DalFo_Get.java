package DataAccess.FrontOffice.CartDetail;

import DataAccess.Dal_Super;
import Model.CartDetail;
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
public class DalFo_Get extends Dal_Super<CartDetail>{

    public DalFo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                    + "CD.CARTID, "
                    + "CD.PRODUCTDETAILID "
                + "FROM CARTDETAIL CD "
                + "JOIN PRODUCTDETAIL PD ON CD.PRODUCTDETAILID = PD.PRODUCTDETAILID "
                + "WHERE CD.CARTID = ? "
                + "AND PD.PRODUCTDETAILID = ?";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, CartDetail domain) throws SQLException {
        stmt.setInt(1, domain.getCartId());
        stmt.setInt(2, domain.getProductDetailId());
    }
    
    @Override
    protected CartDetail domainMapping(ResultSet rs) throws SQLException {
        ArrayList<ProductDetail> productDetails = new ArrayList<>();
        productDetails.add(new ProductDetail()
                              .setProductDetailId(rs.getInt("PRODUCTDETAILID"))
        );
        
        return new CartDetail()
                .setCartId(rs.getInt("CARTID"))
                            .setProduct(new Product()
                                            .setProductDetail(productDetails));
    }
    
}
