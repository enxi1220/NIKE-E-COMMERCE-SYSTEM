package BusinessLogic.BackOffice.Payment;

import Model.Payment;

import BusinessLogic.Bll_Super;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class BllBo_Get extends Bll_Super<Payment> {

    @Override
    public ArrayList<Payment> businessLogic(Payment domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Payment> execute(Connection conn, Payment domain) throws SQLException {
        return new DataAccess.BackOffice.Payment.DalBo_Get(conn).run(domain);
    }
}
