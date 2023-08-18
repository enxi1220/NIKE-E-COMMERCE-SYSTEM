package DataAccess.BackOffice.Courier;

import Model.Courier;
import DataAccess.Dal_Super;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class DalBo_New extends Dal_Super<Courier> {

    public DalBo_New(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "INSERT INTO COURIER ("
                + "COURIERNAME, "
                + "COURIERPRICE, "
                + "STATUS, "
                + "CREATEDDATE, "
                + "CREATEDBY) "
                + "VALUES (?, ?, ?, ?, ?)";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Courier domain) throws SQLException {
        stmt.setString(1, domain.getCourierName());
        stmt.setDouble(2, domain.getCourierPrice());
        stmt.setString(3, domain.getStatus());
        stmt.setTimestamp(4, domain.getCreatedDate());
        stmt.setString(5, domain.getCreatedBy());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Update;
    }

}
