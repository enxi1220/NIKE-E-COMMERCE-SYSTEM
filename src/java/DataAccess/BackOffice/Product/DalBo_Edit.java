package DataAccess.BackOffice.Product;

import DataAccess.Dal_Super;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DalBo_Edit extends Dal_Super<Product>{

    public DalBo_Edit(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "UPDATE PRODUCT SET "
                + "PRODUCTNAME = ?, "
                + "PRODUCTDESC = ?, "
                + "CATEGORY = ?, "
                + "PRICE = ?, "
                + "ISFEATURED = ?, "
                + "UPDATEDDATE = ?, "
                + "UPDATEDBY = ? "
                + "WHERE PRODUCTID = ? ";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Product domain) throws SQLException {
        stmt.setString(1, domain.getProductName());
        stmt.setString(2, domain.getProductDesc());
        stmt.setString(3, domain.getCategory());
        stmt.setDouble(4, domain.getPrice());
        stmt.setInt(5, domain.getIsFeatured());
        stmt.setTimestamp(6, domain.getUpdatedDate());
        stmt.setString(7, domain.getUpdatedBy());
        stmt.setInt(8, domain.getProductId());
    }
    
}
