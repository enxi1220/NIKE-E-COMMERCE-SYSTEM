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
public class BllFo_Get extends Bll_Super<Product>{
   @Override
    public ArrayList<Product> businessLogic(Product domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Product> execute(Connection conn, Product domain) throws SQLException{
     
        ArrayList<Product> product = new DataAccess.FrontOffice.Product.DalFo_Get(conn).run(domain);

        // Loop through the product list and set image into it by calling the product image data access layer
        for (Product productImg : product) {
            ArrayList<ProductImage> images = new DataAccess.FrontOffice.ProductImage.DalFo_Get(conn)
                    .run(new ProductImage().setProductId(productImg.getProductId()));
            productImg.setProductImage(images);
        }

        return product;
    }
}
