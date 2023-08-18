package BusinessLogic.FrontOffice.Cart;

import BusinessLogic.Bll_Super;
import Model.Cart;
import Model.CartDetail;
import Model.Product;
import Model.ProductDetail;
import Model.ProductImage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class BllFo_GetFull extends Bll_Super<Cart> {

    @Override
    public ArrayList<Cart> businessLogic(Cart domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Cart> execute(Connection conn, Cart domain) throws SQLException {
//        +get image
        ArrayList<Cart> carts = new DataAccess.FrontOffice.Cart.DalFo_GetFull(conn).run(domain);
        ArrayList<ProductImage> images = new ArrayList<>();

        for (int i = 0; i < carts.size(); i++) {
            CartDetail cd = carts.get(i).getCartDetail().get(0);
            Product p = cd.getProduct();
            ProductDetail pd = cd.getProduct().getProductDetail().get(0);
            System.out.println(p.getProductId() + " p id");
            images = new DataAccess.FrontOffice.ProductImage.DalFo_GetById(conn).run(new ProductImage().setProductId(p.getProductId()));
            p.setProductImage(images);
            for(ProductImage pi: images){
                System.out.println(pi.getProductImageId() + " pi id");
            }
        }
        
        return carts;
    }
}
