package DataAccess.FrontOffice.Courier;

import DataAccess.Dal_Super;
import Model.Courier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lim En Xi
 */
public class DalFo_Get extends Dal_Super<Courier>{

    public DalFo_Get(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                    + "COURIERNAME, "
                    + "COURIERPRICE "
                + "FROM COURIER "
                + "WHERE COURIERID = ?";
    }

    @Override
    protected ExecutionTypeEnum executionType() {
        return ExecutionTypeEnum.Query;
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Courier domain) throws SQLException {
        stmt.setInt(1, domain.getCourierId());
    }
    
    @Override
    protected Courier domainMapping(ResultSet rs) throws SQLException {
        return new Courier()
                .setCourierName(rs.getString("COURIERNAME"))
                .setCourierPrice(rs.getDouble("COURIERPRICE"))
                ;
    }
}
