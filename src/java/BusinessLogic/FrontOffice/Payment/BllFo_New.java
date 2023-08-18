package BusinessLogic.FrontOffice.Payment;

import BusinessLogic.Bll_Super;
import Helper.Constant;
import Model.Order;
import Model.OrderDetail;
import Model.Payment;
import Model.ProductDetail;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public class BllFo_New extends Bll_Super<Payment> {

    private ArrayList<ProductDetail> _productDetails = new ArrayList<>();
    
    @Override
    public ArrayList<Payment> businessLogic(Payment domain) throws Exception {
//        get od
        ArrayList<Order> orders = new BusinessLogic.FrontOffice.Order.BllFo_GetFullDetail()
                .businessLogic(new Order().setOrderId(domain.getOrderId()));
        
//        get pd, product detail object, pd id
        for (int i = 0; i < orders.size(); i++) {
            OrderDetail od = orders.get(i).getOrderDetail().get(0);
            ArrayList<ProductDetail> productDetails = new BusinessLogic.FrontOffice.ProductDetail.BllFo_Get()
                    .businessLogic(new ProductDetail().setProductDetailId(od.getProductDetailId()));
            System.out.println("1");
            ProductDetail pd = productDetails.get(0);
            System.out.println("1");
            
//            check qty
            if(od.getQuantity() > pd.getPhysicalQty()){
                throw new Exception("We are sorry, "+ od.getProductName()+ " (Color: "+ od.getColor() 
                        + ", Size: " + od.getSize() +  ") is out of stock. Current stock is " + pd.getPhysicalQty());
            }
            
//            change salesoutqty
            int salesQty = pd.getSalesOutQty();
            int quantity = od.getQuantity();
            int newQty = salesQty + quantity;
            pd.setSalesOutQty(newQty);
            
//            prepare new pd detail
            _productDetails.add(pd);
        }
        
        domain.setPrice(orders.get(0).getPrice());
        domain.setDeliveryFee(orders.get(0).getDeliveryFee());
        domain.setCustomerName(domain.getCreatedBy());
        return super.run(domain);
    }

    @Override
    protected ArrayList<Payment> execute(Connection conn, Payment domain) throws SQLException {
        //        get payment no
//        change order status
//          + sales out qty
        ArrayList<Payment> payments = new DataAccess.FrontOffice.Payment.DalFo_GetUniqueNo(conn).run(domain);
        String paymentNo = Helper.UniqueNoGenerator.generator(payments.get(0).getPaymentNo(), "INV");
        domain.setPaymentNo(paymentNo);

        switch (domain.getPaymentMethod()) {
            case "Online Banking":
                new DataAccess.FrontOffice.Payment.DalFo_NewWithBank(conn).run(domain);
                break;
            case "Master Card":
            case "TNG E-wallet":
                new DataAccess.FrontOffice.Payment.DalFo_New(conn).run(domain);
                break;
        }
        new DataAccess.FrontOffice.Order.DalFo_Edit(conn).run(new Order()
                                                                .setOrderId(domain.getOrderId())
                                                                .setStatus(Helper.Constant.getStatus(Constant.StatusEnum.Paid))
                                                                .setUpdatedBy(domain.getCreatedBy())
                                                                .setUpdatedDate(domain.getCreatedDate())
        );
        
        for(ProductDetail pd: _productDetails){
            new DataAccess.FrontOffice.ProductDetail.DalFo_Edit(conn).run(pd);
        }
        
        return null;
    }

}
