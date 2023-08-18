<%-- 
    Document   : OrderView
    Created on : 21 Feb 2022, 6:22:57 pm
    Author     : Alvin Chan Ee Aun
--%>
<%@page import="Model.OrderDetail"%>
<%@page import="Model.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            request.setAttribute("orders", new BusinessLogic.BackOffice.Order.BllBo_Get().businessLogic(new Order().setOrderId(orderId)));
            ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
        %>
        <title>Nike Office | View Order</title>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
    </head>
    <body>

        <div class="cont">
            <div class="cont2">
                <div>
                    <h2>View Order</h2>
                </div>
                <form>

                    <!------------ Order No ----------->
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <div class="form-outline">
                                <input type="text" id="order-No" class="form-control" value="${orders[0].orderNo}" disabled/>
                                <label class="form-label" for="order-No">Order No</label>
                            </div>
                        </div>

                        <!------------ Tracking No ----------->
                        <div class="col-md-6">
                            <div class="form-outline">
                                <input type="text" id="tracking-No" class="form-control" value="${orders[0].trackingNo}" disabled/>
                                <label class="form-label" for="tracking-No">Tracking No</label>
                            </div>
                        </div>
                    </div>

                    <!------------ Receiver name ----------->
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <div class="form-outline">  
                                <input type="text" id="receiverName" class="form-control" value="${orders[0].receiverName}" disabled/>
                                <label class="form-label" for="receiverName">Receiver name</label>
                            </div>
                        </div>

                        <!---------- Total Price ---------->
                        <div class="col-md-6">
                            <div class="form-outline">
                                <input type="text" id="viewPrice" class="form-control" value="<fmt:formatNumber value="${orders[0].price}" type="number" minFractionDigits="2"/>" disabled/>
                                <label class="form-label" for="viewPrice">Total Price(RM)</label>
                            </div>
                        </div>
                    </div>

                    <!------------ Address ----------->
                    <div class="row mb-4">
                        <div class="col-md-12">
                            <div class="form-outline">
                                <input type="text" id="deliveryAddress" class="form-control" value="${func:replace(orders[0].deliveryAddress,".",", ")}" disabled/>
                                <label class="form-label" for="deliveryAddress">Delivery Address</label>
                            </div>
                        </div>
                    </div>

                    <!------------ Email ----------->
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <div class="form-outline">
                                <input type="email" id="userEmail" class="form-control" value="${orders[0].customer.mail}" disabled/>
                                <label class="form-label" for="userEmail">Email</label>
                            </div>
                        </div>

                        <!------------ Phone ----------->
                        <div class="col-md-6">
                            <div class="form-outline">
                                <input type="text" id="receiverPhone" class="form-control" value="${orders[0].customer.phone}" disabled/>
                                <label class="form-label" for="receiverPhone">Phone</label>
                            </div>
                        </div>
                    </div>

                    <!------------ Courier ----------->
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <div class="form-outline">
                                <input type="text" id="courier" class="form-control" value="${orders[0].courier.courierName}" disabled/>
                                <label class="form-label" for="courier">Courier</label>
                            </div>
                        </div>

                        <!------------ Delivery Fee ----------->
                        <div class="col-md-6">
                            <div class="form-outline">
                                <input type="number" id="receiverPhone" class="form-control" value="<fmt:formatNumber value="${orders[0].deliveryFee}" type="number" minFractionDigits="2"/>" disabled/>
                                <label class="form-label" for="receiverPhone">Delivery Fee(RM)</label>
                            </div>
                        </div>
                    </div>

                    <!------------ Status ----------->
                    <div class="row mb-4">
                        <div class="col-md-12">
                            <div class="form-outline">
                                <input type="text" id="viewOrderStatus" class="form-control" value="${orders[0].status}" disabled/>
                                <label class="form-label" for="viewOrderStatus">Status</label>
                            </div>
                        </div>
                    </div>
                </form>  

                <hr>

                <table id="table-orderView-summary" class="table table-striped border">
                    <thead>
                        <tr>
                            <th class="text-capitalize">product name</th>
                            <th class="text-capitalize">color</th>
                            <th class="text-capitalize">size</th>
                            <th class="text-capitalize">quantity</th>
                            <th class="text-capitalize">price(RM)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Order o : orders) {
                                for (OrderDetail od : o.getOrderDetail()) {
                        %>
                        <tr>
                            <td><%= od.getProductName()%></td>
                            <td><%= od.getColor()%></td>
                            <td><%= od.getSize()%></td>
                            <td><%= od.getQuantity()%></td>
                            <td><fmt:formatNumber value="<%= (od.getPrice() * od.getQuantity())%>" type="number" minFractionDigits="2"/></td>
                        </tr>
                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>

                <!-- Back to summary button -->
                <br />

                <div class="row mt-3 mb-5">
                    <div class="col d-flex justify-content-end">
                        <a class="btn btn-secondary" 
                           href="${pageContext.servletContext.contextPath}/Views/BackOffice/Order/Bo.OrderSummary.jsp">Back</a>
                    </div>
                </div>
            </div>
        </div>
        <script src="../../../Scripts/BackOffice/Order/Bo.OrderView.js" type="text/javascript"></script>
        <%@include file="../Bo.Footer.jsp" %>
    </body>
</html>
