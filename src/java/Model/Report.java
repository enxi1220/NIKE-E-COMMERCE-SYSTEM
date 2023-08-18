/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author Lin
 */
public class Report extends Super<Report> {

    private Timestamp _dateFrom;
    private Timestamp _dateTo;
    private ArrayList<ProductDetail> _productDetail;
    private Order _order;
    private ArrayList<OrderDetail> _orderDetail;
    private Payment _payment;
    private Product _product;
    private String _sumQTY;
    private String _salesOutQTY;
    
  
    public Timestamp getDateFrom(){
        return _dateFrom;
    }
    
    public Report setDateFrom(Timestamp dateFrom){
        _dateFrom = dateFrom;
        return this;
    }
    
    public Timestamp getdateTo(){
        return _dateTo;
    }
    
    public Report setdateTo(Timestamp dateTo){
        _dateTo = dateTo;
        return this;
    }
    
        public ArrayList<ProductDetail> getProductDetail() {
        return _productDetail;
    }
    
    public Report setProductDetail(ArrayList<ProductDetail> productDetail) {
        _productDetail = productDetail;
        return this;
    }
    
    
    public ArrayList<OrderDetail> getOrderDetail() {
        return _orderDetail;
    }

    public Report setOrderDetail(ArrayList<OrderDetail> orderDetail) {
        _orderDetail = orderDetail;
        return this;
    }
        public Order getOrder() {
        return _order;
    }

    public Report setOrder(Order order) {
        _order = order;
        return this;
    }
        public Payment getPayment() {
        return _payment;
    }

    public Report setPayment(Payment payment) {
        _payment = payment;
        return this;
    }
    
    public Product getProduct() {
        return _product;
    }

    public Report setProduct(Product product) {
        _product = product;
        return this;
    }
    public String getSumQTY() {
        return _sumQTY;
    }

    public Report setSumQTY(String sumQTY) {
        _sumQTY = sumQTY;
        return this;
    }
    
    public String getSalesOutQTY() {
        return _salesOutQTY;
    }

    public Report setSalesOutQTY(String salesOutQTY) {
        _salesOutQTY = salesOutQTY;
        return this;
    }

}
