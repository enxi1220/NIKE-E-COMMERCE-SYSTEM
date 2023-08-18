package DataAccess.FrontOffice.Customer;

import Model.Customer;
import DataAccess.Dal_Super;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Helper.Constant;
import Helper.Constant.StatusEnum;

/**
 *
 * @author vinnie chin
 */
public class DalFo_New extends Dal_Super<Customer> {

    public DalFo_New(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        return "INSERT INTO CUSTOMER ("
                + "USERNAME, "
                + "NAME, "
                + "PASSWORD, "
                + "STATUS, "
                + "PHONE, "
                + "MAIL, "
                + "DELIVERYADDRESS, "
                + "IMAGE, "
                + "CREATEDDATE, "
                + "CREATEDBY) "
             + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected void prepareParameters(PreparedStatement stmt, Customer domain) throws SQLException {
        stmt.setString(1, domain.getUsername());
        stmt.setString(2, domain.getName());
        stmt.setString(3, domain.getPassword());
        stmt.setString(4, Constant.getStatus(StatusEnum.Activate));
        stmt.setString(5, domain.getPhone());
        stmt.setString(6, domain.getMail());
        stmt.setString(7, domain.getDeliveryAddress());
        stmt.setBlob(8, domain.getInputStream());
        stmt.setTimestamp(9, domain.getCreatedDate());
        stmt.setString(10, domain.getCreatedBy());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
        return Dal_Super.ExecutionTypeEnum.Update;
    }

}
