/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.BackOffice.User;

import Model.User;
import DataAccess.Dal_Super;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author Lin
 */

public class DalBo_EditPassword extends Dal_Super<User>{

    public DalBo_EditPassword(Connection conn) {
        super(conn);
    }

    @Override
    protected String sqlStatement() {
        
      return "UPDATE \"USER\" SET "
              + "PASSWORD = ?, "
              + "UPDATEDBY = ?, "
              + "UPDATEDDATE = ? "
           + "WHERE USERNAME = ? ";
    }
    
    @Override
    protected void prepareParameters(PreparedStatement stmt, User domain) throws SQLException {
        stmt.setString(1, domain.getPassword());
        stmt.setString(2, domain.getUpdatedBy());
        stmt.setTimestamp(3, domain.getUpdatedDate());
        stmt.setString(4, domain.getUsername());
    }

    @Override
    protected Dal_Super.ExecutionTypeEnum executionType() {
      return Dal_Super.ExecutionTypeEnum.Update;
    }
    

}
