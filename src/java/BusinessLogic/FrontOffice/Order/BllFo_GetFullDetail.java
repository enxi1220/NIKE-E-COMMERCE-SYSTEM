package BusinessLogic.FrontOffice.Order;

import BusinessLogic.Bll_Super;
import Model.Order;
import Model.OrderDetail;
import Model.ProductImage;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public class BllFo_GetFullDetail extends Bll_Super<Order>{

    @Override
    public ArrayList<Order> businessLogic(Order domain) throws Exception {
        return super.run(domain);
    }

    @Override
    protected ArrayList<Order> execute(Connection conn, Order domain) throws SQLException {
        ArrayList<Order> orders = new DataAccess.FrontOffice.Order.DalFo_GetFullDetail(conn).run(domain);
        ArrayList<ProductImage> images = new ArrayList<>();
        
        for (int i = 0; i < orders.size(); i++) {
            OrderDetail od = orders.get(i).getOrderDetail().get(0);
            images = new DataAccess.FrontOffice.ProductImage.DalFo_GetByNo(conn).run(new ProductImage().setProductNo(od.getProductNo()));
            od.setProductImage(images.get(0));
            for(ProductImage pi: images){
                System.out.println(pi.getProductImageId() + " pi id");
            }
        }
        return orders;
    }
    
}
