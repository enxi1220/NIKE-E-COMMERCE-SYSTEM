<%-- 
    Document   : Bo.UserComfirm
    Created on : Feb 23, 2022, 5:49:41 PM
    Author     : Tan Lin Yi
--%>


<!-- -------------------------------------------------- Activate Modal -------------------------------------------------- -->


<div class="modal fade" id="user-activate" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Activation</h5>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">Are you sure you want to <b>Activate</b> this user?</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Close</button>
                <button type="button" id ="user-activate-btn" class="btn btn-primary">Confirm</button>
            </div>
        </div>
    </div>
</div>

<!-- -------------------------------------------------- Deactivate Modal -------------------------------------------------- -->

<div class="modal fade" id="user-deactivate" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Deactivation</h5>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">Are you sure you want to <b>Deactivate</b> this user?</div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Close</button>
                <button type="button" id ="user-deactivate-btn" class="btn btn-primary">Confirm</button>
            </div>
        </div>
    </div>
</div>

<!-- -------------------------------------------------- Logout Modal -------------------------------------------------- -->

<div class="modal fade" id="user-logout" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-capitalize" id="logOutModalLabel">Are you sure you want to Logout ?</h5>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <!--<div class="modal-body">Sure to Log Out?</div>-->
            <div class="modal-footer">
                <form id="userConfirmLogout">
                    <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Back</button>
                    <button type="submit" class="btn btn-primary" data-mdb-dismiss="modal">Confirm</button>
                </form>
            </div>
        </div>
    </div>
</div>







