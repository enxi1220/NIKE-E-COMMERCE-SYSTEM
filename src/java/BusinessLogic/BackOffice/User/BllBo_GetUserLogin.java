package BusinessLogic.BackOffice.User;

import Model.User;
import BusinessLogic.Bll_Super;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lin
 */
public class BllBo_GetUserLogin extends Bll_Super<User> {
    
    public ArrayList<User> checkUserLogin(User domain) throws Exception {
        ArrayList<User> userLogin = this.businessLogic(domain);
        
        if(userLogin.isEmpty()){
            throw new Exception("Username and Password Not Matched.");
        }
        return userLogin;
    }

    @Override
    public ArrayList<User> businessLogic(User domain) throws Exception {
        return super.run(domain);
    }
    
    @Override
    protected ArrayList<User> execute(Connection conn, User domain) throws SQLException {

        return new DataAccess.BackOffice.User.DalBo_GetUserLogin(conn).run(domain);

    }

}

