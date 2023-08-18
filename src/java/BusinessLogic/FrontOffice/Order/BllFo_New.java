package BusinessLogic.FrontOffice.Order;

import BusinessLogic.Bll_Super;
import Model.Cart;
import Model.CartDetail;
import Model.Courier;
import Model.Customer;
import Model.Order;
import Model.OrderDetail;
import Model.Product;
import Model.ProductDetail;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public class BllFo_New extends Bll_Super<Order> {

    @Override
    public ArrayList<Order> businessLogic(Order domain) throws Exception {
        
//        get cart, cd, pd info
        ArrayList<Cart> carts = new BusinessLogic.FrontOffice.Cart.BllFo_GetFull()
                .businessLogic(new Cart()
                        .setCustomer(new Customer()
                                .setUsername(domain.getCreatedBy())
                        ));

//        form order detail array object, if qty exceed, fail
        ArrayList<OrderDetail> orderDetails = new ArrayList<>();
        for (int i = 0; i < carts.size(); i++) {
            CartDetail cd = carts.get(i).getCartDetail().get(0);
            Product p = cd.getProduct();
            System.out.println(p.getProductId() + " p idddddddddddddddddddddd");
            ProductDetail pd = cd.getProduct().getProductDetail().get(0);
            
            if (cd.getQuantity() > pd.getPhysicalQty()) {
                throw new Exception("We are sorry, "+ p.getProductName()+ " (Color: "+ pd.getColor() 
                        + ", Size: " + pd.getSize() +  ") is out of stock. Current stock is " + pd.getPhysicalQty());
            }
            orderDetails.add(new OrderDetail()
                    .setColor(pd.getColor())
                    .setSize(pd.getSize())
                    .setPrice(p.getPrice())
                    .setProductId(p.getProductId())
                    .setProductNo(p.getProductNo())
                    .setQuantity(cd.getQuantity())
                    .setProductName(p.getProductName())
                    .setProductDetailId(pd.getProductDetailId())
                    .setCreatedBy(domain.getCreatedBy())
                    .setCreatedDate(domain.getCreatedDate())
            );
        }
        domain.setOrderDetail(orderDetails);

//        get courier info
        ArrayList<Courier> couriers = new BusinessLogic.FrontOffice.Courier.BllFo_Get()
                .businessLogic(new Courier().setCourierId(domain.getCourierId()));

//        calculate price
        domain.setDeliveryFee(couriers.get(0).getCourierPrice());

        double totalPrice = 0;
        for (OrderDetail od : domain.getOrderDetail()) {
            totalPrice += (od.getQuantity() * od.getPrice());
        }
        totalPrice += domain.getDeliveryFee();
        domain.setPrice(totalPrice);
        
        return super.run(domain);
    }

    @Override
    protected ArrayList<Order> execute(Connection conn, Order domain) throws SQLException {
        //        get order no
        ArrayList<Order> orders = new DataAccess.FrontOffice.Order.DalFo_GetUniqueNo(conn).run(domain);
        String orderNo = Helper.UniqueNoGenerator.generator(orders.get(0).getOrderNo(), "SO");
        //        insert order
        new DataAccess.FrontOffice.Order.DalFo_New(conn).run(domain.setOrderNo(orderNo));
        //        get order pk
        orders = new DataAccess.FrontOffice.Order.DalFo_GetPrimaryKey(conn).run(domain);
        int orderId = orders.get(0).getOrderId();
        //        insert order detail
        for (OrderDetail od : domain.getOrderDetail()) {
            new DataAccess.FrontOffice.OrderDetail.DalFo_New(conn).run(od.setOrderId(orderId));
        }
        //        clear cart
        new DataAccess.FrontOffice.Cart.DalFo_Delete(conn).run(new Cart().setCartId(domain.getCartId()));
        
        return orders;
    }

}
