package Model;

/**
 *
 * @author Alvin Chan Ee Aun
 */
public class Courier extends Super<Courier>{
    private int _courierId;
    private String _courierName;
    private String _status;
    private double _courierPrice;
    
    public int getCourierId(){
        return _courierId;
    }

    public Courier setCourierId(int courierId) {
        _courierId = courierId;
        return this;
    }
    
    public String getCourierName() {
        return _courierName;
    }

    public Courier setCourierName(String courierName) {
        _courierName = courierName;
        return this;
    }

    public String getStatus() {
        return _status;
    }

    public Courier setStatus(String status) {
        _status = status;
        return this;
    }

    public double getCourierPrice() {
        return _courierPrice;
    }

    public Courier setCourierPrice(double courierPrice) {
        _courierPrice = courierPrice;
        return this;
    }
}

