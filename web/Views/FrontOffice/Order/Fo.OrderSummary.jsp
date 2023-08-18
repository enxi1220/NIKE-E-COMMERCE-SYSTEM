<%-- 
    Document   : OrderSummary
    Created on : 13 Feb 2022, 6:20:53 pm
    Author     : Lim En Xi
--%>

<%@page import="Helper.Constant"%>
<%@page import="Model.Customer"%>
<%@page import="Model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (session.getAttribute("customerId") == null) {
        response.setStatus(500);
        throw new Exception("Access Restricted. Please login before proceed.");
    }
    
    request.setAttribute("pending", Helper.Constant.getStatus(Constant.StatusEnum.Pending));
    request.setAttribute("paid", Helper.Constant.getStatus(Constant.StatusEnum.Paid));
    request.setAttribute("packaging", Helper.Constant.getStatus(Constant.StatusEnum.Packaging));
    request.setAttribute("shipping", Helper.Constant.getStatus(Constant.StatusEnum.Shipping));
    request.setAttribute("delivered", Helper.Constant.getStatus(Constant.StatusEnum.Delivered));
    request.setAttribute("completed", Helper.Constant.getStatus(Constant.StatusEnum.Completed));

    request.setAttribute("orders", new BusinessLogic.FrontOffice.Order.BllFo_GetFull()
            .businessLogic(new Order().setCustomer(new Customer()
                    .setUsername((String)session.getAttribute("username")))));
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../Fo.Header.jsp" %>
        <%@include file="Fo.OrderModal.jsp" %>
    <body>
        <h3 class="fw-normal text-capitalize mt-5 mb-3 w-75 float-end">orders</h3>
        <div class="row vw-100">
            <div class="container" >
                <div class="row">
                    <div class="col-3">
                        <!-- Tab navs -->
                        <div
                            class="nav flex-column nav-tabs text-center"
                            id="v-tabs-tab"
                            role="tablist"
                            aria-orientation="vertical"
                            >
                            <a
                                class="nav-link active"
                                id="v-tabs-pending-payment-tab"
                                data-mdb-toggle="tab"
                                href="#pending"
                                role="tab"
                                aria-controls="v-tabs-pending-payment"
                                aria-selected="false"
                                >pending payment</a
                            >
                            <a
                                class="nav-link"
                                id="v-tabs-paid-tab"
                                data-mdb-toggle="tab"
                                href="#paid"
                                role="tab"
                                aria-controls="v-tabs-paid"
                                aria-selected="false"
                                >paid</a
                            >
                            <a
                                class="nav-link"
                                id="v-tabs-packaging-tab"
                                data-mdb-toggle="tab"
                                href="#packaging"
                                role="tab"
                                aria-controls="v-tabs-packaging"
                                aria-selected="false"
                                >packaging</a
                            >
                            <a
                                class="nav-link"
                                id="v-tabs-shipping-tab"
                                data-mdb-toggle="tab"
                                href="#shipping"
                                role="tab"
                                aria-controls="v-tabs-shipping"
                                aria-selected="false"
                                >shipping</a
                            >
                            <a
                                class="nav-link"
                                id="v-tabs-delivered-tab"
                                data-mdb-toggle="tab"
                                href="#delivered"
                                role="tab"
                                aria-controls="v-tabs-delivered"
                                aria-selected="false"
                                >delivered</a
                            >
                            <a
                                class="nav-link"
                                id="v-tabs-completed-tab"
                                data-mdb-toggle="tab"
                                href="#completed"
                                role="tab"
                                aria-controls="v-tabs-completed"
                                aria-selected="false"
                                >completed</a
                            >
                        </div>
                        <!-- Tab navs -->
                    </div>

                    <div class="col-9">
                        <!-- Tab content -->
                        <div class="tab-content" id="v-tabs-tabContent">
                            <div
                                class="tab-pane fade show active"
                                id="pending"
                                role="tabpanel"
                                aria-labelledby="v-tabs-shipping-tab"
                                >
                                <!-- loop-->
                                <pre:forEach items="${orders}" var="order">
                                    <pre:choose>
                                        <pre:when test="${order.status == pending}">
                                            <!-- js loop-->
                                            <div class="card mt-2 mb-5">
                                                <div class="card-header">
                                                    <div class="d-inline">
                                                        <label for="" class="text-uppercase">order no.</label>
                                                        <span class="ml-5 fw-bold">${order.orderNo}</span>
                                                    </div>
                                                    <a class="float-end link-primary" data-mdb-toggle="tooltip" title="View Order Detail" href="Fo.OrderView.jsp?orderId=${order.orderId}">
                                                        <i class="fas fa-angle-right fa-lg " ></i>
                                                    </a>
                                                </div>
                                                <div class="card-body " id="v-tabs-all">
                                                    <p class="card-text">
                                                        <i class="fas fa-shipping-fast"></i>
                                                        <span >${order.courier.courierName}</span>
                                                    </p>
                                                    <p class="card-text float-end">
                                                        <label for="" class="text-capitalize">order date: </label>
                                                        <small class="">${order.createdDate}</small>
                                                    </p>
                                                    <p class="card-text">
                                                        <i class="far fa-copy" onclick="copyToClipboard('${order.trackingNo}')" data-mdb-toggle="tooltip" title="Copy Tracking Number"></i>
                                                        <label for="" class="text-capitalize">tracking no.: </label>
                                                        <span id="${order.trackingNo}">${order.trackingNo}</span>
                                                    </p>
                                                    <p class="card-text float-end">
                                                        <label for="" class="text-capitalize">order total price: </label>
                                                        <small class="">RM <fmt:formatNumber value="${order.price}" type="number" minFractionDigits="2"/></small>
                                                    </p>
                                                    <p class="card-text">
                                                        <small class="text-muted">${order.count} item(s)</small>
                                                    </p>
                                                    <div class="d-grid gap-2 d-md-flex justify-content-md-end mr-5">
                                                        <button class="btn btn-secondary" type="button" onclick="cancelOrder('${order.orderId}')">cancel order</button>
                                                        <a href="../Payment/Fo.PaymentNew.jsp?orderId=${order.orderId}" class="btn btn-primary" type="button">pay now</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </pre:when>
                                    </pre:choose>
                                </pre:forEach>
                                <!-- loop-->
                            </div>
                            <div
                                class="tab-pane fade"
                                id="packaging"
                                role="tabpanel"
                                aria-labelledby="v-tabs-packaging-tab"
                                >
                                <!-- js loop-->
                                <pre:forEach items="${orders}" var="order">
                                    <pre:choose>
                                        <pre:when test="${order.status == packaging}">
                                            <!-- js loop-->
                                            <div class="card mt-2 mb-5">
                                                <div class="card-header">
                                                    <div class="d-inline">
                                                        <label for="" class="text-uppercase">order no.</label>
                                                        <span class="ml-5 fw-bold">${order.orderNo}</span>
                                                    </div>
                                                    <a class="float-end link-primary" data-mdb-toggle="tooltip" title="View Order Detail" href="Fo.OrderView.jsp?orderId=${order.orderId}">
                                                        <i class="fas fa-angle-right fa-lg " ></i>
                                                    </a>
                                                </div>
                                                <div class="card-body " id="v-tabs-all">
                                                    <p class="card-text">
                                                        <i class="fas fa-shipping-fast"></i>
                                                        <span >${order.courier.courierName}</span>
                                                    </p>
                                                    <p class="card-text float-end">
                                                        <label for="" class="text-capitalize">order date: </label>
                                                        <small class="">${order.createdDate}</small>
                                                    </p>
                                                    <p class="card-text">
                                                        <i class="far fa-copy" onclick="copyToClipboard('${order.trackingNo}')" data-mdb-toggle="tooltip" title="Copy Tracking Number"></i>
                                                        <label for="" class="text-capitalize">tracking no.: </label>
                                                        <span id="${order.trackingNo}">${order.trackingNo}</span>
                                                    </p>
                                                    <p class="card-text float-end">
                                                        <label for="" class="text-capitalize">order total price: </label>
                                                        <small class="">RM <fmt:formatNumber value="${order.price}" type="number" minFractionDigits="2"/></small>
                                                    </p>
                                                    <p class="card-text">
                                                        <small class="text-muted">${order.count} item(s)</small>
                                                    </p>
                                                    <div class="d-grid gap-2 d-md-flex justify-content-md-end mr-5">
                                                        <a href="../Payment/Fo.PaymentView.jsp?orderId=${order.orderId}" class="btn btn-primary" type="button">view payment</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </pre:when>
                                    </pre:choose>
                                </pre:forEach>
                                <!-- js loop-->
                            </div>
                            <div
                                class="tab-pane fade"
                                id="paid"
                                role="tabpanel"
                                aria-labelledby="v-tabs-paid-tab"
                                >
                                <!-- js loop-->
                                <pre:forEach items="${orders}" var="order">
                                    <pre:choose>
                                        <pre:when test="${order.status == paid}">
                                            <!-- js loop-->
                                            <div class="card mt-2 mb-5">
                                                <div class="card-header">
                                                    <div class="d-inline">
                                                        <label for="" class="text-uppercase">order no.</label>
                                                        <span class="ml-5 fw-bold">${order.orderNo}</span>
                                                    </div>
                                                    <a class="float-end link-primary" data-mdb-toggle="tooltip" title="View Order Detail" href="Fo.OrderView.jsp?orderId=${order.orderId}">
                                                        <i class="fas fa-angle-right fa-lg " ></i>
                                                    </a>
                                                </div>
                                                <div class="card-body " id="v-tabs-all">
                                                    <p class="card-text">
                                                        <i class="fas fa-shipping-fast"></i>
                                                        <span >${order.courier.courierName}</span>
                                                    </p>
                                                    <p class="card-text float-end">
                                                        <label for="" class="text-capitalize">order date: </label>
                                                        <small class="">${order.createdDate}</small>
                                                    </p>
                                                    <p class="card-text">
                                                        <i class="far fa-copy" onclick="copyToClipboard('${order.trackingNo}')" data-mdb-toggle="tooltip" title="Copy Tracking Number"></i>
                                                        <label for="" class="text-capitalize">tracking no.: </label>
                                                        <span id="${order.trackingNo}">${order.trackingNo}</span>
                                                    </p>
                                                    <p class="card-text float-end">
                                                        <label for="" class="text-capitalize">order total price: </label>
                                                        <small class="">RM <fmt:formatNumber value="${order.price}" type="number" minFractionDigits="2"/></small>
                                                    </p>
                                                    <p class="card-text">
                                                        <small class="text-muted">${order.count} item(s)</small>
                                                    </p>
                                                    <div class="d-grid gap-2 d-md-flex justify-content-md-end mr-5">
                                                        <a href="../Payment/Fo.PaymentView.jsp?orderId=${order.orderId}" class="btn btn-primary" type="button">view payment</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </pre:when>
                                    </pre:choose>
                                </pre:forEach>
                                <!-- js loop-->
                            </div>
                            <div
                                class="tab-pane fade"
                                id="shipping"
                                role="tabpanel"
                                aria-labelledby="v-tabs-shipping-tab"
                                >
                                <!-- js loop-->
                                <pre:forEach items="${orders}" var="order">
                                    <pre:choose>
                                        <pre:when test="${order.status == shipping}">
                                            <!-- js loop-->
                                            <div class="card mt-2 mb-5">
                                                <div class="card-header">
                                                    <div class="d-inline">
                                                        <label for="" class="text-uppercase">order no.</label>
                                                        <span class="ml-5 fw-bold">${order.orderNo}</span>
                                                    </div>
                                                    <a class="float-end link-primary" data-mdb-toggle="tooltip" title="View Order Detail" href="Fo.OrderView.jsp?orderId=${order.orderId}">
                                                        <i class="fas fa-angle-right fa-lg " ></i>
                                                    </a>
                                                </div>
                                                <div class="card-body " id="v-tabs-all">
                                                    <p class="card-text">
                                                        <i class="fas fa-shipping-fast"></i>
                                                        <span >${order.courier.courierName}</span>
                                                    </p>
                                                    <p class="card-text float-end">
                                                        <label for="" class="text-capitalize">order date: </label>
                                                        <small class="">${order.createdDate}</small>
                                                    </p>
                                                    <p class="card-text">
                                                        <i class="far fa-copy" onclick="copyToClipboard('${order.trackingNo}')" data-mdb-toggle="tooltip" title="Copy Tracking Number"></i>
                                                        <label for="" class="text-capitalize">tracking no.: </label>
                                                        <span id="${order.trackingNo}">${order.trackingNo}</span>
                                                    </p>
                                                    <p class="card-text float-end">
                                                        <label for="" class="text-capitalize">order total price: </label>
                                                        <small class="">RM <fmt:formatNumber value="${order.price}" type="number" minFractionDigits="2"/></small>
                                                    </p>
                                                    <p class="card-text">
                                                        <small class="text-muted">${order.count} item(s)</small>
                                                    </p>
                                                    <div class="d-grid gap-2 d-md-flex justify-content-md-end mr-5">
                                                        <a href="../Payment/Fo.PaymentView.jsp?orderId=${order.orderId}" class="btn btn-primary" type="button">view payment</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </pre:when>
                                    </pre:choose>
                                </pre:forEach>
                                <!-- js loop-->
                            </div>
                            <div
                                class="tab-pane fade"
                                id="delivered"
                                role="tabpanel"
                                aria-labelledby="v-tabs-delivered-tab"
                                >
                                <!-- js loop-->
                                <pre:forEach items="${orders}" var="order">
                                    <pre:choose>
                                        <pre:when test="${order.status == delivered}">
                                            <!-- js loop-->
                                            <div class="card mt-2 mb-5">
                                                <div class="card-header">
                                                    <div class="d-inline">
                                                        <label for="" class="text-uppercase">order no.</label>
                                                        <span class="ml-5 fw-bold">${order.orderNo}</span>
                                                    </div>
                                                    <a class="float-end link-primary" data-mdb-toggle="tooltip" title="View Order Detail" href="Fo.OrderView.jsp?orderId=${order.orderId}">
                                                        <i class="fas fa-angle-right fa-lg " ></i>
                                                    </a>
                                                </div>
                                                <div class="card-body " id="v-tabs-all">
                                                    <p class="card-text">
                                                        <i class="fas fa-shipping-fast"></i>
                                                        <span >${order.courier.courierName}</span>
                                                    </p>
                                                    <p class="card-text float-end">
                                                        <label for="" class="text-capitalize">order date: </label>
                                                        <small class="">${order.createdDate}</small>
                                                    </p>
                                                    <p class="card-text">
                                                        <i class="far fa-copy" onclick="copyToClipboard('${order.trackingNo}')" data-mdb-toggle="tooltip" title="Copy Tracking Number"></i>
                                                        <label for="" class="text-capitalize">tracking no.: </label>
                                                        <span id="${order.trackingNo}">${order.trackingNo}</span>
                                                    </p>
                                                    <p class="card-text float-end">
                                                        <label for="" class="text-capitalize">order total price: </label>
                                                        <small class="">RM <fmt:formatNumber value="${order.price}" type="number" minFractionDigits="2"/></small>
                                                    </p>
                                                    <p class="card-text">
                                                        <small class="text-muted">${order.count} item(s)</small>
                                                    </p>
                                                    <div class="d-grid gap-2 d-md-flex justify-content-md-end mr-5">
                                                        <a href="../Payment/Fo.PaymentView.jsp?orderId=${order.orderId}" class="btn btn-primary" type="button">view payment</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </pre:when>
                                    </pre:choose>
                                </pre:forEach>
                                <!-- js loop-->
                            </div>
                            <div
                                class="tab-pane fade"
                                id="completed"
                                role="tabpanel"
                                aria-labelledby="v-tabs-completed-tab"
                                >
                                <!-- js loop-->
                                <pre:forEach items="${orders}" var="order">
                                    <pre:choose>
                                        <pre:when test="${order.status == completed}">
                                            <!-- js loop-->
                                            <div class="card mt-2 mb-5">
                                                <div class="card-header">
                                                    <div class="d-inline">
                                                        <label for="" class="text-uppercase">order no.</label>
                                                        <span class="ml-5 fw-bold">${order.orderNo}</span>
                                                    </div>
                                                    <a class="float-end link-primary" data-mdb-toggle="tooltip" title="View Order Detail" href="Fo.OrderView.jsp?orderId=${order.orderId}">
                                                        <i class="fas fa-angle-right fa-lg " ></i>
                                                    </a>
                                                </div>
                                                <div class="card-body " id="v-tabs-all">
                                                    <p class="card-text">
                                                        <i class="fas fa-shipping-fast"></i>
                                                        <span >${order.courier.courierName}</span>
                                                    </p>
                                                    <p class="card-text float-end">
                                                        <label for="" class="text-capitalize">order date: </label>
                                                        <small class="">${order.createdDate}</small>
                                                    </p>
                                                    <p class="card-text">
                                                        <i class="far fa-copy" onclick="copyToClipboard('${order.trackingNo}')" data-mdb-toggle="tooltip" title="Copy Tracking Number"></i>
                                                        <label for="" class="text-capitalize">tracking no.: </label>
                                                        <span id="${order.trackingNo}">${order.trackingNo}</span>
                                                    </p>
                                                    <p class="card-text float-end">
                                                        <label for="" class="text-capitalize">order total price: </label>
                                                        <small class="">RM <fmt:formatNumber value="${order.price}" type="number" minFractionDigits="2"/></small>
                                                    </p>
                                                    <p class="card-text">
                                                        <small class="text-muted">${order.count} item(s)</small>
                                                    </p>
                                                    <div class="d-grid gap-2 d-md-flex justify-content-md-end mr-5">
                                                        <a href="../Payment/Fo.PaymentView.jsp?orderId=${order.orderId}" class="btn btn-primary" type="button">view payment</a>
                                                    </div>
                                                </div>
                                            </div>
                                        </pre:when>
                                    </pre:choose>
                                </pre:forEach>
                                <!-- js loop-->
                            </div>
                            <!-- Tab content -->
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="../Fo.Footer.jsp" %>
            <script src="../../../Scripts/FrontOffice/Order/Fo.OrderSummary.js" type="text/javascript"></script>
    </body>
</html>
