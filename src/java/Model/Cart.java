package Model;

import java.util.ArrayList;

/**
 *
 * @author Lim En Xi
 */
public class Cart extends Super<Cart>{
    private int _cartId;
    private int _customerId;
    private Customer _customer; 
    private ArrayList<CartDetail> _cartDetail;
    
    public int getCartId() {
        return _cartId;
    }

    public Cart setCartId(int cartId) {
        _cartId = cartId;
        return this;
    }

    public int getCustomerId() {
        return _customerId;
    }

    public Cart setCustomerId(int customerId) {
        _customerId = customerId;
        return this;
    }
    
    public Customer getCustomer() {
        return _customer;
    }

    public Cart setCustomer(Customer customer) {
        _customer = customer;
        return this;
    }
    
    public ArrayList<CartDetail> getCartDetail() {
        return _cartDetail;
    }

    public Cart setCartDetail(ArrayList<CartDetail> cartDetail) {
        _cartDetail = cartDetail;
        return this;
    }
    
}