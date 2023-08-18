package Helper;

/**
 *
 * @author Lim En Xi
 */
public class RoleBaseAccessControl {

    public static boolean CheckAccess(String pageName, String userGroupName) {
        switch (userGroupName) {
            case "Admin":
                return Helper.RoleBaseAccessControl.AdminAccess(pageName);
            case "Staff":
                return Helper.RoleBaseAccessControl.StaffAccess(pageName);
            default:
                return false;
        }
    }

    private static boolean AdminAccess(String pageName) {
        switch (pageName) {
            case "CourierEdit":
            case "CourierNew":
            case "CourierSummary":
            case "CourierView":
            case "CustomerSummary":
            case "CustomerView":
            case "OrderEdit":
            case "OrderSummary":
            case "OrderView":
            case "PaymentSummary":
            case "PaymentView":
            case "ProductEdit":
            case "ProductNew":
            case "ProductNewDetail":
            case "ProductSummary":
            case "ProductView":
            case "ReorderReport":
            case "SalesReport":
            case "StockReport":
            case "UserAdd":
            case "UserEdit":
            case "UserSummary":
            case "UserView":
            case "Dashboard":
            case "Sales":
            case "ResetPassword":
            case "Activate":
            case "Deactivate":
                return true;
            default:
                return false;
        }
    }

    private static boolean StaffAccess(String pageName) {
        switch (pageName) {
            case "CourierEdit":
            case "CourierSummary":
            case "CourierNew":
            case "CourierView":
            case "OrderEdit":
            case "OrderSummary":
            case "OrderView":
            case "PaymentSummary":
            case "PaymentView":
            case "ProductEdit":
            case "ProductSummary":
            case "ProductView":
            case "ProductNew":
            case "ProductNewDetail":
            case "UserEdit":
            case "UserSummary":
            case "UserView":
            case "Dashboard":
                return true;
            default:
                return false;
        }
    }
}
