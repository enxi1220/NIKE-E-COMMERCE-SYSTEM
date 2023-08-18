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
public class DalFo_GetRelated extends Dal_Super<Product> {

    public DalFo_GetRelated(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "PRO.PRODUCTNAME, "
                + "PRO.PRICE, "
                + "PRO.PRODUCTID "
                + "FROM PRODUCT PRO "
                + "WHERE PRO.CATEGORY = ? "
                + "AND PRO.PRICE BETWEEN ? AND ? "
                + "AND NOT PRO.PRODUCTID = ? "
                + "AND PRO.STATUS = ? ";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Product domain) throws SQLException {
       
        stmt.setString(1, domain.getCategory());
        stmt.setDouble(2, domain.getPrice() - Double.parseDouble("190"));
        stmt.setDouble(3, domain.getPrice() + Double.parseDouble("190"));
        stmt.setInt(4, domain.getProductId());
        stmt.setString(5, Constant.getStatus(StatusEnum.Activate));
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected Product domainMapping(ResultSet rs) throws SQLException {
        return new Product()
                .setProductName(rs.getString("PRODUCTNAME"))
                .setProductId(rs.getInt("PRODUCTID"))
                .setPrice(rs.getDouble("PRICE"));
    }

}
