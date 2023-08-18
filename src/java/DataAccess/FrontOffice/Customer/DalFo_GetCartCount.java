package DataAccess.FrontOffice.Customer;

import DataAccess.FrontOffice.Customer.*;
import DataAccess.Dal_Super;
import Model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vinnie chin
 */
public class DalFo_GetCartCount extends Dal_Super<Customer>{

    public DalFo_GetCartCount(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        
        return "SELECT "
                + "COALESCE(COUNT(CD.CARTDETAILID), 0) AS CARTITEMQTY "
                + "FROM CARTDETAIL CD "
                + "JOIN CART C ON C.CARTID = CD.CARTID "
                + "JOIN CUSTOMER CUST ON CUST.CUSTOMERID = C.CUSTOMERID "
                + "WHERE CUST.CUSTOMERID = ? ";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
          stmt.setInt(1, domain.getCustomerId());
    }
    
    @Override
    protected Customer domainMapping(ResultSet rs) throws SQLException {
        return new Customer().setCartItemQty(rs.getInt("CARTITEMQTY"));      
    }
}
