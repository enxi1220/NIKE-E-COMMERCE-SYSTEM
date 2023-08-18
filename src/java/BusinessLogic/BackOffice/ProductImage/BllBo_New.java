/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessLogic.BackOffice.ProductImage;

import BusinessLogic.Bll_Super;
import Model.Product;
import Model.ProductImage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author User
 */
public class BllBo_New extends Bll_Super<ProductImage>{

    @Override
    public ArrayList<ProductImage> businessLogic(ProductImage domain) throws Exception {
        domain.setCreatedDate(Helper.CurrentDate.getDate());
        return super.run(domain);
    }

    @Override
    protected ArrayList<ProductImage> execute(Connection conn, ProductImage domain) throws SQLException {
        new DataAccess.BackOffice.ProductImage.DalBo_New(conn).run(domain);
        
        new DataAccess.BackOffice.Product.DalBo_Update(conn).run(new Product().setUpdatedDate(domain.getCreatedDate())
                                                                                .setUpdatedBy(domain.getUpdatedBy())
                                                                                .setProductId(domain.getProductId()));
        
        return null;
    }
    
}
