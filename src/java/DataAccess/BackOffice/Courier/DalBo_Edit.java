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
public class DalBo_Edit extends Dal_Super<Courier> {

    public DalBo_Edit(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "UPDATE COURIER SET "
                + "COURIERNAME = ?, "
                + "COURIERPRICE = ?, "
                + "UPDATEDDATE = ?, "
                + "UPDATEDBY = ?  "
                + "WHERE COURIERID = ? ";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Courier domain) throws SQLException {
        stmt.setString(1, domain.getCourierName());
        stmt.setDouble(2, domain.getCourierPrice());
        stmt.setTimestamp(3, domain.getUpdatedDate());
        stmt.setString(4, domain.getUpdatedBy());
        stmt.setInt(5, domain.getCourierId());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Update;
    }
}
