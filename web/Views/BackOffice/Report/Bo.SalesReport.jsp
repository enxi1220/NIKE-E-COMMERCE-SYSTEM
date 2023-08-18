<%-- 
    Document   : Bo.SalesReport
    Created on : Mar 31, 2022, 5:12:10 PM
    Author     : Lin
--%>

<%@page import="Model.ProductDetail"%>
<%@page import="Model.Product"%>
<%@page import="Model.OrderDetail"%>
<%@page import="Model.Report"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="p" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="pre" %>
<!DOCTYPE html>
<html>
    <%
        request.setAttribute("reports", new BusinessLogic.BackOffice.SalesReport.BllBo_Get().businessLogic(new Report()));

    %>      
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Nike Office | Sales Report</title>

        <%@include file="../Bo.HeaderANDNav.jsp"%>
    </head>
    <body>
        <div class="cont" >
            <div id="div_print">
                <div class="m-4" >
                    <h2>Sales Report</h2>
                </div>
                <div class="cont1">  
                    <table id="table-sales-report" class="table table-striped border" >
                        <thead>
                            <tr>
                                <th class="text-capitalize">Product Category</th>
                                <th class="text-capitalize">Sales Out Quantity</th>
                            </tr>
                        </thead>
                        <tbody>
                            <pre:forEach items="${reports}" var="report">
                                <tr>
                                    <td><pre:out value="${report.product.category}"/></td>
                                    <td><pre:out value="${report.salesOutQTY}"/></td>
                                </tr>
                            </pre:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row mt-3 mb-5">
                <div class="col d-flex justify-content-end">
                    <!-- Cancel button -->
                    <a class="btn btn-secondary" 
                       href="${pageContext.servletContext.contextPath}/Views/BackOffice/Bo.Dashboard.jsp">Back</a>
                    <!-- Print button -->
                    <input name="b_print" type="button" class="ipt btn btn-primary ms-4" onClick="printdiv('div_print');" value=" Print ">
                </div>
            </div>
        </div>

        <script src="../../../Scripts/BackOffice/Report/Bo.Print.js" type="text/javascript"></script>
        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/Report/Bo.SalesReport.js" type="text/javascript"></script>

    </body>
</html>