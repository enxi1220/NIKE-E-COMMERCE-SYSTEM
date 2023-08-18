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
public class DalBo_Delete extends Dal_Super<ProductImage>{

    public DalBo_Delete(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "DELETE FROM PRODUCTIMAGE "
               + "WHERE PRODUCTIMAGEID = ? ";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, ProductImage domain) throws SQLException {
        stmt.setInt(1, domain.getProductImageId());
    }
    
}
