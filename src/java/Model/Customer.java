
package Model;

import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

/**
 *
 * @author Tan Lin Yi
 */
public class Customer extends Super<Customer>{
    private int _customerId;
    private String _username;
    private String _deliveryAddress;
    private String _name;
    private String _password;
    private String _status;
    private String _phone;
    private String _mail;
    private Blob _image;
    private String _imageAsBase64;
    private InputStream _inputStream;
    private OutputStream _outputStream;
    private int _cartItemQty;
    private int _orderedQty;
    private String _randomOTP;

    public String getRandomOTP() {
        return _randomOTP;
    }

    public Customer setRandomOTP(String randomOTP) {
        _randomOTP = randomOTP;
        return this;
    }

    public String getImageAsBase64(){
        return _imageAsBase64;
    }
    
    public Customer setImageAsBase64(String imageAsBase64){
        _imageAsBase64 = imageAsBase64;
        return this;
    }

    public InputStream getInputStream() {
        return _inputStream;
    }

    public Customer setInputStream(InputStream inputStream) {
        _inputStream = inputStream;
        return this;
    }
    
     public OutputStream getOutputStream() {
        return _outputStream;
    }

    public Customer setOutputStream(OutputStream outputStream) {
        _outputStream = outputStream;
        return this;
    }
    
    public int getCustomerId(){
        return _customerId;
    }
    
    public Customer setCustomerId(int customerId){
        _customerId = customerId;
        return this;
    }
    
    public String getUsername(){
        return _username;
    }
    
    public Customer setUsername(String username){
        _username = username;
        return this;
    }
    
    public String getDeliveryAddress(){
        return _deliveryAddress;
    }
    
    public Customer setDeliveryAddress(String deliveryAddress){
        _deliveryAddress = deliveryAddress;
        return this;
    }
    
    public String getName(){
        return _name;
    }
    
    public Customer setName(String name){
        _name = name;
        return this;         
    }
    
     public String getPassword(){
        return _password;
    }
    
    public Customer setPassword(String password){
        _password = password;
        return this;
    }
    
    public String getStatus(){
        return _status;
    }
    
    public Customer setStatus(String status){
        _status = status;
        return this;
    }
    
    public String getPhone(){
        return _phone;
    }
    
    public Customer setPhone(String phone){
        _phone = phone;
        return this;
    }
    
    public String getMail(){
        return _mail;
    }
    
    public Customer setMail(String mail){
        _mail = mail;
        return this;
    }
    
    public Blob getImage(){
        return _image;
    }
    
    public Customer setImage(Blob image){
        _image = image;
        return this;
    }
    
    public int getCartItemQty() {
        return _cartItemQty;
    }

    public Customer setCartItemQty(int cartItemQty) {
        _cartItemQty = cartItemQty;
        return this;
    }

    public int getOrderedQty() {
        return _orderedQty;
    }

    public Customer setOrderedQty(int orderedQty) {
        _orderedQty = orderedQty;
        return this;
    }
  
}
