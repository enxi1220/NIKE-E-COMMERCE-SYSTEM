
package BusinessLogic.BackOffice.User;

import BusinessLogic.Bll_Super;
import Model.User;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Linyi
 */
public class BllBo_Edit extends Bll_Super<User> {

    @Override
    public ArrayList<User> businessLogic(User domain) throws Exception {
        domain.setUpdatedDate(Helper.CurrentDate.getDate());
        return super.run(domain);
    }

    @Override
    protected ArrayList<User> execute(Connection conn, User domain) throws SQLException {
        return new DataAccess.BackOffice.User.DalBo_Edit(conn).run(domain);
    }

}
