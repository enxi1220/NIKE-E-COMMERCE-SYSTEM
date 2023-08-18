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

public class BllBo_GetPassword extends Bll_Super<User> {
    
    public void checkPassword(User domain) throws Exception {
        ArrayList<User> user = this.businessLogic(new User().setUsername(domain.getUsername()));
        String dbCurrentPass = user.get(0).getPassword();

        if (!domain.getPassword().equals(dbCurrentPass)) {
            throw new Exception("Wrong Password");
        }
    }
    
    @Override
    public ArrayList<User> businessLogic(User domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<User> execute(Connection conn, User domain) throws SQLException {
        return new DataAccess.BackOffice.User.DalBo_GetPassword(conn).run(domain);

    }

}
