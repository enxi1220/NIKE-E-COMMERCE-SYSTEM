/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.BackOffice.Sales;

import DataAccess.Dal_Super;

import Model.Report;
import Model.Product;
import Model.ProductDetail;
import Model.Order;
import Model.OrderDetail;
import Model.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Junyuan
 */

public class DalBo_Get extends Dal_Super<Report> {

    public DalBo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT"
                + " P.PRODUCTNO, "
                + " OD.PRODUCTNAME, "
                + " OD.COLOR, "
                + " OD.\"SIZE\", "
                + " SUM (OD.QUANTITY) AS sumQTY "
                + " FROM \"ORDER\" O "
                + " JOIN ORDERDETAIL OD ON OD.ORDERID = O.ORDERID "
                + " JOIN PRODUCTDETAIL PD ON OD.PRODUCTDETAILID = PD.PRODUCTDETAILID "
                + " JOIN PAYMENT PY ON O.ORDERID = PY.ORDERID "
                + " JOIN PRODUCT P ON P.PRODUCTID = PD.PRODUCTID "
                + " GROUP BY P.PRODUCTNO, OD.PRODUCTNAME, OD.COLOR, OD.\"SIZE\" "
                ;
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Report domain) throws SQLException {
         
    }

    @Override
    protected Report domainMapping(ResultSet rs) throws SQLException {
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails.add(new OrderDetail()
                
                .setProductName(rs.getString("PRODUCTNAME"))
                .setColor(rs.getString("COLOR"))
                .setSize(rs.getString("SIZE"))   
        );

        return new Report()
           .setProduct(new Product() .setProductNo(rs.getString("PRODUCTNO")))
           .setOrderDetail(orderDetails) 
          .setSumQTY(rs.getString("sumQTY"));
        
    }

}

