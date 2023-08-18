<%-- 
    Document   : Bo.Login
    Created on : Feb 23, 2022, 9:50:58 PM
    Author     : Tan Lin Yi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Nike Office | Reset Password</title>
        <%@include file="../../CSS_Resources.jsp" %>
         <%@include file="../Bo.HeaderANDNav.jsp"%>
        <link href="../../../StyleSheets/BackOffice/header.css" rel="stylesheet" type="text/css"/>
        <link href="../../../StyleSheets/BackOffice/login.css" rel="stylesheet" type="text/css"/>
        <link href="../../../StyleSheets/BackOffice/User/Bo.user.css" rel="stylesheet" type="text/css"/>
    </head>

    <!------ Include the above in your HEAD tag ---------->
    <body>

        <section class="vh-100">
            <div class="container py-2 h-15">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col col-xl-10">
                        <div class="card" style="border-radius: 1rem;">
                            <div class="row g-0">
                                <div class="col-md-6 col-lg-5 d-none d-md-block">
                                    <img src="../../Images/resetpassword.jpg"  class="img-fluid" style="border-radius: 1rem 0 0 1rem;" />
                                </div>
                                <div class="col-md-6 col-lg-7 d-flex align-items-center">
                                    <div class="card-body p-4 p-lg-4 text-black">

                                        <form id="userResetNewPassForm">

                                            <h5 class="fw-normal mb-3 pb-3" style="letter-spacing: 1px;">Reset Password</h5>

                                            <div class="form-outline my-3">
                                          <input type="password" id="userResetNewPass" class="form-control form-control-lg border"  />
                                                <label class="form-label" for="userResetNewPass">New Password</label>
                                                <div class="form-helper"></div>
                                            </div>
                                            <div class="form-outline my-3">
                                                <input type="password" id="userConfirmResetNewPass" class="form-control form-control-lg border"  />
                                                <label class="form-label" for="userConfirmResetNewPass">Confirm Password</label>
                                                <div class="form-helper"></div>
                                            </div>
                                            <div class="d-flex justify-content-end align-items-center mt-5">  
                                                <button type="submit" class="btn btn-secondary btn-block ">Save</button>
                                            </div>

                                        </form>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/User/Bo.ResetPassword.js" type="text/javascript"></script>
        <script src="../../../Scripts/BackOffice/User/Bo.User.js" type="text/javascript"></script>
    </body>


</html>