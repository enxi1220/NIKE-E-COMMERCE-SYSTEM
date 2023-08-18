/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess.BackOffice.Product;

import Model.Product;
import DataAccess.Dal_Super;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author Tham Jun Yuan
 */
public class DalBo_GetFull extends Dal_Super<Product>{
    
    public DalBo_GetFull(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "PD.PRODUCTID, "
                + "PD.PRODUCTNO, "
                + "PD.PRODUCTNAME, "
                + "PD.CATEGORY, "
                + "PD.ISFEATURED, "
                + "PD.STATUS, "
                + "PD.CREATEDDATE, "
                + "PD.CREATEDBY, "
                + "PD.UPDATEDDATE, "
                + "PD.UPDATEDBY "
                + "FROM PRODUCT PD ";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Product domain) throws SQLException {
        
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected Product domainMapping(ResultSet rs) throws SQLException {
        return
        new Product()
        .setProductId(rs.getInt("PRODUCTID"))
        .setProductNo(rs.getString("PRODUCTNO"))
        .setProductName(rs.getString("PRODUCTNAME"))
        .setCategory(rs.getString("CATEGORY"))
        .setIsFeatured(rs.getInt("ISFEATURED"))
        .setStatus(rs.getString("STATUS"))
        .setCreatedDate(rs.getTimestamp("CREATEDDATE"))
        .setCreatedBy(rs.getString("CREATEDBY"))
        .setUpdatedDate(rs.getTimestamp("UPDATEDDATE"))
        .setUpdatedBy(rs.getString("UPDATEDBY"));
    }
}
