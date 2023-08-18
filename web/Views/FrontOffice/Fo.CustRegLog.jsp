<%--
    Document   : Fo.CustRegLog
    Created on : Feb 20, 2022, 9:50:23 PM
    Author     : vinnie chin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Nike Simple | Login & Register</title>
    <%@include file="Fo.Header.jsp" %>
    <%@include file="Customer/Fo.CustomerModal.jsp" %>
    

    <style>
        .light-deco {
            color: var(--twine);
        }
    </style>
</head>

<body>
<!------------------- Outer Container ------------------->
    <div class="container w-50 p-5">
        <!------------- Pill-Tabs ------------->
        <ul class="nav nav-pills nav-justified mb-3" id="ex1" role="tablist">
            <!----- Login-Tab ----->
            <li class="nav-item" role="presentation">
                <a class="nav-link active"
                   id="tab-login"
                   data-mdb-toggle="pill"
                   href="#pills-login"
                   role="tab"
                   aria-controls="pills-login"
                   aria-selected="true">Login</a>
            </li>
            <!----- Register-Tab ----->
            <li class="nav-item" role="presentation">
                <a class="nav-link"
                   id="tab-register"
                   data-mdb-toggle="pill"
                   href="#pills-register"
                   role="tab"
                   aria-controls="pills-register"
                   aria-selected="false">Register</a>
            </li>
        </ul>
        <!------------- Pill-Tabs ------------->
        
        <!------------- Tab-Content ------------->
        <div class="tab-content">
            <!-------- Login-Content -------->
            <div class="tab-pane fade show active" id="pills-login" role="tabpanel" aria-labelledby="tab-login">
                <form id="custLogin">
                    <!----- Email ----->
                    <div class="form-outline mb-4">
                        <input type="text" id="custLoginName" class="form-control " value="${cookie['cookuser'].getValue()}" />
                        <label class="form-label" for="custLoginName">Username</label>
                    </div>
                    <!----- Password ----->
                    <div class="form-outline mb-4">
                        <input type="password" id="custLoginPass" class="form-control " value=""/>
                        <label class="form-label" for="custLoginPass">Password</label>
                    </div>
                    <!----- Actions ----->
                    <div class="row mb-4">
                        <div class="col-md-6 d-flex justify-content-start">
                            <!--- Remember-Me --->
                            <div class="form-check mb-3 mb-md-0 ms-2">
                                <input class="form-check-input" type="checkbox" value="" name="rmbCust" id="rmbCust" 
                                 <pre:if test="${not empty cookie['cookuser']}">checked="checked"</pre:if>/>
                                <label class="form-check-label" for="loginCheck"> Remember me </label>
                            </div>
                        </div>
                        <!----- Forgot-Pass ----->
                        <div class="col-md-6 d-flex justify-content-end">
                            <!-- Simple link -->
                            <a class="light-deco" href="#!" data-mdb-toggle="modal" data-mdb-target="#forgotPass-modal">Forgot password?</a>
                        </div>
                    </div>
                    <!----- Login-Button ----->
                    <div class="col-md-3 m-auto mt-5 mb-3">
                        <button type="submit" class="btn btn-secondary btn-block btn-rounded py-3">Log in</button>
                    </div>
                    <!----- Register ----->
                    <div class="text-center">
                        <p>Not a member? <a href="#" id="registerLink" class="light-deco">Register</a></p>
                    </div>
                </form>
            </div>
            <!-------- Login-Content -------->
            
            <!-------- Register-Content -------->
            <div class="tab-pane fade" id="pills-register" role="tabpanel" aria-labelledby="tab-register">
                <form class="row g-3 needs-validation" id="custRegAcc">
                    <!----- Name ----->
                    <div class="col-md-6">
                        <div class="form-outline">
                            <input type="text" class="form-control " id="custRegName" value="" />
                            <label for="custRegName" class="form-label">Full Name</label>
                        </div>
                    </div>
                    <!----- Username ----->
                    <div class="col-md-6">
                        <div class="form-outline">
                            <input type="text" class="form-control " id="custRegUsername" aria-describedby="inputGroupPrepend"  />
                            <label for="custRegUsername" class="form-label">Username</label>
                        </div>
                    </div>
                    <!----- Register-Email ----->
                    <div class="col-md-6">
                        <div class="form-outline">
                            <input type="email" id="custRegMail" class="form-control " />
                            <label class="form-label" for="custRegMail">Email</label>
                        </div>
                    </div>
                    <!----- Profile ----->
                    <div class="col-md-6">
                        <div class="form">
                            <button class="btn btn-outline-secondary rounded" type="button" id="inputGroupFileAddon03" onclick="$('#custRegPic').click()">
                                Profile (Optional)
                            </button>
                            <img id="custRegPicPre" class="rounded-circle" src="<%=request.getContextPath()%>/Views/Images/icon.png" alt="" style="border: 0.5px solid lightgrey; width:38px; height:38px; margin-left: 38px;  object-fit: cover;">
                            <input type="file" class="form-control" id="custRegPic" aria-describedby="inputGroupFileAddon03" aria-label="Upload" onchange="picPreview(this)" style="display: none;" />
                        </div>
                    </div>
                    <!----- Password ----->
                    <div class="col-md-6">
                        <div class="form-outline">
                            <input type="password" id="custRegPass" class="form-control " data-mdb-showcounter="true" maxlength="30" />
                            <label class="form-label" for="custRegPass">Password</label>
                            <div class="form-helper"></div>
                        </div>
                    </div>
                    <!----- Confirm Password ----->
                    <div class="col-md-6">
                         <div class="form-outline">
                            <input type="password" id="custRegPass2" class="form-control " data-mdb-showcounter="true" maxlength="30" />
                            <label class="form-label" for="custRegPass2">Confirm Password</label>
                            <div class="form-helper"></div>
                        </div>
                    </div>
                    <!-------- Separate Line -------->
                    <section class="border-top border-2 mt-4 mb-1"></section>

                    <!----- Phone ----->
                    <div class="col-md-6">
                        <div class="form-outline">
                            <input type="tel" id="custRegPhone" class="form-control " />
                            <label class="form-label" for="custRegPhone">Phone</label>
                        </div>
                    </div>
                    <!----- State ----->
                    <div class="col-md-6">
                            <select class="form-control form-select" id="addressState" aria-label=".form-select example" aria-invalid="false">
                                <option value="" selected hidden>State</option>
                                <option value="">None</option>
                                <option value="Johor">Johor</option>
                                <option value="Kedah">Kedah</option>
                                <option value="Kelantan">Kelantan</option>
                                <option value="Kuala Lumpur">Kuala Lumpur</option>
                                <option value="Labuan">Labuan</option>
                                <option value="Melaka">Melaka</option>
                                <option value="Negeri Sembilan">Negeri Sembilan</option>
                                <option value="Pahang">Pahang</option>
                                <option value="Pulau Pinang">Pulau Pinang</option>
                                <option value="Perak">Perak</option>
                                <option value="Perlis">Perlis</option>
                                <option value="Putrajaya">Putrajaya</option>
                                <option value="Sabah">Sabah</option>
                                <option value="Sarawak">Sarawak</option>
                                <option value="Selangor">Selangor</option>
                                <option value="Terengganu">Terengganu</option>
                            </select>
                    </div>
                    <!----- Postcode ----->
                    <div class="col-md-6">
                        <div class="form-outline">
                            <input type="text" class="form-control " id="addressPostcode"  />
                            <label for="addressPostcode" class="form-label">Postcode</label>
                        </div>
                    </div>
                    <!----- City ----->
                    <div class="col-md-6">
                        <div class="form-outline">
                            <input type="text" id="addressCity" class="form-control " />
                            <label class="form-label" for="addressCity">City</label>
                            
                        </div>
                    </div>
                    <!----- Address ----->
                    <div class="col-md-12">
                        <div class="form-outline">
                            <textarea class="form-control " id="address" rows="2"></textarea>
                            <label class="form-label" for="address">Address</label>
                            
                        </div>
                    </div>
                    <!----- Agree ----->
                    
                    <!----- Register-Button ----->
                    <div class="col-md-3 m-auto my-5">
                        <button type="submit" class="btn btn-secondary btn-block btn-rounded py-3">Register</button>
                    </div>
                </form>
            </div>
            <!-------- Register-Content -------->
        </div>
       <!------------- Tab-Content ------------->
    </div>
<!------------------- Outer Container ------------------->
    
    <%@include file="Fo.Footer.jsp" %>
    <script src="<%=request.getContextPath()%>/Scripts/FrontOffice/Fo.CustRegLog.js" type="text/javascript"></script>

</body>
</html>
