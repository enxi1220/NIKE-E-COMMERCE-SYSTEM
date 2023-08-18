package DataAccess.FrontOffice.Customer;

import Model.Customer;
import DataAccess.Dal_Super;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author vinnie chin
 */
public class DalFo_Get extends Dal_Super<Customer>{

    public DalFo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
      return "SELECT "
              + "CUST.USERNAME, "
              + "CUST.NAME, "
              + "CUST.MAIL, "
              + "CUST.PHONE, "
              + "CUST.DELIVERYADDRESS, "
              + "CUST.CREATEDDATE, "
              + "COUNT(DISTINCT CD.CARTDETAILID) AS CARTITEMQTY, "
              + "COUNT(DISTINCT O.ORDERID) AS ORDEREDQTY "
           + "FROM CUSTOMER CUST "
           + "LEFT JOIN CART C ON C.CUSTOMERID = CUST.CUSTOMERID "
           + "LEFT JOIN CARTDETAIL CD ON CD.CARTID = C.CARTID "
           + "LEFT JOIN \"ORDER\" O ON O.CUSTOMERID = CUST.CUSTOMERID "
           + "WHERE CUST.USERNAME = ? "
           + "GROUP BY CUST.STATUS, CUST.USERNAME, CUST.NAME, CUST.MAIL, CUST.PHONE, CUST.DELIVERYADDRESS, CUST.CREATEDDATE";

    }
    
    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
          stmt.setString(1, domain.getUsername());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
      return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected Customer domainMapping(ResultSet rs) throws SQLException {
        return
        new Customer()
        .setName(rs.getString("NAME"))
        .setUsername(rs.getString("USERNAME"))
        .setMail(rs.getString("MAIL"))
        .setPhone(rs.getString("PHONE"))
        .setDeliveryAddress(rs.getString("DELIVERYADDRESS"))
        .setCreatedDate(rs.getTimestamp("CREATEDDATE"))
        .setCartItemQty(rs.getInt("CARTITEMQTY"))
        .setOrderedQty(rs.getInt("ORDEREDQTY"));
    }
}
