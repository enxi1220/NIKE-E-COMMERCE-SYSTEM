<%--
    Document   : OrderEdit
    Created on : 23 Feb 2022, 12:12:40 am
    Author     : Alvin Chan Ee Aun
--%>
<%@page import="Model.Order"%>
<%@page import="Model.OrderDetail"%>
<%@page import="Helper.Constant"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            request.setAttribute("paid", Helper.Constant.getStatus(Constant.StatusEnum.Paid));
            request.setAttribute("packaging", Helper.Constant.getStatus(Constant.StatusEnum.Packaging));
            request.setAttribute("shipping", Helper.Constant.getStatus(Constant.StatusEnum.Shipping));
            request.setAttribute("delivered", Helper.Constant.getStatus(Constant.StatusEnum.Delivered));

            int orderId = Integer.parseInt(request.getParameter("orderId"));
            request.setAttribute("orders", new BusinessLogic.BackOffice.Order.BllBo_Get().businessLogic(new Order().setOrderId(orderId)));
            ArrayList<Order> orders = (ArrayList<Order>) request.getAttribute("orders");
        %>
        <title>Nike Office | Edit Order</title>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
    </head>
    <body>
        <div class="cont">
            <div class="cont2">
                <div>
                    <h2>Edit Order</h2>
                </div>
                <form method="post" action="${pageContext.servletContext.contextPath}/EditOrder">

                    <!------------ Order ID ----------->
                    <input type="text" name="orderId" value="${orders[0].orderId}" hidden/>

                    <!------------ Order No ----------->
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <div class="form-outline">
                                <input type="text" name="orderNo" class="form-control" value="${orders[0].orderNo}" readonly/>
                                <label class="form-label" for="orderNo">Order No</label>
                            </div>
                        </div>

                        <!------------ Tracking No ----------->
                        <div class="col-md-6">
                            <div class="form-outline">
                                <input type="text" name="trackingNo" class="form-control" value="${orders[0].trackingNo}"/>
                                <label class="form-label" for="trackingNo">Tracking No</label>
                            </div>
                        </div>
                    </div>

                    <!------------ Receiver name ----------->
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <div class="form-outline">  
                                <input type="text" name="receiverName" class="form-control" value="${orders[0].receiverName}" readonly/>
                                <label class="form-label" for="receiverName">Receiver name</label>
                            </div>
                        </div>

                        <!---------- Total Price ---------->
                        <div class="col-md-6">
                            <div class="form-outline">
                                <input type="text" name="viewPrice" class="form-control" value="<fmt:formatNumber value="${orders[0].price}" type="number" minFractionDigits="2"/>" readonly/>
                                <label class="form-label" for="viewPrice">Total Price(RM)</label>
                            </div>
                        </div>
                    </div>

                    <!------------ Address ----------->
                    <div class="row mb-4">
                        <div class="col-md-12">
                            <div class="form-outline">
                                <input type="text" name="deliveryAddress" class="form-control" value="${func:replace(orders[0].deliveryAddress,".",", ")}" readonly/>
                                <label class="form-label" for="deliveryAddress">Delivery Address</label>
                            </div>
                        </div>
                    </div>

                    <!------------ Email ----------->
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <div class="form-outline">
                                <input type="email" name="userEmail" class="form-control" value="${orders[0].customer.mail}" readonly/>
                                <label class="form-label" for="userEmail">Email</label>
                            </div>
                        </div>

                        <!------------ Phone ----------->
                        <div class="col-md-6">
                            <div class="form-outline">
                                <input type="text" name="receiverPhone" class="form-control" value="${orders[0].customer.phone}" readonly/>
                                <label class="form-label" for="receiverPhone">Phone</label>
                            </div>
                        </div>
                    </div>

                    <!------------ Courier ----------->
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <div class="form-outline">
                                <input type="email" name="courier" class="form-control" value="${orders[0].courier.courierName}" readonly/>
                                <label class="form-label" for="courier">Courier</label>
                            </div>
                        </div>

                        <!------------ Delivery Fee ----------->
                        <div class="col-md-6">
                            <div class="form-outline">
                                <input type="number" name="receiverPhone" class="form-control"  value="<fmt:formatNumber value="${orders[0].deliveryFee}" type="number" minFractionDigits="2"/>" readonly/>
                                <label class="form-label" for="receiverPhone">Delivery Fee(RM)</label>
                            </div>
                        </div>
                    </div>

                    <!------------ Status ----------->
                    <div class="row mb-4">
                        <div class="col-md-12 ">
                            <select class="form-outline form-control" name="orderStatus" value="${orders[0].status}">
                                <option disable selected hidden>Status</option>
                                <option value="${orders[0].status}" selected>${orders[0].status}</option>
                                <pre:if test="${orders[0].status == paid}">
                                    <option value="${packaging}">${packaging}</option>
                                </pre:if>
                                <pre:if test="${orders[0].status == packaging}">
                                    <option value="${shipping}">${shipping}</option>
                                </pre:if>
                                <pre:if test="${orders[0].status == shipping}">
                                    <option value="${delivered}">${delivered}</option>
                                </pre:if>
                            </select>
                        </div>
                    </div>

                    <hr>

                    <table id="table-orderEdit-summary" class="table table-striped border">
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

                    <br />
                    <div class="row mt-3 mb-5">
                        <div class="col d-flex justify-content-end">
                            <a class="btn btn-secondary" 
                               href="${pageContext.servletContext.contextPath}/Views/BackOffice/Order/Bo.OrderSummary.jsp">Back</a>
                            <button type="submit" class="btn btn-primary ms-4">Save</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/Order/Bo.OrderEdit.js" type="text/javascript"></script>
    </body>
</html>
