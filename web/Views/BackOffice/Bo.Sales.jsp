<%-- 
    Document   : Bo.Sales
    Created on : Apr 11, 2022, 4:52:28 PM
    Author     : Junyuan
--%>

<%@page import="Model.User"%>
<%@page import="Model.ProductDetail"%>
<%@page import="Model.Product"%>
<%@page import="Model.OrderDetail"%>
<%@page import="Model.Report"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            ArrayList<Report> reports = new BusinessLogic.BackOffice.Sales.BllBo_Get().businessLogic(new Report());
        %>    
        <title>Nike Office | Sales </title>

        <%@include file="Bo.HeaderANDNav.jsp"%>
        <%--<%@include file="Bo.UserComfirm.jsp"%>--%>
    </head>
    <body>
        <div class="cont">

            <div class="m-4">
                <h2>Sales Record</h2>
            </div>
            <div class="cont1">  
                <!--the id will be used in js file-->
                <table id="table-sales-summary" class="table table-striped border">
                    <thead>
                    <tr>
                        <th class="text-capitalize">Product No</th>
                        <th class="text-capitalize">Product Name</th>
                        <th class="text-capitalize">Color</th>
                        <th class="text-capitalize">Size</th>
                        <th class="text-capitalize">Sales Out Quantity</th>
                    </tr>
                    </thead>
                    <tbody>
                        <%                            for (Report r : reports) {

                                for (OrderDetail od : r.getOrderDetail()) {
                        %>
                        <tr>
                            <td><pre:out value="<%= r.getProduct().getProductNo()%>" /></td>
                            <td><pre:out value="<%= od.getProductName()%>" /></td>
                            <td><pre:out value="<%= od.getSize()%>" /></td>  
                            <td><pre:out value="<%= od.getColor()%>" /></td>
                            <td><pre:out value="<%= r.getSumQTY()%>" /></td>
                        </tr>
                        <%         }
                            }

                        %>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="Bo.Footer.jsp" %>
        <script src="../../Scripts/BackOffice/Sales/Bo.sales.js" type="text/javascript"></script>
    </body>
</html>