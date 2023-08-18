package BusinessLogic.BackOffice.Courier;

import Model.Courier;

import BusinessLogic.Bll_Super;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class BllBo_Get extends Bll_Super<Courier> {

    @Override
    public ArrayList<Courier> businessLogic(Courier domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Courier> execute(Connection conn, Courier domain) throws SQLException {
        return new DataAccess.BackOffice.Courier.DalBo_Get(conn).run(domain);
    }
}
