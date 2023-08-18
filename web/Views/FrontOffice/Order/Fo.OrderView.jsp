<%-- 
    Document   : Fo.OrderView
    Created on : 19 Feb 2022, 2:05:10 pm
    Author     : Lim En Xi
--%>

<%@page import="Helper.Constant"%>
<%@page import="Model.OrderDetail"%>
<%@page import="Model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    if (session.getAttribute("customerId") == null) {
        response.setStatus(500);
        throw new Exception("Access Restricted. Please login before proceed.");
    }
    
    int orderId = Integer.parseInt(request.getParameter("orderId"));
    request.setAttribute("delivered", Helper.Constant.getStatus(Constant.StatusEnum.Delivered));
    request.setAttribute("orders", new BusinessLogic.FrontOffice.Order.BllFo_GetFullDetail().businessLogic(new Order().setOrderId(orderId)));
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@include file="../Fo.Header.jsp" %>
        <%@include file="Fo.OrderModal.jsp" %>
    </head>
    <body>
        <div class="card vh-100">
            <div class="card-header">
                <div class="d-inline fs-5">
                    <label for="" class="text-uppercase"><pre:out value="" />order no. </label>
                    <span class="ml-5 fw-bold">${orders[0].orderNo}</span>                    
                </div>
                <button 
                    type="button" 
                    class="btn btn-primary float-end" 
                    onclick="completeOrder(${orders[0].orderId})" 
                    data-mdb-toggle="tooltip" 
                    title="Order is received"
                    <pre:if test="${orders[0].status != delivered}">disabled </pre:if>
                        >
                        complete order
                    </button>
                </div>
                <div class="card-body overflow-auto ">
                    <!-- loop-->
                <pre:forEach items="${orders}" var="order">
                    <pre:forEach items="${order.orderDetail}" var="orderDetail">
                        <pre:set value="${orderDetail.productImage}" var="productImage"/>
                        <div class="card mb-3 w-auto p-3" >
                            <div class="row g-0">
                                <div class="col-md-4 text-center">
                                    <img
                                        src="data:image/png;base64,${productImage.imageAsBase64}"
                                        alt="$product name"
                                        class="img-fluid rounded-start"
                                        style="height: 360px; object-fit: cover;"/>
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body">
                                        <h5 class="card-title text-capitalize fw-bold"><pre:out value="${orderDetail.productName}"/></h5>
                                        <p class="card-text">
                                            <small>
                                                <span class="text-muted text-capitalize">color: </span><pre:out value="${orderDetail.color}"/><br/>
                                                <span class="text-muted text-capitalize">size: </span><pre:out value="${orderDetail.size}"/>
                                            </small>
                                        </p>
                                        <p class="card-text">
                                            <small class="">
                                                <label for="" class="text-capitalize text-muted">unit price: </label>
                                                RM <fmt:formatNumber value="${orderDetail.price}" type="number" minFractionDigits="2"/>
                                            </small>

                                        </p>
                                        <p class="card-text">
                                            <small class="">
                                                <label for="" class="text-capitalize text-muted">order quantity: </label>
                                                <pre:out value="${orderDetail.quantity}"/>
                                            </small>
                                        </p>
                                        <p class="card-text">
                                            <small class="">
                                                <label for="" class="text-capitalize text-muted">order price: </label>
                                                RM <fmt:formatNumber value="${orderDetail.price * orderDetail.quantity}" type="number" minFractionDigits="2"/>
                                            </small>
                                        </p>
                                    </div>
                                    <!--todo: productView?productId= -->
                                    <a class="btn btn-primary float-end" href="../Product/Fo.ProductView.jsp?productId=${orderDetail.productId}">buy again</a>
                                </div>
                            </div>
                        </div>
                    </pre:forEach>
                </pre:forEach>
            </div>
            <!-- loop-->
        </div>
        <%@include file="../Fo.Footer.jsp" %>
        <script src="../../../Scripts/FrontOffice/Order/Fo.OrderView.js" type="text/javascript"></script>
    </body>
</html>
