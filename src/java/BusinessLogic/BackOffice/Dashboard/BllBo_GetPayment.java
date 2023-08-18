package BusinessLogic.BackOffice.Dashboard;

import Model.Dashboard;
import BusinessLogic.Bll_Super;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Linyi
 */
public class BllBo_GetPayment extends Bll_Super<Dashboard> {

    @Override
    public ArrayList<Dashboard> businessLogic(Dashboard domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Dashboard> execute(Connection conn, Dashboard domain) throws SQLException {

        return new DataAccess.BackOffice.Dashboard.DalBo_GetPayment(conn).run(domain);

    }
}
