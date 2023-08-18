package BusinessLogic.FrontOffice.Product;

import Model.Product;

import BusinessLogic.Bll_Super;
import Model.ProductImage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author vinnie chin
 */
public class BllFo_GetBestSales extends Bll_Super<Product>{
   @Override
    public ArrayList<Product> businessLogic(Product domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Product> execute(Connection conn, Product domain) throws SQLException{
        
        ArrayList<Product> bestSalesProducts = new DataAccess.FrontOffice.Product.DalFo_GetBestSales(conn).run(domain);
        
        for (Product product : bestSalesProducts) {
            
            ArrayList<ProductImage> productImage = new DataAccess.FrontOffice.ProductImage.DalFo_GetById(conn).run(new ProductImage().setProductId(product.getProductId()));
            product.setProductImage(productImage);
       
        }
        
        return bestSalesProducts;
    }
}
