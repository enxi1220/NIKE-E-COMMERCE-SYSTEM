package DataAccess.FrontOffice.Order;

import DataAccess.Dal_Super;
import Model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_GetPrimaryKey extends Dal_Super<Order>{

    public DalFo_GetPrimaryKey(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT ORDERID "
                + "FROM \"ORDER\" "
                + "ORDER BY ORDERID DESC "
                + "FETCH FIRST 1 ROWS ONLY";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Order domain) throws SQLException {

    }
    
    @Override
    protected Order domainMapping(ResultSet rs) throws SQLException {
        return new Order().setOrderId(rs.getInt("ORDERID"));      
    }
}
