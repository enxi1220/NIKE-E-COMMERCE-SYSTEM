<%-- 
    Document   : Fo.OrderModal
    Created on : 19 Feb 2022, 1:06:55 am
    Author     : Lim En Xi
--%>

<!--Order Summary: Copy tracking no to clipboard-->
    <div class="modal fade" id="copy-tracking-no" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-capitalize" id="exampleModalLabel">information</h5>
                    <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">You have successfully copied the tracking number.</div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-info" data-mdb-dismiss="modal">Close</button>
                </div>
            </div>
        </div>
    </div>

<!--Order Summary: Clicked Cancel Order-->
    <div class="modal fade" id="cancel-order" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-capitalize" id="exampleModalLabel">confirmation</h5>
                    <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">Are you sure to cancel the order?</div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Close</button>
                    <button type="button" class="btn btn-primary" data-mdb-dismiss="modal" id="confirm-cancel-order">Confirm</button>
                </div>
            </div>
        </div>
    </div>

<!--Order New: Clicked Place Order-->
    <div class="modal fade" id="proceed-payment-confirmation" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title text-capitalize" id="exampleModalLabel">confirmation</h5>
                    <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">Do you want to proceed to the payment?</div>
                <div class="modal-footer">
                    <a type="button" class="btn btn-secondary" data-mdb-dismiss="modal" href="../Fo.Home.jsp">No</a>
                    <!-- todo: to PaymentNew?orderId= -->
                    <a type="button" class="btn btn-secondary" data-mdb-dismiss="modal" href="../Payment/Fo.PaymentNew.jsp">Yes</a>
                </div>
            </div>
        </div>
    </div>