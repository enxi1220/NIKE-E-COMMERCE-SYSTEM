package Model;

import java.util.ArrayList;

/**
 *
 * @author vinnie chin
 */
public class Order extends Super<Order>{
    private int _orderId;
    private String _orderNo;
    private String _receiverName;
    private String _deliveryAddress;
    private double _price;
    private double _deliveryFee;
    private String _trackingNo;
    private String _status;
    private Customer _customer;
    private int _customerId;
    private Courier _courier;
    private int _courierId;
    private ArrayList<OrderDetail> _orderDetail;
    private int _cartId;

    private int _count;

    public Customer getCustomer() {
        return _customer;
    }

    public int getOrderId() {
        return _orderId;
    }

    public String getOrderNo() {
        return _orderNo;
    }

    public String getReceiverName() {
        return _receiverName;
    }

    public String getDeliveryAddress() {
        return _deliveryAddress;
    }

    public double getPrice() {
        return _price;
    }

    public double getDeliveryFee() {
        return _deliveryFee;
    }

    public String getTrackingNo() {
        return _trackingNo;
    }

    public String getStatus() {
        return _status;
    }

    public Order setOrderId(int orderId) {
        _orderId = orderId;
        return this;
    }

    public Order setOrderNo(String orderNo) {
        _orderNo = orderNo;
        return this;
    }

    public Order setReceiverName(String receiverName) {
        _receiverName = receiverName;
        return this;
    }

    public Order setDeliveryAddress(String deliveryAddress) {
        _deliveryAddress = deliveryAddress;
        return this;
    }

    public Order setPrice(double price) {
        _price = price;
        return this;
    }

    public Order setDeliveryFee(double deliveryFee) {
        _deliveryFee = deliveryFee;
        return this;
    }

    public Order setTrackingNo(String trackingNo) {
        _trackingNo = trackingNo;
        return this;
    }

    public Order setStatus(String status) {
        _status = status;
        return this;
    }

    public Order setCustomer(Customer customer) {
        _customer = customer;
        return this;
    }

    public Courier getCourier() {
        return _courier;
    }

    public Order setCourier(Courier courier) {
        _courier = courier;
        return this;
    }
    
    public int getCount() {
        return _count;
    }
    
    public Order setCount(int count) {
        _count = count;
        return this;
    }

    public ArrayList<OrderDetail> getOrderDetail() {
        return _orderDetail;
    }

    public Order setOrderDetail(ArrayList<OrderDetail> orderDetail) {
        _orderDetail = orderDetail;
        return this;
    }

    public int getCartId() {
        return _cartId;
    }

    public Order setCartId(int cartId) {
        _cartId = cartId;
        return this;
    }

    public int getCustomerId() {
        return _customerId;
    }

    public Order setCustomerId(int customerId) {
        _customerId = customerId;
        return this;
    }

    public int getCourierId() {
        return _courierId;
    }

    public Order setCourierId(int courierId) {
        _courierId = courierId;
        return this;
    }
    
    

}
