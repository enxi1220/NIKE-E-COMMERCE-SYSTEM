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
public class DalBo_Deactivate extends Dal_Super<Product>{

    public DalBo_Deactivate(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "UPDATE PRODUCT SET "
                + "STATUS = 'Deactivate', "
                + "UPDATEDDATE = ?, "
                + "UPDATEDBY = ?  "
                + "WHERE PRODUCTID = ? ";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Product domain) throws SQLException {
        
        stmt.setTimestamp(1, domain.getUpdatedDate());
        stmt.setString(2, domain.getUpdatedBy());
        stmt.setInt(3, domain.getProductId()); 
    }
    
}
