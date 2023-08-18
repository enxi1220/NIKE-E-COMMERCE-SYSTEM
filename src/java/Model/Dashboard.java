/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Lin
 */

public class Dashboard extends Super<Dashboard> {

    private Customer _customer;
    
    private ArrayList<ProductDetail> _productDetail;
    private Order _order;
    private ArrayList<OrderDetail> _orderDetail;
    private Payment _payment;
    private Product _product;
    private int _sumCustomer;
    private int _sumOrder;
    private double _price;
    private String _sumQTY;
    
  
    public Customer getCustomer() {
        return _customer;
    }

    public Dashboard setCustomer(Customer customer) {
        _customer = customer;
        return this;
    }

        public ArrayList<ProductDetail> getProductDetail() {
        return _productDetail;
    }
    
    public Dashboard setProductDetail(ArrayList<ProductDetail> productDetail) {
        _productDetail = productDetail;
        return this;
    }
    
    
    public ArrayList<OrderDetail> getOrderDetail() {
        return _orderDetail;
    }

    public Dashboard setOrderDetail(ArrayList<OrderDetail> orderDetail) {
        _orderDetail = orderDetail;
        return this;
    }
        public Order getOrder() {
        return _order;
    }

    public Dashboard setOrder(Order order) {
        _order = order;
        return this;
    }
        public Payment getPayment() {
        return _payment;
    }

    public Dashboard setPayment(Payment payment) {
        _payment = payment;
        return this;
    }
    
    public Product getProduct() {
        return _product;
    }

    public Dashboard setProduct(Product product) {
        _product = product;
        return this;
    }
    public int getSumCustomer() {
        return _sumCustomer;
    }

    public Dashboard setSumCustomer(int sumCustomer) {
        _sumCustomer = sumCustomer;
        return this;
    }
    public int getSumOrder() {
        return _sumOrder;
    }

    public Dashboard setSumOrder(int sumOrder) {
        _sumOrder = sumOrder;
        return this;
    }
    public double getPrice() {
        return _price;
    }
    public Dashboard setPrice(double price) {
        _price = price;
        return this;
    }
    
        public String getSumQTY() {
        return _sumQTY;
    }

    public Dashboard setSumQTY(String sumQTY) {
        _sumQTY = sumQTY;
        return this;
    }
    

}

