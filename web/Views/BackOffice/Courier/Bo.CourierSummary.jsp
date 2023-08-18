<%-- 
    Document   : Bo.CourierSummary
    Created on : 23 Feb 2022, 12:20:41 pm
    Author     : Alvin Chan Ee Aun
--%>
<%@page import="Model.Courier"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            request.setAttribute("couriers", new BusinessLogic.BackOffice.Courier.BllBo_GetFull().businessLogic(new Courier()));
        %>
        <title>Nike Office | Courier Summary</title>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
        <%@include file="Bo.CourierModal.jsp"%>
    </head>
    <body>
        <div class="cont">
            <div class="m-4">
                <h2>Courier Summary</h2>
            </div>
            <div class="cont1">
                <!--the id will be used in js file-->
                <table id="table-courier-summary" class="table table-striped border">
                    <thead>
                        <tr>
                    <a class="btn btn-primary btn-lg btn-floating btn-sm bg-primary float-end" 
                       data-mdb-toggle="tooltip" title="Add"  href="Bo.CourierNew.jsp" role="button">
                        <i class="fas fa-plus"></i>
                    </a>
                    </tr>
                    <tr>
                        <th class="text-capitalize">action</th>
                        <th class="text-capitalize">courier name</th>
                        <th class="text-capitalize">courier price(RM)</th>
                        <th class="text-capitalize">status</th>
                        <th class="text-capitalize">created date</th>
                        <th class="text-capitalize">created by</th>
                        <th class="text-capitalize">updated date</th>
                        <th class="text-capitalize">updated by</th>
                    </tr>
                    </thead>
                    <tbody>
                        <pre:forEach items="${couriers}" var="courier">
                            <tr>
                                <td>
                                    <a class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                                       data-mdb-toggle="tooltip" title="View"  href="Bo.CourierView.jsp?courierId=${courier.courierId}" role="button">
                                        <i class="fas fa-solid fa-eye" ></i>
                                    </a>
                                    <a class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                                       data-mdb-toggle="tooltip" title="Edit"  href="Bo.CourierEdit.jsp?courierId=${courier.courierId}" role="button">
                                        <i class="fas fa-pen" ></i>
                                    </a>
                                    <button type="button" class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                                            data-mdb-toggle="tooltip" title="Activate"
                                            onclick="courierActivate('${courier.courierId}')">
                                        <i class="fas fa-check"></i>
                                    </button>
                                    <button type="button" class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                                            data-mdb-toggle="tooltip" title="Deactivate"
                                            onclick="courierDeactivate('${courier.courierId}')">
                                        <i class="fas fa-times"></i>
                                    </button>
                                </td>
                                <td><pre:out value="${courier.courierName}" /></td>
                                <td><fmt:formatNumber value="${courier.courierPrice}" type="number" minFractionDigits="2"/></td>
                                <td><pre:out value="${courier.status}" /></td>
                                <td><pre:out value="${courier.createdDate}" /></td>
                                <td><pre:out value="${courier.createdBy}" /></td>
                                <td><pre:out value="${courier.updatedDate}" /></td>
                                <td><pre:out value="${courier.updatedBy}" /></td>
                            </tr>
                        </pre:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/Courier/Bo.CourierSummary.js" type="text/javascript"></script>
    </body>
</html>
