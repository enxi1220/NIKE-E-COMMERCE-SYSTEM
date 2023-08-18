package BusinessLogic.FrontOffice.Courier;

import BusinessLogic.Bll_Super;
import Model.Courier;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public class BllFo_Get extends Bll_Super<Courier>{

    @Override
    public ArrayList<Courier> businessLogic(Courier domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Courier> execute(Connection conn, Courier domain) throws SQLException {
        return new DataAccess.FrontOffice.Courier.DalFo_Get(conn).run(domain);
    }
    
}
