package Model;

/**
 *
 * @author Tham Jun Yuan
 */
public class ProductDetail extends Super<ProductDetail>{
    private int _productId;
    private int _productDetailId;
    private int _salesOutQty;
    private int _physicalQty;
    private String _size;
    private String _color;
    private int _minStockQty;

    public int getProductId() {
        return _productId;
    }
    
    public ProductDetail setProductId(int productId) {
        _productId = productId;
        return this;
    }
    
    public int getSalesOutQty() {
        return _salesOutQty;
    }
    
    public ProductDetail setSalesOutQty(int salesOutQty) {
        _salesOutQty = salesOutQty;
        return this;
    }
    
    public int getPhysicalQty() {
        return _physicalQty;
    }
    
    public ProductDetail setPhysicalQty(int physicalQty) {
        _physicalQty = physicalQty;
        return this;
    }
    
    public String getSize() {
        return _size;
    }
    
    public ProductDetail setSize(String size) {
        _size = size;
        return this;
    }
    
    public String getColor() {
        return _color;
    }
    
    public ProductDetail setColor(String color) {
        _color = color;
        return this;
    }
    
    public int getMinStockQty() {
        return _minStockQty;
    }
    
    public ProductDetail setMinStockQty(int minStockQty) {
        _minStockQty = minStockQty;
        return this;
    }
    
    public int getProductDetailId() {
        return _productDetailId;
    }
    
    public ProductDetail setProductDetailId(int productDetailId) {
        _productDetailId = productDetailId;
        return this;
    }
    
}
