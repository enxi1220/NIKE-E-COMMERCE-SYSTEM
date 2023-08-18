<%-- 
    Document   : Fo.CustomerModal
    Created on : Feb 27, 2022, 4:44:54 PM
    Author     : vinnie chin
--%>

<!-- -------------------------------------------------- Forgot Password Modal -------------------------------------------------- -->
<div class="modal fade in " id="forgotPass-modal" tabindex="-1" aria-labelledby="forgotPassModalLabel" aria-hidden="true" data-mdb-backdrop="static" data-mdb-keyboard="false">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content p-2">
            <div class="modal-header">
                <h3 class="modal-title" id="forgotPassModalLabel">Forgot Password</h3>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body mt-3 mb-5">
                <form id="forgotPass-form">
                    <div class="form-outline">
                        <input type="email" id="forgotPassEmail" class="form-control border-bottom" />
                        <label class="form-label" for="forgotPassEmail">Enter Your Registered Email</label>
                    </div>
                    <span class="mt-3" id="email-sending-msg"></span>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Close</button>
                <button type="submit" class="btn btn-primary">Get OTP</button>
            </div> 
                </form>
        </div>
    </div>
</div>

<!-- -------------------------------------------------- OTP Modal -------------------------------------------------- -->
<div class="modal fade in " id="otp-modal" tabindex="-1" aria-labelledby="otpModalLabel" aria-hidden="true" data-mdb-backdrop="static" data-mdb-keyboard="false">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content p-2">
            <div class="modal-header">
                <h3 class="modal-title" id="otpModalLabel">OTP to reset password</h3>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body mt-3 mb-5">
                <form id="otp-form">
                     <div class="form-outline mt-3">
                        <input type="text" id="otpNum" class="form-control border-bottom"/>
                        <label class="form-label" for="otpNum">Enter OTP received in email</label>
                    </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Cancel</button>
                <button type="submit" class="btn btn-primary">Proceed</button>
            </div> 
                </form>
        </div>
    </div>
</div>

<!-- -------------------------------------------------- Reset Password Modal -------------------------------------------------- -->
<div class="modal fade" id="resetPass-modal" tabindex="-1" aria-labelledby="resetPassModalLabel" aria-hidden="true" data-mdb-backdrop="static" data-mdb-keyboard="false">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-capitalize" id="resetPassModalLabel">Reset your password</h5>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="resetPass-form">
                    <div class="form-outline mt-3">
                        <input type="password" id="custResetPass" class="form-control border-bottom" />
                        <label class="form-label" for="custResetPass">New Password</label>
                        <div class="form-helper"></div>
                    </div>
                
            </div>
            <div class="modal-footer">
                <button type="submit" class="btn btn-primary">Reset</button>
            </div>
            </form>
        </div>
    </div>
</div>

<!-- -------------------------------------------------- Change Password Modal -------------------------------------------------- -->
<div class="modal fade" id="changePass-modal" tabindex="-1" aria-labelledby="changePassModalLabel" aria-hidden="true" data-mdb-backdrop="static" data-mdb-keyboard="false">
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-capitalize" id="changePassModalLabel">Change new Password</h5>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="custChangePass-form">
                    <div class="form-outline mt-3">
                        <input type="password" id="custChangeNewPass" class="form-control border-bottom" />
                        <label class="form-label" for="custChangeNewPass">New Password</label>
                        <div class="form-helper"></div>
                    </div>
                
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Cancel</button>
                <button type="submit" class="btn btn-primary">Change</button>
            </div>
            </form>
        </div>
    </div>
</div>


<!-- -------------------------------------------------- Delete Account Modal -------------------------------------------------- -->
<div class="modal fade" id="deAcc-modal" tabindex="-1" aria-labelledby="deAccModalLabel" aria-hidden="true" data-mdb-backdrop="static" data-mdb-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-capitalize" id="deAccModalLabel">Delete Confirmation</h5>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">Are you sure you want to delete your account?</div>
            <div class="modal-body fw-bold"><i class="fas fa-exclamation-triangle"></i> Note: This action can't be undone.</div>
            <div class="modal-footer">
                <form id="custConfirmDeactivate">
                    <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Yes</button>
                </form>
            </div>
        </div>
    </div>
</div>

<!-- -------------------------------------------------- Log Out Modal -------------------------------------------------- -->

<div class="modal fade" id="logOut-modal" tabindex="-1" aria-labelledby="logOutModalLabel" aria-hidden="true" data-mdb-backdrop="static" data-mdb-keyboard="false">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title text-capitalize" id="logOutModalLabel">Sure to Log Out?</h5>
                <button type="button" class="btn-close" data-mdb-dismiss="modal" aria-label="Close"></button>
            </div>
            <!--<div class="modal-body">Sure to Log Out?</div>-->
            <div class="modal-footer">
                <form id="custConfirmLogOut">
                    <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Cancel</button>
                    <button type="submit" class="btn btn-primary">Yes</button>
                </form>
            </div>
        </div>
    </div>
</div>


