<%--
    Document   : Fo.CustomerView
    Created on : Feb 19, 2022, 11:18:02 PM
    Author     : asus
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.Customer, Model.Order, Model.OrderDetail"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nike Simple | My Profile</title>
        <%@include file="../Fo.Header.jsp" %>
        <link href="../../../StyleSheets/FrontOffice/Customer/Fo.CustomerView.css" rel="stylesheet" type="text/css" />


        <%
            if (session.getAttribute("customerId") == null) {
                 response.setStatus(500);
                 throw new Exception("Access Restricted. Please login before proceed.");
            }

            request.setAttribute("customer", new BusinessLogic.FrontOffice.Customer.BllFo_Get().businessLogic(new Customer().setUsername((String) session.getAttribute("username"))));
            request.setAttribute("custRecentOrders", new BusinessLogic.FrontOffice.Order.BllFo_GetRecentOrder().businessLogic(new Order().setCustomerId((Integer) session.getAttribute("customerId"))));

        %>

        <style>

            @media (min-width: 1400px) {
                main,
                header,
                #main-navbar {
                    padding-left: 240px;
                }
            }
        </style>

    </head>

    <body>

        <!--<section class="h-100 gradient-custom-2 bg-light">-->
        <div class="container-fluid px-4 pt-5">
            <div class="row d-flex justify-content-center h-100">
                <div class="col-3">
                    <!-- Tab side navs -->
                    <div class="nav flex-column nav-tabs rounded me-3" id="nav-tabs" role="tablist" aria-orientation="vertical">
                        <a class="nav-link active ripple rounded-top" id="acc-overview-nav-tab" data-mdb-ripple-color="info" data-mdb-toggle="tab" role="tab" aria-controls="acc-overview" aria-selected="false"
                           href="#acc-overview"><i class="fas fa-user pe-3"></i>Profile Overview</a>

                        <a class="nav-link ripple" id="acc-edit-nav-tab" data-mdb-ripple-color="info" data-mdb-toggle="tab" role="tab" aria-controls="acc-edit" aria-selected="false"
                           href="#acc-edit"><i class="fas fa-user-edit pe-3"></i>Edit Account</a>

                        <a class="nav-link ripple" id="acc-changepass-nav-tab" data-mdb-ripple-color="info" data-mdb-toggle="tab" role="tab" aria-controls="acc-changepass" aria-selected="false"
                           href="#acc-changepass"><i class="fas fa-user-lock pe-3"></i>Change Password</a>

                        <a class="nav-link ripple" id="acc-delete-nav-tab" data-mdb-ripple-color="info" data-mdb-toggle="tab" role="tab" aria-controls="acc-delete" aria-selected="false"
                           href="#acc-delete"><i class="fas fa-user-times pe-3"></i>Delete Account</a>

                        <a class="nav-link ripple rounded-bottom" id="my-order-nav-tab" data-mdb-ripple-color="info" data-mdb-toggle="tab" role="tab" aria-controls="my-order" aria-selected="false"
                           href="#my-order"><i class="fas fa-scroll pe-3"></i>My Order</a>

                    </div>
                </div>


                <div class="col col-lg-9">
                    <div class="card shadow">

                        <div class="rounded-top d-flex justify-content-between align-items-end" style="background-color: var(--black); height:190px;">
                            <div class="ms-4 d-flex flex-column" style="width: 150px;">
                                <img id="custProImg" src="data:image/png;base64,${customer[0].imageAsBase64}" alt="Generic placeholder image" onerror="this.onerror=null;this.src='<%=request.getContextPath()%>/Views/Images/icon.png';" class="img-fluid img-thumbnail" style="position: absolute; top:3.8em; width: 150px; height: 150px; z-index: 1; object-fit:cover;">
                            </div>
                            <div style="position:absolute; left:13em; color:var(--white);">
                                <h5 id="custUsername">${customer[0].username}</h5>
                                <p><span>Created on </span>:  <fmt:formatDate type="date" value="${customer[0].createdDate}" /></p>
                                
                            </div>

                            <div class="d-flex text-center pe-3 py-1 mb-2" id="acc-activity" style="color:var(--eunry)">
                                <div class="pe-3">
                                    <p class="mb-1 h5">${customer[0].cartItemQty}<i class="fas fa-shopping-cart ps-3"></i></p>
                                    <p class="small text-muted mb-0">Items In Cart </p>
                                </div>
                                <div class="border-start ps-3 border-info">
                                    <p class="mb-1 h5">${customer[0].orderedQty}<i class="fas fa-box ps-3"></i></p>
                                    <p class="small text-muted mb-0">Orders Placed </p>
                                </div>
                            </div>
                        </div>
                        <!-- ------------------------------top ------------------------------ -->

                        <div class="card-body px-5 py-4 text-black tab-content">

                            <div class="tab-pane fade show active user-detail-container bg-info p-3 mt-3" id="acc-overview" role="tabpanel" aria-labelledby="acc-overview-nav-tab">
                                <h3 class="lead">Account Overview</h3><hr class="mt-0" />
                                <div class="col">
                                    <p><span>Name </span>: ${customer[0].name}</p>
                                    <p><span>Email </span>: ${customer[0].mail}</p>
                                    <p><span>Contact </span>: ${customer[0].phone}</p>
                                    <p><span>Address </span>: ${func:replace(customer[0].deliveryAddress, ".", ", ")}</p>
                                </div>
                            </div>

                            <!-- ------------------------------ Customer Edit ------------------------------ -->
                            <div class="tab-pane fade bg-light px-4 py-3 my-3" id="acc-edit" role="tabpanel" aria-labelledby="acc-edit-nav-tab">
                                <h3 class="lead">Edit Account</h3><hr class="mt-0 mb-3" />
                                <form class="row g-3 needs-validation mt-3" id="custEditAcc" novalidate>
                                    <!----- Name ----->
                                    <div class="col-md-12">
                                        <div class="form-outline">
                                            <input type="text" class="form-control" id="custEditName" value="${customer[0].name}" required />
                                            <label for="custEditName" class="form-label">Full Name</label>
                                        </div>
                                    </div>
                                    <!----- Register-Email ----->
                                    <div class="col-md-6">
                                        <div class="form-outline">
                                            <input type="email" class="form-control" id="custEditMail" value="${customer[0].mail}" required />
                                            <label class="form-label" for="custEditMail">Email</label>
                                        </div>
                                    </div>
                                    <!----- Profile ----->
                                    <div class="col-md-6">
                                        <div class="form">
                                            <button class="btn btn-outline-secondary rounded" type="button" id="inputGroupFileAddon03" onclick="$('#custEditProPic').click()">
                                                Profile (Optional)
                                            </button>
                                            <img id="custEditProPre" class="rounded-circle img-fluid" src="data:image/png;base64,${customer[0].imageAsBase64}" onerror="this.onerror=null;this.src='<%=request.getContextPath()%>/Views/Images/icon.png';" alt="" style="border: 0.5px solid lightgrey; width:38px; height:38px; margin-left: 38px;  object-fit: cover;">
                                            <input type="file" class="form-control" id="custEditProPic" aria-describedby="inputGroupFileAddon03" aria-label="Upload" onchange="picPreview(this)" style="display: none;" />
                                        </div>
                                    </div>
                                    <!-------- Separate Line -------->
                                    <section class="border-top border-2 mt-4 mb-1"></section>

                                    <!----- Phone ----->
                                    <div class="col-md-6">
                                        <div class="form-outline">
                                            <input type="tel" id="custEditPhone" class="form-control" value="${customer[0].phone}" required/>
                                            <label class="form-label" for="custEditPhone">Phone</label>
                                        </div>
                                    </div>
                                    <pre:set var="addressDetails" value="${func:split(customer[0].deliveryAddress, '.')}" />        
                                    <!----- State ----->
                                    <div class="col-md-6">
                                        <select class="form-control form-select" id="custEditState" aria-invalid="false" style="background-color: transparent;">
                                            <pre:if test="${not empty addressDetails[3]}">
                                                <option value="${addressDetails[3]}" selected hidden>${addressDetails[3]}</option>
                                            </pre:if>
                                            <pre:if test="${empty addressDetails[3]}">
                                                <option value="" selected hidden>State</option>
                                            </pre:if>
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
                                            <input type="text" class="form-control " id="custEditPostcode" required value="${addressDetails[1]}"/>
                                            <label for="custEditPostcode" class="form-label">Postcode</label>
                                        </div>
                                    </div>
                                    <!----- City ----->
                                    <div class="col-md-6">
                                        <div class="form-outline">
                                            <input type="text" id="custEditCity" class="form-control" value="${addressDetails[2]}"/>
                                            <label class="form-label" for="custEditCity">City</label>
                                        </div>
                                    </div>
                                    <!----- Address ----->
                                    <div class="col-md-12">
                                        <div class="form-outline">
                                            <textarea class="form-control " id="custEditAddress" rows="3">${addressDetails[0]}</textarea>
                                            <label class="form-label" for="custEditAddress">Address</label>
                                        </div>
                                    </div>
                                    <!----- Save-Edit-Button ----->
                                    <div class="d-flex justify-content-center mb-4">
                                        <button type="submit" class="btn btn-secondary btn-block w-25">Save Changes</button>
                                    </div>
                                </form>
                            </div>


                            <!-- ----------------------------- Acc Change Password ----------------------------- -->

                            <div class="tab-pane fade bg-light p-3 mt-3 " id="acc-changepass" role="tabpanel" aria-labelledby="acc-changepass-nav-tab">

                                <h3 class="lead">Change Password</h3><hr class="mt-0" />
                                <form id="custChangePass">
                                    <div class="form-outline my-3">
                                        <input type="password" id="custEditOldPass" class="form-control " data-mdb-showcounter="true" maxlength="30" />
                                        <label class="form-label" for="custEditOldPass">Enter current password to continue</label>
                                        <div class="form-helper"></div>
                                    </div>

                                    <div class="d-flex justify-content-end align-items-center mt-5">
                                        <!--                                        <button type="button" class="btn btn-secondary" data-mdb-dismiss="modal">Cancel</button>-->
                                        <button type="button" id="custChangePassBtn" class="btn btn-primary invisible" data-mdb-toggle="modal" data-mdb-target="#changePass-modal"></button>
                                        <button type="submit" class="btn btn-primary">Continue</button>
                                    </div>
                                </form>

                            </div>
                            <!-- ----------------------------- Delete Account ----------------------------- -->

                            <div class="tab-pane fade bg-light p-3 mt-3 " id="acc-delete" role="tabpanel" aria-labelledby="acc-delete-nav-tab">

                                <h3 class="lead">Delete Account</h3><hr class="mt-0" />
                                <p>Once you have confirm delete this account it will be permanently and you won't be able to login with account anymore.</p> 

                                <form id="custDeactivate">
                                    <div class="form-outline my-3">
                                        <input type="password" id="custDeAccPass" class="form-control " data-mdb-showcounter="true" maxlength="30" />
                                        <label class="form-label" for="custDeAccPass">Enter your password to confirm</label>
                                        <div class="form-helper"></div>
                                    </div>

                                    <div class="d-flex justify-content-end align-items-center mt-4">
                                        <button type="button" id="custDeactivateBtn" class="btn btn-primary invisible" data-mdb-toggle="modal" data-mdb-target="#deAcc-modal"></button>
                                        <button type="submit" class="btn btn-primary">Delete</button>
                                    </div>
                                </form>

                            </div>



                            <!-- ----------------------------- My Order ----------------------------- -->

                            <div class="tab-pane fade" id="my-order" role="tabpanel" aria-labelledby="my-order-nav-tab">
                                <div class="d-flex justify-content-between align-items-center my-3">
                                    <p class="lead fw-normal mb-0">Recent Orders</p>
                                    <p class="mb-0"><a href="${pageContext.servletContext.contextPath}/Views/FrontOffice/Order/Fo.OrderSummary.jsp" class="text-muted">Show all</a></p>
                                </div>
                                <div class="row">
                                    <div class="col">
                                        <pre:forEach items="${custRecentOrders}" var="custRecentOrder">
                                            <pre:forEach items="${custRecentOrder.orderDetail}" var="recentOrderDetail">
                                                <div class="card mb-3">
                                                    <div class="row g-0">
                                                        <div class="col-md-4">
                                                            <img src="data:image/png;base64,${recentOrderDetail.productImage.imageAsBase64}"
                                                                 alt="Trendy Pants and Shoes"
                                                                 class="img-fluid rounded-start"
                                                                 style="max-height: 250px; width: 360px; object-fit: cover;" />
                                                        </div>
                                                        <div class="col-md-8">
                                                            <div class="card-body">
                                                                <h5 class="card-title">${recentOrderDetail.productName}</h5>
                                                                <p class="card-text mt-3">Color: ${recentOrderDetail.color} </p>
                                                                <p class="card-text">Size: ${recentOrderDetail.size} </p>
                                                                <p class="card-text">Quantity: ${recentOrderDetail.quantity} </p>
                                                                <p class="card-text mt-5">
                                                                    <small class="text-muted">Purchased on <span class="ms-1"><fmt:formatDate type="date" value="${recentOrderDetail.createdDate}" /></span></small>
                                                                </p>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </pre:forEach>
                                        </pre:forEach>
                                    </div>
                                </div>
                                <!--                                <div class="row g-2">
                                                                    <div class="col">
                                                                        <img src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(108).webp" alt="image 1" class="w-100 rounded-3">
                                                                    </div>
                                                                    <div class="col">
                                                                        <img src="https://mdbcdn.b-cdn.net/img/Photos/Lightbox/Original/img%20(114).webp" alt="image 1" class="w-100 rounded-3">
                                                                    </div>
                                                                </div>-->
                            </div>

                        </div>

                    </div>
                </div>
            </div>
        </div>



        <!--</section>-->
        <%@include file="../Fo.Footer.jsp" %>
        <script src="<%=request.getContextPath()%>/Scripts/FrontOffice/Customer/Fo.CustomerView.js" type="text/javascript"></script>
    </body>
</html>
