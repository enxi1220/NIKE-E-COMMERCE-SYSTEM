package DataAccess.BackOffice.ProductImage;

import DataAccess.Dal_Super;
import Model.ProductImage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class DalBo_New extends Dal_Super<ProductImage>{

    public DalBo_New(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "INSERT INTO PRODUCTIMAGE ("
                + "PRODUCTID," 
                + "IMAGE,"
                + "CREATEDDATE,"
                + "CREATEDBY )"
                + "VALUES "
                + "(?, ?, ?, ?)";       
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, ProductImage domain) throws SQLException {
        stmt.setInt(1, domain.getProductId());
        stmt.setBlob(2, domain.getInputStream());
        stmt.setTimestamp(3, domain.getCreatedDate());
        stmt.setString(4, domain.getCreatedBy());
       
    }
    
}
