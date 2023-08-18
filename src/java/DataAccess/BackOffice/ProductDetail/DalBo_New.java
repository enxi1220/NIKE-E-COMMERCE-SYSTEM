package DataAccess.BackOffice.ProductDetail;

import DataAccess.Dal_Super;

import Model.ProductDetail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Tham Jun Yuan
 */
public class DalBo_New extends Dal_Super<ProductDetail>{
    
    public DalBo_New(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "INSERT INTO PRODUCTDETAIL ("
                + "PRODUCTID, "
                + "\"SIZE\", "
                + "COLOR, "
                + "MINSTOCKQTY, "
                + "PHYSICALQTY, "
                + "CREATEDDATE, "
                + "CREATEDBY) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Update;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, ProductDetail domain) throws SQLException {
        stmt.setInt(1, domain.getProductId());
        stmt.setString(2, domain.getSize());
        stmt.setString(3, domain.getColor());
        stmt.setInt(4, domain.getMinStockQty());
        stmt.setInt(5, domain.getPhysicalQty());
        stmt.setTimestamp(6, domain.getCreatedDate());
        stmt.setString(7, domain.getCreatedBy());
    }
    
}
