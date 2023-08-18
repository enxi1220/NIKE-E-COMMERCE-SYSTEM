<%-- 
    Document   : Fo.CartModal
    Created on : Apr 11, 2022, 1:04:20 AM
    Author     : Lim En Xi 
--%>
<!--Order Summary: Clicked Cancel Order-->
<div class="modal fade" id="delete-cart-detail" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-capitalize" id="exampleModalLabel">confirmation</h5>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">Are you sure to delete the cart item?</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary" data-mdb-dismiss="modal" id="confirm-delete-cart-detail">Confirm</button>
            </div>
        </div>
    </div>
</div>