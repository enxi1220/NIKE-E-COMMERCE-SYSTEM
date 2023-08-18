package Helper;

/**
 *
 * @author Lim En Xi
 */
public class Constant {

    public enum StatusEnum {
        Activate,
        Paid,
        Deactivate,
        Pending,
        Packaging,
        Shipping,
        Delivered,
        Completed,
        Cancelled
    }

    public enum CategoryEnum {
        Men,
        Women,
        Kids,
        Unisex
    }

    public static String getStatus(StatusEnum statusEnum) {
        switch (statusEnum) {
            case Activate:
                return "Activate";
            case Deactivate:
                return "Deactivate";
            case Pending:
                return "Pending";
            case Paid:
                return "Paid";
            case Packaging:
                return "Packaging";
            case Shipping:
                return "Shipping";
            case Delivered:
                return "Delivered";
            case Completed:
                return "Completed";
            case Cancelled:
                return "Cancelled";
            default:
                return "";
        }
    }

    public static String getCategory(CategoryEnum categoryEnum) {
        switch (categoryEnum) {
            case Men:
                return "Men";
            case Women:
                return "Women";
            case Kids:
                return "Kids";
            case Unisex:
                return "Unisex";
            default:
                return "";
        }
    }
}
