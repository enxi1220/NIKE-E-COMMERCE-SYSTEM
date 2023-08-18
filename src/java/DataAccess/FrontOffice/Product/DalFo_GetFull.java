/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataAccess.FrontOffice.Product;

import Model.Product;
import DataAccess.Dal_Super;
import Helper.Constant;
import Helper.Constant.StatusEnum;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vinnie chin
 */
public class DalFo_GetFull extends Dal_Super<Product> {

    public DalFo_GetFull(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "PRO.PRODUCTID, "
                + "PRO.PRODUCTNO, "
                + "PRO.PRODUCTNAME, "
                + "PRO.PRODUCTDESC, "
                + "PRO.STATUS, "
                + "PRO.CATEGORY, "
                + "PRO.ISFEATURED, "
                + "PRO.PRICE "
             + "FROM PRODUCT PRO "
             + "WHERE PRO.STATUS = ? "
             + "ORDER BY PRO.CREATEDDATE DESC ";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Product domain) throws SQLException {
        stmt.setString(1, Constant.getStatus(StatusEnum.Activate));
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
        .setProductDesc(rs.getString("PRODUCTDESC"))
        .setStatus(rs.getString("STATUS"))
        .setCategory(rs.getString("CATEGORY"))
        .setIsFeatured(rs.getInt("ISFEATURED"))
        .setPrice(rs.getDouble("PRICE"));
    }

}
