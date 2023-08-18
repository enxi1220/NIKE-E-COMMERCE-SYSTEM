package BusinessLogic.BackOffice.Product;

import BusinessLogic.Bll_Super;
import Helper.Constant;

import Model.Product;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Tham Jun Yuan
 */
public class BllBo_New extends Bll_Super<Product>{
    @Override
    public ArrayList<Product> businessLogic(Product domain) throws Exception {
        
        domain.setCreatedDate(Helper.CurrentDate.getDate());
        domain.setStatus(Helper.Constant.getStatus(Constant.StatusEnum.Activate));
        return super.run(domain);
    }

    @Override
    protected ArrayList<Product> execute(Connection conn, Product domain) throws SQLException{
        
        ArrayList<Product> products = new DataAccess.BackOffice.Product.DalBo_GetUniqueNo(conn).run(domain);
        
        String productNo = Helper.UniqueNoGenerator.generator(products.get(0).getProductNo(), "SKU");
       
        new DataAccess.BackOffice.Product.DalBo_New(conn).run(domain.setProductNo(productNo));
       
        products = new DataAccess.BackOffice.Product.DalBo_GetPrimaryKey(conn).run(domain);
        
        return products;
    }
    
}
