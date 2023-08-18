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
public class DalBo_Get extends Dal_Super<Dashboard> {

    public DalBo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + " COALESCE(COUNT(C.CUSTOMERID),0) AS sumCustomer "
                + " FROM CUSTOMER C "
                + "  WHERE DATE(C.CREATEDDATE) = CURRENT DATE ";
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
                .setSumCustomer(rs.getInt("sumCustomer"));

    }

}
