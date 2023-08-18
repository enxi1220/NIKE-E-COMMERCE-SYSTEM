<%-- 
    Document   : Bo.CustomerView
    Created on : Feb 27, 2022, 4:55:07 PM
    Author     : Tham Jun Yuan
--%>
<%@page import="Model.Customer"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
        request.setAttribute("customer", new BusinessLogic.BackOffice.Customer.BllBo_Get().businessLogic(new Customer().setCustomerId(Integer.parseInt(request.getParameter("id")))));
        %>
        <title>Nike Office | Customer View</title>
         <%@include file="../Bo.HeaderANDNav.jsp" %>
    </head>
    <body>
         <div class="cont">
            <div class="cont2">
                <div>
                    <h2>View Customer</h2>
                </div>
            <form>

                  <!------------ Customer Username ----------->
                  <div class="row mb-4">
                    <div class="col-md-6">
                        <div class="form-outline">
                            <input type="text" id="order-No" class="form-control" value="${customer[0].name}" disabled/>
                            <label class="form-label" for="order-No">Customer Name</label>
                        </div>
                    </div>

                  <!------------ Customer Name ----------->
                  <div class="col-md-6">
                        <div class="form-outline">
                            <input type="text" id="tracking-No" class="form-control" value="${customer[0].username}" disabled/>
                            <label class="form-label" for="tracking-No">Username</label>
                        </div>
                    </div>
                    </div>
                  
                   <div class="row mb-4">
                    <div class="col-md-6">
                        <div class="form-outline">  
                            <input type="text" id="receiverName" class="form-control" value="${customer[0].mail}" disabled/>
                            <label class="form-label" for="receiverName">Email</label>
                        </div>
                    </div>
                
                    <div class="col-md-6">
                        <div class="form-outline">
                            <input type="text" id="viewPrice" class="form-control" value="${customer[0].phone}" disabled/>
                            <label class="form-label" for="viewPrice">Phone</label>
                        </div>
                    </div>
                </div>

                
                <div class="row mb-4">
                    <div class="col-md-12">
                        <div class="form-outline">
                        <input type="text" id="deliveryAddress" class="form-control" value="${func:replace(customer[0].deliveryAddress,".",", ")}" disabled/>
                        <label class="form-label" for="deliveryAddress">Delivery address</label>
                        </div>
                    </div>
                </div>

                <div class="row mb-4">
                    <div class="col-md-6">
                        <div class="form-outline">
                        <input type="text" id="deliveryAddress" class="form-control" value="${customer[0].status}" disabled/>
                        <label class="form-label" for="deliveryAddress">Status</label>
                        </div>
                    </div>
                </div>
                
                <!-- Back to summary button -->
                 <div class="row mt-3 mb-5">
                    <div class="col d-flex justify-content-end">
                        <a class="btn btn-secondary" 
                           href="${pageContext.servletContext.contextPath}/Views/BackOffice/Customer/Bo.CustomerSummary.jsp">Back</a>
                    </div>
                </div>
              </div>   
            </form>
        </div>
                    
        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/Customer/Bo.CustomerView.js" type="text/javascript"></script>
    </body>
</html>
