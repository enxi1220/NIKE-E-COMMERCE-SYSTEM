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
public class BllBo_New extends Bll_Super<Courier> {

    @Override
    public ArrayList<Courier> businessLogic(Courier domain) throws Exception {

        domain.setCreatedDate(Helper.CurrentDate.getDate());
        domain.setStatus(Helper.Constant.getStatus(Constant.StatusEnum.Activate));

        return super.run(domain);
    }

    @Override
    protected ArrayList<Courier> execute(Connection conn, Courier domain) throws SQLException {
        return new DataAccess.BackOffice.Courier.DalBo_New(conn).run(domain);
    }
}
