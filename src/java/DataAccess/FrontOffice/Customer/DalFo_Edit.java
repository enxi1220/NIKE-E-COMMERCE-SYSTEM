package DataAccess.FrontOffice.Customer;

import Model.Customer;
import DataAccess.Dal_Super;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 *
 * @author vinnie chin
 */
public class DalFo_Edit extends Dal_Super<Customer>{

    public DalFo_Edit(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        
      return "UPDATE CUSTOMER SET "
              + "NAME = ?, "
              + "MAIL = ?, "
              + "IMAGE = ?, "
              + "PHONE = ?, "
              + "DELIVERYADDRESS = ?, "
              + "UPDATEDBY = ?, "
              + "UPDATEDDATE = ? "
           + "WHERE USERNAME = ? ";
    }
    
    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
        stmt.setString(1, domain.getName());
        stmt.setString(2, domain.getMail());
        stmt.setBlob(3, domain.getInputStream());
        stmt.setString(4, domain.getPhone());
        stmt.setString(5, domain.getDeliveryAddress());
        stmt.setString(6, domain.getUpdatedBy());
        stmt.setTimestamp(7, domain.getUpdatedDate());
        stmt.setString(8, domain.getUsername());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
      return Dal_Super.ExecutionTypeEnum.Update;
    }

//    @Override
//    protected Customer domainMapping(ResultSet rs) throws SQLException {
//        return
//        new Customer()
//        .setName(rs.getString("NAME"))
//        .setMail(rs.getString("MAIL"))
//        .setImage(rs.getBlob("IMAGE"))
//        .setPhone(rs.getString("PHONE"))
//        .setDeliveryAddress(rs.getString("DELIVERYADDRESS"));
//    }
}
