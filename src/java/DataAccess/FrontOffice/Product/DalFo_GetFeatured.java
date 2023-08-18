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
public class DalFo_GetFeatured extends Dal_Super<Product> {

    public DalFo_GetFeatured(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "PRO.PRODUCTNAME, "
                + "PRO.PRODUCTID "
                + "FROM PRODUCT PRO "
                + "WHERE PRO.ISFEATURED = 1 "
                + "AND PRO.STATUS = ? "
                + "FETCH FIRST 8 ROWS ONLY ";
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
        return new Product()
                .setProductName(rs.getString("PRODUCTNAME"))
                .setProductId(rs.getInt("PRODUCTID"));
    }

}
