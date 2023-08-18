/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess.BackOffice.Customer;

import DataAccess.Dal_Super;

import Model.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Tham Jun Yuan
 */
public class DalBo_Get extends Dal_Super<Customer>{
    
    public DalBo_Get(Connection conn) {
        super(conn);
    }
    
    @Override
    protected String sqlStatement() {
        return "SELECT "
                    + "CU.USERNAME, "
                    + "CU.\"NAME\", "
                    + "CU.PHONE, "
                    + "CU.MAIL, "
                    + "CU.DELIVERYADDRESS, "
                    + "CU.STATUS "
                    + "FROM CUSTOMER CU WHERE CU.CUSTOMERID = ?";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
        stmt.setInt(1, domain.getCustomerId());
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected Customer domainMapping(ResultSet rs) throws SQLException {
        return new Customer()
                .setUsername(rs.getString("USERNAME"))
                .setName(rs.getString("NAME"))
                .setPhone(rs.getString("PHONE"))
                .setMail(rs.getString("MAIL"))
                .setDeliveryAddress(rs.getString("DELIVERYADDRESS"))
                .setStatus(rs.getString("STATUS"));
        
    }
}
