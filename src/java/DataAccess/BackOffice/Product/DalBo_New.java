/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess.BackOffice.Product;

import Model.Product;
import Model.ProductDetail;
import Model.ProductImage;

import DataAccess.Dal_Super;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Tham Jun Yuan
 */
public class DalBo_New extends Dal_Super<Product>{
    
    public DalBo_New(Connection conn) {
        super(conn);
    }
    
    @Override
    protected String sqlStatement() {
        return 
                "INSERT INTO PRODUCT ("
                + "PRODUCTNO, "
                + "PRODUCTNAME, "       
                + "PRODUCTDESC, "
                + "CATEGORY, "
                + "STATUS, "
                + "ISFEATURED, "
                + "PRICE, "
                + "CREATEDDATE, "
                + "CREATEDBY) "
             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }
    
     @Override
    protected void prepareParameters(PreparedStatement stmt, Product domain) throws SQLException {
        stmt.setString(1, domain.getProductNo());
        stmt.setString(2, domain.getProductName()); 
        stmt.setString(3, domain.getProductDesc());
        stmt.setString(4, domain.getCategory());
        stmt.setString(5, domain.getStatus());
        stmt.setInt(6, domain.getIsFeatured());
        stmt.setDouble(7, domain.getPrice());
        stmt.setTimestamp(8, domain.getCreatedDate());
        stmt.setString(9, domain.getCreatedBy());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Update;
    }
    
}
