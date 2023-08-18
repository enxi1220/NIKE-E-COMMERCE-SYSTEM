package BusinessLogic.BackOffice.SalesReport;

import Model.Report;
import BusinessLogic.Bll_Super;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Linyi
 */
public class BllBo_Get extends Bll_Super<Report> {

    @Override
    public ArrayList<Report> businessLogic(Report domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Report> execute(Connection conn, Report domain) throws SQLException {
        return new DataAccess.BackOffice.SalesReport.DalBo_Get(conn).run(domain);
    }
}
