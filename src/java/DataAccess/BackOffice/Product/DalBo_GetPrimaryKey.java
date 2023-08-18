package DataAccess.BackOffice.Product;

import DataAccess.Dal_Super;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tham Jun Yuan
 */
public class DalBo_GetPrimaryKey extends Dal_Super<Product>{
    
    public DalBo_GetPrimaryKey(Connection conn) {
        super(conn);
    }
    
    @Override
    protected String sqlStatement() {
        return "SELECT PRODUCTID "
                + "FROM PRODUCT "
                + "ORDER BY PRODUCTID DESC "
                + "FETCH FIRST 1 ROWS ONLY";
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
        return new Product().setProductId(rs.getInt("PRODUCTID"));
    }
}
