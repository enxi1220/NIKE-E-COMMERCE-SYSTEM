<%-- 
    Document   : Bo.CourierEdit
    Created on : 23 Feb 2022, 12:24:15 pm
    Author     : Alvin Chan Ee Aun
--%>
<%@page import="Model.Courier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            int courierId = Integer.parseInt(request.getParameter("courierId"));
            request.setAttribute("couriers", new BusinessLogic.BackOffice.Courier.BllBo_Get().businessLogic(new Courier().setCourierId(courierId)));
        %>
        <title>Nike Office| Edit Courier</title>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
        <%@include file="Bo.CourierModal.jsp"%>
    </head>
    <body>
        <div class="cont">
            <div class="cont2">
                <div>
                    <h2>Edit Courier</h2>
                </div>
                <form method="post" action="${pageContext.servletContext.contextPath}/EditCourier">

                    <!------------ Courier ID ----------->
                    <input type="text" name="courierId" value="${couriers[0].courierId}" hidden/>
                    <!------------ Courier name ----------->
                    <div class="row mb-4">
                        <div class="col-md-12">
                            <div class="form-outline">
                                <input type="text" name="courierName" class="form-control" value="${couriers[0].courierName}"/>
                                <label class="form-label" for="courierName">Courier Name</label>
                            </div>
                        </div>
                    </div>

                    <!------------ Courier Price ----------->
                    <div class="row mb-4">
                        <div class="col-md-12">
                            <div class="form-outline">
                                <input type="text" name="courierPrice" class="form-control" onkeypress="return validateAlpha(event)" value="<fmt:formatNumber value="${couriers[0].courierPrice}" type="number" minFractionDigits="2"/>"/>
                                <label class="form-label" for="courierPrice">Courier Price(RM)</label>
                            </div>
                        </div>
                    </div>

                    <!------------ Status ----------->
                    <div class="row mb-4">
                        <div class="col-md-12">
                            <div class="form-outline">
                                <input type="text" name="editCourierStatus" class="form-control" value="${couriers[0].status}" readonly/>
                                <label class="form-label" for="editCourierStatus">Status</label>
                            </div>
                        </div>
                    </div>

                    <div class="row mt-3 mb-5">
                        <div class="col d-flex justify-content-end">
                            <!-- Cancel button -->
                            <a class="btn btn-secondary" 
                               href="${pageContext.servletContext.contextPath}/Views/BackOffice/Courier/Bo.CourierSummary.jsp">Back</a>
                            <!-- Submit button -->
                            <button type="submit" class="btn btn-primary ms-4">Save</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/Courier/Bo.CourierEdit.js" type="text/javascript"></script>
        
    </body>
</html>
