package BusinessLogic.BackOffice.User;

import Model.User;
import BusinessLogic.Bll_Super;
import Helper.Constant;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
        

/**
 *
 * @author Linyi
 */

   public class BllBo_New extends Bll_Super<User>{
    @Override
    public ArrayList<User> businessLogic(User domain) throws Exception {
        domain.setStatus(Helper.Constant.getStatus(Constant.StatusEnum.Activate));
        ArrayList<User> user = new BllBo_Get().businessLogic(new User().setUsername(domain.getUsername()));
        if (!user.isEmpty()){
           throw new Exception("Same username has been created. Please Try again.");
        }

        return super.run(domain);
    }

    @Override
    protected ArrayList<User> execute(Connection conn, User domain) throws SQLException{
       return new DataAccess.BackOffice.User.DalBo_New(conn).run(domain);
    }
}
  

 
