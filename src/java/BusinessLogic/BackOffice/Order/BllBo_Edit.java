package BusinessLogic.BackOffice.Order;

import Model.Order;
import BusinessLogic.Bll_Super;
import Helper.Constant;
import Model.ProductDetail;
import Model.OrderDetail;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class BllBo_Edit extends Bll_Super<Order> {

    private ArrayList<ProductDetail> _productDetails = new ArrayList<>();

    @Override
    public ArrayList<Order> businessLogic(Order domain) throws Exception {

        //check domain status if is shipping, then need get order from db where id is same
        //check domain status and order status is not same, then need update phy qty
        if (domain.getStatus().equals(Helper.Constant.getStatus(Constant.StatusEnum.Shipping))) {

            ArrayList<Order> orders = new BusinessLogic.BackOffice.Order.BllBo_Get().businessLogic(domain);
            System.out.print(orders.get(0).getStatus());
            if (domain.getStatus() != orders.get(0).getStatus()) {

                for (int i = 0; i < orders.size(); i++) {
                    OrderDetail od = orders.get(i).getOrderDetail().get(0);
                    ArrayList<ProductDetail> productDetails = new BusinessLogic.FrontOffice.ProductDetail.BllFo_Get()
                            .businessLogic(new ProductDetail().setProductDetailId(od.getProductDetailId()));
                    System.out.println("1");
                    ProductDetail pd = productDetails.get(0);
                    System.out.println("1");

//            change physical qty
                    int physicalQty = pd.getPhysicalQty();
                    int quantity = od.getQuantity();
                    int newQty = physicalQty - quantity;
                    pd.setPhysicalQty(newQty);

//            prepare new pd detail
                    _productDetails.add(pd);
                }
            }
        }

        domain.setUpdatedDate(Helper.CurrentDate.getDate());

        return super.run(domain);
    }

    @Override
    protected ArrayList<Order> execute(Connection conn, Order domain) throws SQLException {

        for (ProductDetail pd : _productDetails) {
            new DataAccess.BackOffice.ProductDetail.DalBo_EditPhysicalQty(conn).run(pd);
        }

        return new DataAccess.BackOffice.Order.DalBo_Edit(conn).run(domain);
    }

}
