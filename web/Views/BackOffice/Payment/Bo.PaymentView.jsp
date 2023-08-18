<%-- 
    Document   : PaymentView
    Created on : Mar 19, 2022, 8:45:21 PM
    Author     : Alvin Chan Ee Aun
--%>
<%@page import="Model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            int paymentId = Integer.parseInt(request.getParameter("paymentId"));
            request.setAttribute("payments", new BusinessLogic.BackOffice.Payment.BllBo_Get().businessLogic(new Payment().setPaymentId(paymentId)));
        %>
        <title>Nike Office | View Payment</title>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
    </head>
    <body>
        <div class="cont">
            <div class="cont2"> 
                <div id="div_print">
                    <div>
                        <h2>Payment Details</h2>
                    </div>

                    <pre:forEach items="${payments}" var="payment">

                        <!------------ Payment No ----------->
                        <div class="row">
                            <div class="col-md-6 mb-4">
                                <div class="form-outline">
                                    <input type="text" id="payment-No" class="form-control" value="${payment.paymentNo}" disabled/>
                                    <label class="form-label" for="payment-No">Payment No</label>
                                </div>
                            </div>

                            <!------------ Order No ----------->
                            <div class="col-md-6 mb-4">
                                <div class="form-outline">
                                    <input type="text" id="orderNo" class="form-control" value="${payment.order.orderNo}" disabled/>
                                    <label class="form-label" for="orderNo">Order No</label>
                                </div>
                            </div>
                        </div>

                        <!------------ Customer name ----------->
                        <div class="row mb-4">
                            <div class="col-md-12">
                                <div class="form-outline">
                                    <input type="text" id="customerName" class="form-control" value="${payment.customerName}" disabled/>
                                    <label class="form-label" for="customerName">Customer Name</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <!------------ Payment Method ----------->
                            <div class="col-md-6 mb-4">
                                <div class="form-outline">
                                    <input type="text" id="paymentMethod" class="form-control" value="${payment.paymentMethod}" disabled/>
                                    <label class="form-label" for="paymentMethod">Payment Method</label>
                                </div>
                            </div>

                            <!------------ Bank Type ----------->
                            <div class="col-md-6 mb-4">
                                <div class="form-outline">
                                    <input type="text" id="bankType" class="form-control" value="${payment.bankType}" disabled/>
                                    <label class="form-label" for="bankType">Bank Type</label>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <!------------ Price ----------->
                            <div class="col-md-6 mb-4">
                                <div class="form-outline">
                                    <input type="text" id="paymentPrice" class="form-control" value="<fmt:formatNumber value="${payment.price}" type="number" minFractionDigits="2"/>" disabled/>
                                    <label class="form-label" for="paymentPrice">Price</label>
                                </div>
                            </div>

                            <!------------ Delivery Fee ----------->
                            <div class="col-md-6 mb-4">
                                <div class="form-outline">
                                    <input type="text" id="deliveryFee" class="form-control" value="${payment.deliveryFee}" disabled/>
                                    <label class="form-label" for="deliveryFee">Delivery Fee</label>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Back to summary button -->
                    <div class="row mt-3 mb-5">
                        <div class="col d-flex justify-content-end">
                            <!-- Cancel button -->
                            <a class="btn btn-secondary" 
                               href="${pageContext.servletContext.contextPath}/Views/BackOffice/Payment/Bo.PaymentSummary.jsp">Back</a>
                            <!-- Print button -->
                            <input type="button" class="ipt btn btn-primary ms-4" onclick="printdiv('div_print')" value="Print"/>
                        </div>
                    </div>
                </pre:forEach>
            </div>
        </div>
        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/Payment/Bo.PaymentView.js" type="text/javascript"></script>
    </body>
</html>
