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
public class DalBo_GetFull extends Dal_Super<Customer>{
    
     public DalBo_GetFull(Connection conn) {
        super(conn);
    }
     
    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "CU.CUSTOMERID, "
                + "CU.USERNAME, "
                + "CU.\"NAME\", "
                + "CU.MAIL, "
                + "CU.STATUS, "
                + "CU.CREATEDDATE, "
                + "CU.CREATEDBY, "
                + "CU.UPDATEDDATE, "
                + "CU.UPDATEDBY "
                + "FROM CUSTOMER CU ";
    }
    
    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {

    }
    
    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected Customer domainMapping(ResultSet rs) throws SQLException {
        return new Customer()
                .setUsername(rs.getString("USERNAME"))
                .setCustomerId(rs.getInt("CUSTOMERID"))
                .setName(rs.getString("NAME"))
                .setMail(rs.getString("MAIL"))
                .setStatus(rs.getString("STATUS"))
                .setCreatedDate(rs.getTimestamp("CREATEDDATE"))
                .setCreatedBy(rs.getString("CREATEDBY"))
                .setUpdatedDate(rs.getTimestamp("UPDATEDDATE"))
                .setUpdatedBy(rs.getString("UPDATEDBY"));
        
    }
}
