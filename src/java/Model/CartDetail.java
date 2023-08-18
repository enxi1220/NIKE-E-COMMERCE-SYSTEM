package Model;

/**
 *
 * @author Lim En Xi
 */
public class CartDetail extends Super<CartDetail> {
    private int _cartDetailId;
    private int _cartId;
    private int _productDetailId;
    private int _quantity;
    private int _customerId;
    private Product _product;

    public Product getProduct() {
        return _product;
    }

    public CartDetail setProduct(Product product) {
        this._product = product;
        return this;
    }

    public int getCartDetailId() {
        return _cartDetailId;
    }

    public CartDetail setCartDetailId(int cartDetailId) {
        _cartDetailId = cartDetailId;
        return this;
    }

    public int getCartId() {
        return _cartId;
    }

    public CartDetail setCartId(int cartId) {
        _cartId = cartId;
        return this;
    }

    public int getProductDetailId() {
        return _productDetailId;
    }

    public CartDetail setProductDetailId(int productDetailId) {
        _productDetailId = productDetailId;
        return this;
    }

    public int getQuantity() {
        return _quantity;
    }

    public CartDetail setQuantity(int quantity) {
        _quantity = quantity;
        return this;
    }

    public int getCustomerId() {
        return _customerId;
    }

    public CartDetail setCustomerId(int customerId) {
        _customerId = customerId;
        return this;
    }
    
    
}