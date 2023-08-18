<%-- 
    Document   : Bo.OrderSummary
    Created on : 22 Feb 2022, 8:29:18 pm
    Author     : Alvin Chan Ee Aun
--%>

<%@page import="Model.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            request.setAttribute("orders", new BusinessLogic.BackOffice.Order.BllBo_GetFull().businessLogic(new Order()));
        %>
        <title>Nike Office | Orders Summary</title>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
    </head>
    <body>
        <div class="cont">
            <div class="m-4">
                <h2>Orders Summary</h2>
            </div>
            <div class="cont1">
                <!--the id will be used in js file-->
                <table id="table-order-summary" class="table table-striped border">
                    <thead>
                        <tr>
                            <th class="text-capitalize">action</th>
                            <th class="text-capitalize">order no</th>
                            <th class="text-capitalize">price(RM)</th>
                            <th class="text-capitalize">status</th>
                            <th class="text-capitalize">created date</th>
                            <th class="text-capitalize">created by</th>
                            <th class="text-capitalize">updated date</th>
                            <th class="text-capitalize">updated by</th>
                        </tr>
                    </thead>
                    <tbody>
                        <pre:forEach items="${orders}" var="order">
                            <tr>
                                <td>
                                    <a class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                                       data-mdb-toggle="tooltip" title="View"  href="Bo.OrderView.jsp?orderId=${order.orderId}" role="button">
                                        <i class="fas fa-solid fa-eye" ></i>
                                    </a>
                                    <a class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                                       data-mdb-toggle="tooltip" title="Edit"  href="Bo.OrderEdit.jsp?orderId=${order.orderId}" role="button">
                                        <i class="fas fa-pen" ></i>
                                    </a>
                                </td>
                                <td><pre:out value="${order.orderNo}" /></td>
                                <td><fmt:formatNumber value="${order.price}" type="number" minFractionDigits="2"/></td>
                                <td><pre:out value="${order.status}" /></td>
                                <td><pre:out value="${order.createdDate}" /></td>
                                <td><pre:out value="${order.createdBy}" /></td>
                                <td><pre:out value="${order.updatedDate}" /></td>
                                <td><pre:out value="${order.updatedBy}" /></td>
                            </tr>
                        </pre:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/Order/Bo.OrderSummary.js" type="text/javascript"></script>

    </body>
</html>