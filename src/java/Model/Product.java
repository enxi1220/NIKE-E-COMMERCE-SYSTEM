package Model;

import java.io.Serializable;
import java.util.ArrayList;


/**
 *
 * @author Tham Jun Yuan
 */
public class Product extends Super<Product> implements Serializable{
    private int _productId;
//    private int _productDetailId;
//    private String _productDetailImageId;
    private String _productNo;
    private String _productName;
    private String _productDesc;
    private ArrayList<ProductDetail> _productDetail;
    private ArrayList<ProductImage> _productImage;
    private String _status;
    private String _category;
    private int _isFeatured;
    private double _price;
    
    public Product() {
    }
    
    public int getProductId() {
        return _productId;
    }

    public Product setProductId(int productId) {
        _productId = productId;
        return this;
    }
    
    public String getProductNo() {
        return _productNo;
    }
    
    public Product setProductNo(String productNo) {
        _productNo = productNo;
        return this;
    }
    
    public String getProductName() {
        return _productName;
    }
    
    public Product setProductName(String productName) {
        _productName = productName;
        return this;
    }
    
    public String getProductDesc() {
        return _productDesc;
    }
    
    public Product setProductDesc(String productDesc) {
        _productDesc = productDesc;
        return this;
    }
    
    public ArrayList<ProductDetail> getProductDetail() {
        return _productDetail;
    }
    
    public Product setProductDetail(ArrayList<ProductDetail> productDetail) {
        _productDetail = productDetail;
        return this;
    }

    public ArrayList<ProductImage> getProductImage() {
        return _productImage;
    }

    public Product setProductImage(ArrayList<ProductImage> productImage) {
        _productImage = productImage;
        return this;
    }
    
    public String getStatus() {
        return _status;
    }
    
    public Product setStatus(String status) {
        _status = status;
        return this;
    }
    
    public String getCategory() {
        return _category;
    }
    
    public Product setCategory(String category) {
        _category = category;
        return this;
    }
    
    public int getIsFeatured() {
        return _isFeatured;
    }
    
    public Product setIsFeatured(int isFeatured) {
        _isFeatured = isFeatured;
        return this;
    }
    
    public double getPrice() {
        return _price;
    }
    
    public Product setPrice(double price) {
        _price = price;
        return this;
    }

//    /**
//     * @return the _productDetailId
//     */
//    public int getProductDetailId() {
//        return _productDetailId;
//    }
//
//    /**
//     * @param _productDetailId the _productDetailId to set
//     */
//    public Product setProductDetailId(int productDetailId) {
//        _productDetailId = productDetailId;
//        return this;
//    }
//
//    /**
//     * @return the _productDetailImageId
//     */
//    public String getProductDetailImageId() {
//        return _productDetailImageId;
//    }
//
//    /**
//     * @param _productDetailImageId the _productDetailImageId to set
//     */
//    public void setProductDetailImageId(String _productDetailImageId) {
//        this._productDetailImageId = _productDetailImageId;
//    }
    
    
}
