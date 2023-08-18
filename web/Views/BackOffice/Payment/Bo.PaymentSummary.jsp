<%-- 
    Document   : Bo.PaymentSummary
    Created on : Mar 19, 2022, 8:44:58 PM
    Author     : Alvin Chan Ee Aun
--%>

<%@page import="Model.Payment"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            request.setAttribute("payments", new BusinessLogic.BackOffice.Payment.BllBo_GetFull().businessLogic(new Payment()));
        %>
        <title>Nike Office | Payment Summary</title>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
    </head>
    <body>
        <div class="cont">

            <div class="m-4">
                <h2>Payment Summary</h2>
            </div>

            <div class="cont1">
                <!--the id will be used in js file-->
                <table id="table-payment-summary" class="table table-striped border">
                    <thead>
                        <tr>
                            <th class="text-capitalize">action</th>
                            <th class="text-capitalize">payment no</th>
                            <th class="text-capitalize">order no</th>
                            <th class="text-capitalize">price(RM)</th>
                            <th class="text-capitalize">created date</th>
                            <th class="text-capitalize">created by</th>
                            <th class="text-capitalize">updated date</th>
                            <th class="text-capitalize">updated by</th>
                        </tr>
                    </thead>
                    <tbody>
                        <pre:forEach items="${payments}" var="payment">
                            <tr>
                                <td>
                                    <a class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                                       data-mdb-toggle="tooltip" title="View"  href="Bo.PaymentView.jsp?paymentId=${payment.paymentId}" role="button">
                                        <i class="fas fa-solid fa-eye" ></i>
                                    </a>
                                </td>
                                <td><pre:out value="${payment.paymentNo}" /></td>
                                <td><pre:out value="${payment.order.orderNo}" /></td>
                                <td><fmt:formatNumber value="${payment.price}" type="number" minFractionDigits="2"/></td>
                                <td><pre:out value="${payment.createdDate}" /></td>
                                <td><pre:out value="${payment.createdBy}" /></td>
                                <td><pre:out value="${payment.updatedDate}" /></td>
                                <td><pre:out value="${payment.updatedBy}" /></td>
                            </tr>
                        </pre:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/Payment/Bo.PaymentSummary.js" type="text/javascript"></script>
    </body>
</html>
