package DataAccess.BackOffice.SalesReport;

import DataAccess.Dal_Super;

import Model.Report;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Linyi
 */
public class DalBo_Get extends Dal_Super<Report> {

    public DalBo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT"
                + " P.CATEGORY , "
                + " SUM(PD.SALESOUTQTY) AS salesOutQTY "
                + " FROM PRODUCT P JOIN PRODUCTDETAIL PD ON P.PRODUCTID = PD.PRODUCTID "
                + " GROUP BY P.CATEGORY  ";
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

        return new Report()
                .setProduct(new Product().setCategory(rs.getString("CATEGORY")))
                .setSalesOutQTY(rs.getString("salesOutQTY"));

    }

}
