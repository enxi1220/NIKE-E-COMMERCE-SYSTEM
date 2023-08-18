<%-- 
    Document   : OrderNew
    Created on : 13 Feb 2022, 6:21:52 pm
    Author     : Lim En Xi
--%>

<%@page import="Model.Courier"%>
<%@page import="Model.Cart"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    if (session.getAttribute("customerId") == null) {
        response.setStatus(500);
        throw new Exception("Access Restricted. Please login before proceed.");
    }
    
    request.setAttribute("carts", new BusinessLogic.FrontOffice.Cart.BllFo_GetFull().businessLogic(
            new Cart().setCustomer(new Customer().setUsername((String)session.getAttribute("username")))));
    request.setAttribute("customers", new BusinessLogic.FrontOffice.Customer.BllFo_Get().businessLogic(
            new Customer().setUsername((String)session.getAttribute("username"))));
    request.setAttribute("couriers", new BusinessLogic.FrontOffice.Courier.BllFo_GetFull().businessLogic(
            new Courier()));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../Fo.Header.jsp" %>
        <%@include file="Fo.OrderModal.jsp" %>
    </head>
    <body>
        <pre:set var="addressParts" value="${func:split(customers[0].deliveryAddress, '.')}" />
        <pre:set var="subTotal" value="${0}"/>
        <pre:forEach items="${carts}" var="cart">
            <pre:forEach items="${cart.cartDetail}" var="cartDetail">
                <pre:set value="${cartDetail.product}" var="product"/>
                <pre:set value="${product.productImage[0]}" var="productImage"/>
                <pre:forEach items="${cartDetail.product.productDetail}" var="productDetail">
                    <pre:set var="subTotal" value="${subTotal + (product.price * cartDetail.quantity)}"/>
                </pre:forEach>
            </pre:forEach>
        </pre:forEach>
        
        <h3 class="fw-normal text-capitalize mt-5 mb-3 w-75 float-end">check out 
        <span class="ml-5" id="sub-total">RM <fmt:formatNumber value="${subTotal}" type="number" minFractionDigits="2"/></span>
        </h3>
        <div class="row vw-100">
            <div class="col-3">
                <!-- Tab navs -->
                <div
                    class="nav flex-column nav-tabs "
                    id="v-tabs-tab"
                    role="tablist"
                    aria-orientation="vertical"
                    >
                    <a
                        class="nav-link active"
                        id="v-tabs-order-preview-tab "
                        data-mdb-toggle="tab"
                        href="#v-tabs-order-preview"
                        role="tab"
                        aria-controls="v-tabs-order-preview"
                        aria-selected="true"
                        >step 1: order preview</a
                    >
                    <a
                        class="nav-link"
                        id="v-tabs-tranport-information-tab "
                        data-mdb-toggle="tab"
                        href="#v-tabs-tranport-information"
                        role="tab"
                        aria-controls="v-tabs-tranport-information"
                        aria-selected="false"
                        >step 2: transport information</a
                    >
                </div>
                <!-- Tab navs -->
            </div>

            <div class="col-9">
                <!-- Tab content -->
                <div class="tab-content" id="v-tabs-tabContent">
                    <div
                        class="tab-pane fade show active"
                        id="v-tabs-order-preview"
                        role="tabpanel"
                        aria-labelledby="v-tabs-order-preview-tab"
                        >
                        <!--card--> 
                        <div class="card vh-100">
                            <div class="card-body p-0 overflow-auto ">
                                <!-- js loop-->
                                <pre:forEach items="${carts}" var="cart">
                                    <pre:forEach items="${cart.cartDetail}" var="cartDetail">
                                        <pre:set value="${cartDetail.product}" var="product"/>
                                        <pre:set value="${cartDetail.product.productImage[0]}" var="productImage"/>
                                        <pre:forEach items="${cartDetail.product.productDetail}" var="productDetail">
                                            <div class="card rounded-0 mt-3 w-auto p-3" >
                                                <div class="row g-0">
                                                    <div class="col-md-4 ">
                                                        <img
                                                            src="data:image/png;base64,${productImage.imageAsBase64}"
                                                            alt="${product.productName}"
                                                            class="img-fluid rounded-3"
                                                            />
                                                    </div>
                                                    <div class="col-md-8">
                                                        <div class="card-body">
                                                            <h5 class="card-title text-capitalize ">${product.productName}</h5>
                                                            <p class="card-text">
                                                                <small>
                                                                    <span class="text-muted text-capitalize">color: </span>
                                                                    ${productDetail.color}
                                                                    <span class="text-muted text-capitalize">size: </span>
                                                                    ${productDetail.size}
                                                                </small>
                                                            </p>
                                                            <p class="card-text">
                                                                <small>
                                                                    <span for="" class="text-muted text-capitalize">unit price: </span>
                                                                    <span>RM <fmt:formatNumber value="${product.price}" type="number" minFractionDigits="2"/></span>
                                                                </small>
                                                            </p>
                                                            <p class="card-text">
                                                                <small>
                                                                    <span for="" class="text-muted text-capitalize">order quantity: </span>
                                                                    <span class="">${cartDetail.quantity}</span>
                                                                </small>
                                                            </p>
                                                            <p class="card-text">
                                                                <small>
                                                                    <span for="" class="text-muted text-capitalize">order price: </span>
                                                                    <span class="">RM <fmt:formatNumber value="${product.price * cartDetail.quantity}" type="number" minFractionDigits="2"/></span>
                                                                </small>
                                                            </p>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </pre:forEach>
                                    </pre:forEach>
                                </pre:forEach>
                                <!-- js loop-->
                            </div>
                        </div>
                    </div>
                    <div
                        class="tab-pane fade"
                        id="v-tabs-tranport-information"
                        role="tabpanel"
                        aria-labelledby="v-tabs-tranport-information-tab"
                        >
                        <!--form-->
                        <form id="new-order" method="POST" >
                            <input type="text" id="txt-cart-id" name="txt-cart-id" class="form-control" value="${carts[0].cartId}" hidden/>
                            <div class="row mb-4">
                                <div class="col-md-6">
                                    <div class="form-outline">
                                        <input type="text" id="txt-recipient" name="txt-recipient" class="form-control" value="${customers[0].name}"/>
                                        <label class="form-label text-capitalize" for="txt-recipient">recipient *</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <select class="form-control form-select" id="txt-courier" name="txt-courier" onchange="dynamicPrice(this, ${subTotal})" aria-label=".form-select example">
                                        <option selected hidden>Courier *</option>
                                        <pre:forEach items="${couriers}" var="courier">
                                            <option value="${courier.courierId}" id="${courier.courierPrice}">${courier.courierName}</option>
                                        </pre:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="row mb-4">
                                <div class="col-md-6">
                                    <div class="form-outline">
                                        <input type="text" id="txt-delivery-fee" name="txt-delivery-fee" class="form-control" value="" readonly/>
                                        <label class="form-label text-capitalize" for="txt-delivery-fee">delivery fee</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-outline">
                                        <input type="text" id="txt-order-total-price" name="txt-order-total-price" class="form-control" value="" readonly/>
                                        <label class="form-label text-capitalize" for="txt-order-total-price">order total price</label>
                                    </div>
                                </div>
                            </div>
                            <hr/>
                            <div class="row mb-4">
                                <div class="col-md-12">
                                    <div class="form-outline">
                                        <textarea class="form-control " id="txt-address" name="txt-address" rows="2">${addressParts[0]}</textarea>
                                        <label class="form-label" for="txt-address">Address *</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-4">
                                <div class="col-md-6">
                                    <div class="form-outline">
                                        <input type="text" id="txt-address-postcode" name="txt-postcode" class="form-control" value="${addressParts[1]}"/>
                                        <label class="form-label text-capitalize" for="txt-postcode">postcode *</label>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-outline">
                                        <input type="text" id="txt-address-city" name="txt-city" class="form-control" value="${addressParts[2]}"/>
                                        <label class="form-label text-capitalize" for="txt-postcode">city *</label>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-6">
                                <select class="form-control form-select" id="txt-address-state" name="txt-address-state" aria-label=".form-select example">
                                    <option selected hidden>State *</option>
                                    <option value="Johor" <pre:if test="${addressParts[3].equals('Johor')}"> selected='selected'</pre:if>>Johor</option>
                                    <option value="Kedah" <pre:if test="${addressParts[3].equals('Kedah')}"> selected='selected'</pre:if>>Kedah</option>
                                    <option value="Kelantan" <pre:if test="${addressParts[3].equals('Kelantan')}"> selected='selected'</pre:if>>Kelantan</option>
                                    <option value="Kuala Lumpur" <pre:if test="${addressParts[3].equals('Kuala Lumpur')}"> selected='selected'</pre:if>>Kuala Lumpur</option>
                                    <option value="Labuan" <pre:if test="${addressParts[3].equals('Labuan')}"> selected='selected'</pre:if>>Labuan</option>
                                    <option value="Melaka" <pre:if test="${addressParts[3].equals('Melaka')}"> selected='selected'</pre:if>>Melaka</option>
                                    <option value="Negeri Sembilan" <pre:if test="${addressParts[3].equals('Negeri Sembilan')}"> selected='selected'</pre:if>>Negeri Sembilan</option>
                                    <option value="Pahang" <pre:if test="${addressParts[3].equals('Pahang')}"> selected='selected'</pre:if>>Pahang</option>
                                    <option value="Pulau Pinang" <pre:if test="${addressParts[3].equals('Pulau Pinang')}"> selected='selected'</pre:if>>Pulau Pinang</option>
                                    <option value="Perak" <pre:if test="${addressParts[3].equals('Perak')}"> selected='selected'</pre:if>>Perak</option>
                                    <option value="Perlis" <pre:if test="${addressParts[3].equals('Perlis')}"> selected='selected'</pre:if>>Perlis</option>
                                    <option value="Putrajaya" <pre:if test="${addressParts[3].equals('Putrajaya')}"> selected='selected'</pre:if>>Putrajaya</option>
                                    <option value="Sabah" <pre:if test="${addressParts[3].equals('Sabah')}"> selected='selected'</pre:if>>Sabah</option>
                                    <option value="Sarawak" <pre:if test="${addressParts[3].equals('Sarawak')}"> selected='selected'</pre:if>>Sarawak</option>
                                    <option value="Selangor" <pre:if test="${addressParts[3].equals('Selangor')}"> selected='selected'</pre:if>>Selangor</option>
                                    <option value="Terengganu" <pre:if test="${addressParts[3].equals('Terengganu')}"> selected='selected'</pre:if>>Terengganu</option>
                                    </select>
                                </div>
                                <div class="col-12">       
                                    <button type="submit" id="proceed-payment-confirmation" class="btn btn-primary float-end" >place order</button>
                                </div>
                            </form>
                        </div>
                    </div>
                    <!-- Tab content -->
                </div>
            </div>
        <%@include file="../Fo.Footer.jsp" %>
        <script src="../../../Scripts/FrontOffice/Order/Fo.OrderNew.js" type="text/javascript"></script>
    </body>
</html>
