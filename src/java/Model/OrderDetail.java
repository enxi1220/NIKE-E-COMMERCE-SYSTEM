package Model;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class OrderDetail extends Super<OrderDetail>{
    private int _orderDetailId;
    private int _orderId;
    private double _price;
    private int _quantity;
    private String _productName;
    private String _color;
    private String _size;
    private String _productNo;
    private int _productDetailId;
    private int _productId;
    private ProductImage _productImage;

    public int getOrderDetailId() {
        return _orderDetailId;
    }

    public OrderDetail setOrderDetailId(int orderDetailId) {
        _orderDetailId = orderDetailId;
        return this;
    }

    public int getOrderId() {
        return _orderId;
    }

    public OrderDetail setOrderId(int orderId) {
        _orderId = orderId;
        return this;
    }

    public double getPrice() {
        return _price;
    }

    public OrderDetail setPrice(double price) {
        _price = price;
        return this;
    }

    public int getQuantity() {
        return _quantity;
    }

    public OrderDetail setQuantity(int quantity) {
        _quantity = quantity;
        return this;
    }

    public String getProductName() {
        return _productName;
    }

    public OrderDetail setProductName(String productName) {
        _productName = productName;
        return this;
    }

    public String getColor() {
        return _color;
    }

    public OrderDetail setColor(String color) {
        _color = color;
        return this;
    }

    public String getSize() {
        return _size;
    }

    public OrderDetail setSize(String size) {
        _size = size;
        return this;
    }

    public int getProductDetailId() {
        return _productDetailId;
    }

    public OrderDetail setProductDetailId(int productDetailId) {
        _productDetailId = productDetailId;
        return this;
    }  

    public String getProductNo() {
        return _productNo;
    }

    public OrderDetail setProductNo(String productNo) {
        _productNo = productNo;
        return this;
    }

    public int getProductId() {
        return _productId;
    }

    public OrderDetail setProductId(int productId) {
        _productId = productId;
        return this;
    }
    
    public ProductImage getProductImage() {
        return _productImage;
    }

    public OrderDetail setProductImage(ProductImage productImage) {
        _productImage = productImage;
        return this;
    }
        
}
