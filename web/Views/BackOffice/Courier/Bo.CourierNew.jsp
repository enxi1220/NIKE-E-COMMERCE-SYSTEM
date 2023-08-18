<%-- 
    Document   : Bo.CourierNew
    Created on : 23 Feb 2022, 12:23:54 pm
    Author     : Alvin Chan Ee Aun
--%>

<%@page import="Model.Courier"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nike Office | Add Courier</title>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
        <%@include file="Bo.CourierModal.jsp"%>
    </head>
    <body>
        <div class="cont">
            <div class="cont2">
                <div>
                    <h2>Add Courier</h2>
                </div>
                <form method="post" action="${pageContext.servletContext.contextPath}/NewCourier">
                    <!------------ Courier name ----------->
                    <div class="row mb-4">
                        <div class="col-md-12">
                            <div class="form-outline">
                                <input type="text" name="courierName" class="form-control"/>
                                <label class="form-label" for="courierName">Courier Name</label>
                            </div>        
                        </div>   
                    </div>

                    <!------------ Courier Price ----------->
                    <div class="row mb-4">
                        <div class="col-md-12">
                            <div class="form-outline">
                                <input type="text" name="courierPrice" class="form-control" onkeypress="return validateAlpha(event)"/>
                                <label class="form-label" for="courierPrice">Courier Price(RM)</label>
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
        <script src="../../../Scripts/BackOffice/Courier/Bo.CourierNew.js" type="text/javascript"></script>
    </body>
</html>
