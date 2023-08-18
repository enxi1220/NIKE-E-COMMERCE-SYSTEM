package BusinessLogic.BackOffice.User;

import Model.User;

import BusinessLogic.Bll_Super;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
        

/**
 *
 * @author Linyi
 */

   public class BllBo_GetFull extends Bll_Super<User>{
   @Override
    public ArrayList<User> businessLogic(User domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<User> execute(Connection conn, User domain) throws SQLException{
       return new DataAccess.BackOffice.User.DalBo_GetFull(conn).run(domain);
    }
}
  

 
