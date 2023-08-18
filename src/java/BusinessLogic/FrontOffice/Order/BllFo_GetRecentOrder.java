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
 * @author vinnie chin
 */
public class BllFo_GetRecentOrder extends Bll_Super<Order>{

    @Override
    public ArrayList<Order> businessLogic(Order domain) throws Exception {
        return super.run(domain);
    }
    
    @Override
    protected ArrayList<Order> execute(Connection conn, Order domain) throws SQLException {
        ArrayList<Order> recentOrder = new DataAccess.FrontOffice.Order.DalFo_GetRecent(conn).run(domain);
        
        for (Order order : recentOrder) {
            for (OrderDetail orderDetail : order.getOrderDetail()) {
            
            ArrayList<ProductImage> productImage = new DataAccess.FrontOffice.ProductImage.DalFo_GetById(conn).run(new ProductImage().setProductId(orderDetail.getProductId()));
            //Set first product image to recent order details
            if(productImage.size() > 0)
                orderDetail.setProductImage(productImage.get(0));
            }
        }
        
        return recentOrder;
    }
    
}
