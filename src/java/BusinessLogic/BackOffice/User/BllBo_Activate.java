package BusinessLogic.BackOffice.User;

import Model.User;
import BusinessLogic.Bll_Super;
import Helper.Constant;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;       

/**
 *
 * @author Lin
 */

public class BllBo_Activate extends Bll_Super<User> {

    @Override
    public ArrayList<User> businessLogic(User domain) throws Exception {
      domain.setStatus(Helper.Constant.getStatus(Constant.StatusEnum.Activate));
        domain.setUpdatedDate(Helper.CurrentDate.getDate());
        return super.run(domain);
    }

    @Override
    protected ArrayList<User> execute(Connection conn, User domain) throws SQLException{
       return new DataAccess.BackOffice.User.DalBo_Activate(conn).run(domain);
    }
}

  

 
