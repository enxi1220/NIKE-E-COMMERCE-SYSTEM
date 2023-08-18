package BusinessLogic.BackOffice.Courier;

import Model.Courier;
import BusinessLogic.Bll_Super;
import Helper.Constant;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class BllBo_Edit extends Bll_Super<Courier> {

    @Override
    public ArrayList<Courier> businessLogic(Courier domain) throws Exception {

        domain.setUpdatedDate(Helper.CurrentDate.getDate());
        return super.run(domain);
    }

    @Override
    protected ArrayList<Courier> execute(Connection conn, Courier domain) throws SQLException {
        return new DataAccess.BackOffice.Courier.DalBo_Edit(conn).run(domain);
    }

}
