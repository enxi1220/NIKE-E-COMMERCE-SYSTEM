<%-- 
    Document   : Bo.CourierView
    Created on : 23 Feb 2022, 12:24:27 pm
    Author     : Alvin Chan Ee Aun
--%>

<%@page import="Model.Courier"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            int courierId = Integer.parseInt(request.getParameter("courierId"));
            request.setAttribute("couriers", new BusinessLogic.BackOffice.Courier.BllBo_Get().businessLogic(new Courier().setCourierId(courierId)));
        %>
        <title>Nike Office | View Courier</title>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
    </head>
    <body>
        <div class="cont">
            <div class="cont2">
                <div>
                    <h2>View Courier</h2>
                </div>
                <form>
                    <pre:forEach items="${couriers}" var="courier">
                        <!------------ Courier name ----------->
                        <div class="row mb-4">
                            <div class="col-md-12">
                                <div class="form-outline">
                                    <input type="text" id="courierName" class="form-control" value="${courier.courierName}" readonly/>
                                    <label class="form-label" for="courierName">Courier Name</label>
                                </div>
                            </div>
                        </div>

                        <!------------ Courier Price ----------->
                        <div class="row mb-4">
                            <div class="col-md-12">
                                <div class="form-outline">
                                    <input type="text" id="courierPrice" class="form-control" value="<fmt:formatNumber value="${courier.courierPrice}" type="number" minFractionDigits="2"/>" disabled/>
                                    <label class="form-label" for="courierPrice">Courier Price(RM)</label>
                                </div>
                            </div>
                        </div>

                        <!------------ Status ----------->
                        <div class="row mb-4">
                            <div class="col-md-12">
                                <div class="form-outline">
                                    <input type="text" id="viewOrderStatus" class="form-control" value="${courier.status}" disabled/>
                                    <label class="form-label" for="viewOrderStatus">Status</label>
                                </div>
                            </div>
                        </div>

                        <!-- Back to courier summary button -->
                        <div class="row mt-3 mb-5">
                            <div class="col d-flex justify-content-end">
                                <a class="btn btn-secondary" 
                                   href="${pageContext.servletContext.contextPath}/Views/BackOffice/Courier/Bo.CourierSummary.jsp">Back</a>
                            </div>
                        </div>
                    </pre:forEach>
                </form>
            </div>
        </div>
        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/Courier/Bo.CourierView.js" type="text/javascript"></script>
    </body>
</html>
