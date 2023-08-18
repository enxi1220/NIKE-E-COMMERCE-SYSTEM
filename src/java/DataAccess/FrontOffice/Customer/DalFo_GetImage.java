package DataAccess.FrontOffice.Customer;

import Model.Customer;
import DataAccess.Dal_Super;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vinnie chin
 */
public class DalFo_GetImage extends Dal_Super<Customer> {

    public DalFo_GetImage(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "SELECT "
                + "IMAGE "
                + "FROM CUSTOMER "
                + "WHERE USERNAME = ? ";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
        stmt.setString(1, domain.getUsername());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Query;
    }

    @Override
    protected Customer domainMapping(ResultSet rs) throws SQLException{
        
        Customer customer = new Customer();
        try {
            customer.setImageAsBase64(Helper.ImageConvertor.getImage(rs.getBlob("IMAGE")));
            
        } catch (Throwable ex) {
            Logger.getLogger(DalFo_GetImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customer;
    }
}
