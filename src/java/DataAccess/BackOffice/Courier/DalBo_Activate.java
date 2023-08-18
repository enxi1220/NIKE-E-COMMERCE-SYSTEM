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
public class DalBo_Activate extends Dal_Super<Courier> {

    public DalBo_Activate(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "UPDATE COURIER SET "
                + "STATUS = 'Activate', "
                + "UPDATEDDATE = ?, "
                + "UPDATEDBY = ?  "
                + "WHERE COURIERID = ? ";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Courier domain) throws SQLException {
        stmt.setTimestamp(1, domain.getUpdatedDate());
        stmt.setString(2, domain.getUpdatedBy());
        stmt.setInt(3, domain.getCourierId());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Update;
    }
}
