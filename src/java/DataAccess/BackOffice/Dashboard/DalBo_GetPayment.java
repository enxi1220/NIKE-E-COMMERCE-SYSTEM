package DataAccess.BackOffice.Dashboard;

import DataAccess.Dal_Super;
import Model.Dashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Linyi
 */
public class DalBo_GetPayment extends Dal_Super<Dashboard> {

    public DalBo_GetPayment(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + " COALESCE (SUM(P.PRICE),0)  AS price, "
                + "  COALESCE (COUNT(P.ORDERID),0)  AS sumOrder "
                + " FROM PAYMENT P "
                + "  WHERE DATE(P.CREATEDDATE) = CURRENT DATE  ";
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Dashboard domain) throws SQLException {

    }

    @Override
    protected Dashboard domainMapping(ResultSet rs) throws SQLException {
        return new Dashboard()
                .setSumOrder(rs.getInt("sumOrder"))
                .setPrice(rs.getDouble("price"));

    }

}
