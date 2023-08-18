<%-- 
    Document   : Bo.CustomerSummary
    Created on : 16 Feb 2022, 12:56:14 am
    Author     : Tham Jun Yuan
--%>
<%@page import="Model.Customer"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
        request.setAttribute("customers", new BusinessLogic.BackOffice.Customer.BllBo_GetFull().businessLogic(new Customer()));
        %>
        <title>Nike Office | Customer Summary</title>
        <%@include file="../Bo.HeaderANDNav.jsp" %>
    </head>
    <body>
        <div class="cont">
           <div class="m-4">
                    <h4>Customer Summary</h4>
                </div>
            
            <div class="cont1">
            <!--the id will be used in js file-->
            <table id="table-customer-summary" class="table table-striped border">
                <thead>
                    <tr>
                        <th class="text-capitalize">action</th>
                        <th class="text-capitalize">username</th>
                        <th class="text-capitalize">name</th>
                        <th class="text-capitalize">mail</th>
                        <th class="text-capitalize">status</th>
                        <th class="text-capitalize">created time</th>
                        <th class="text-capitalize">created by</th>
                        <th class="text-capitalize">updated time</th>
                        <th class="text-capitalize">updated by</th>
                    </tr>
                </thead>
                <tbody>
                    <pre:forEach items="${customers}" var="customer">
                    <tr>
                        <td>
                            <a class="btn btn-primary btn-lg btn-floating btn-sm" data-mdb-toggle="tooltip" title="View"
                               href="Bo.CustomerView.jsp?id=<pre:out value='${customer.customerId}' />" role="button">
                                <i class="fas fa-solid fa-eye" ></i>
                            </a>
                        </td>
                        <td><pre:out value="${customer.username}" /></td>
                        <td><pre:out value="${customer.name}" /></td>
                        <td><pre:out value="${customer.mail}" /></td>
                        <td><pre:out value="${customer.status}" /></td>
                        <td><pre:out value="${customer.createdDate}" /></td>
                        <td><pre:out value="${customer.createdBy}" /></td>
                        <td><pre:out value="${customer.updatedDate}" /></td>
                        <td><pre:out value="${customer.updatedBy}" /></td>
                    </tr>
                    </pre:forEach>
                </tbody>
            </table>
        </div>
        </div>
        
        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/Customer/Bo.CustomerSummary.js" type="text/javascript"></script>
    </body>
    
</html>
