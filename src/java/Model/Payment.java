package Model;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class Payment extends Super<Payment>{
    private int _paymentId;
    private String _paymentNo;
    private String _paymentMethod;
    private double _price;
    private double _deliveryFee;
    private String _bankType;
    private String _customerName;
    private Order _order;
    private int _orderId;

    public int getPaymentId() {
        return _paymentId;
    }

    public Payment setPaymentId(int paymentId) {
        _paymentId = paymentId;
        return this;
    }

    public String getPaymentNo() {
        return _paymentNo;
    }

    public Payment setPaymentNo(String paymentNo) {
        _paymentNo = paymentNo;
        return this;
    }

    public String getPaymentMethod() {
        return _paymentMethod;
    }

    public Payment setPaymentMethod(String paymentMethod) {
        _paymentMethod = paymentMethod;
        return this;
    }

    public double getPrice() {
        return _price;
    }

    public Payment setPrice(double price) {
        _price = price;
        return this;
    }

    public double getDeliveryFee() {
        return _deliveryFee;
    }

    public Payment setDeliveryFee(double deliveryFee) {
        _deliveryFee = deliveryFee;
        return this;
    }

    public String getBankType() {
        return _bankType;
    }

    public Payment setBankType(String bankType) {
        _bankType = bankType;
        return this;
    }

    public String getCustomerName() {
        return _customerName;
    }

    public Payment setCustomerName(String customerName) {
        _customerName = customerName;
        return this;
    }

    public Order getOrder() {
        return _order;
    }

    public Payment setOrder(Order order) {
        _order = order;
        return this;
    }

    public int getOrderId() {
        return _orderId;
    }

    public Payment setOrderId(int orderId) {
        _orderId = orderId;
        return this;
    }
    
}
