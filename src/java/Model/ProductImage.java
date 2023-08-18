package Model;

import java.io.InputStream;
import java.sql.Blob;

/**
 *
 * @author Tham Jun Yuan
 */
public class ProductImage extends Super<ProductImage>{
    private int _productImageId;
    private int _productId;
    private Blob _image;
    private String _imageType;
    private String _imageAsBase64;
    private String _productNo;
    private InputStream _inputStream;
    
    public InputStream getInputStream() {
        return _inputStream;
    }

    public ProductImage setInputStream(InputStream inputStream) {
        _inputStream = inputStream;
        return this;
    }
    
    
    public int getProductId() {
        return _productId;
    }
    
    public ProductImage setProductId(int productId) {
        _productId = productId;
        return this;
    }
    
    public Blob getImage() {
        return _image;
    }
    
    public ProductImage setImage(Blob image) {
        _image = image;
        return this;
    }
    
    public int getProductImageId() {
        return _productImageId;
    }
    
    public ProductImage setProductImageId(int productImageId) {
        _productImageId = productImageId;
        return this;
    }

    public String getImageType() {
        return _imageType;
    }

    public ProductImage setImageType(String imageType) {
        _imageType = imageType;
        return this;
    }
    
    public String getImageAsBase64() {
        return _imageAsBase64;
    }

    public ProductImage setImageAsBase64(String imageAsBase64) {
        _imageAsBase64 = imageAsBase64;
        return this;
    }

    public String getProductNo() {
        return _productNo;
    }

    public ProductImage setProductNo(String productNo) {
        _productNo = productNo;
        return this;
    }
}
