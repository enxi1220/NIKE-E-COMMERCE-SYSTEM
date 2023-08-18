package BusinessLogic.FrontOffice.Payment;

import BusinessLogic.Bll_Super;
import Model.Payment;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public class BllFo_Get extends Bll_Super<Payment>{

    @Override
    public ArrayList<Payment> businessLogic(Payment domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Payment> execute(Connection conn, Payment domain) throws SQLException {
        return new DataAccess.FrontOffice.Payment.DalFo_Get(conn).run(domain);
    }
    
}
