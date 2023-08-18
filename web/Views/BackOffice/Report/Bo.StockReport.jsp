<%-- 
    Document   : Bo.StockReport
    Created on : Mar 31, 2022, 5:11:37 PM
    Author     : Lin
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Product"%>
<%@page import="Model.ProductDetail"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%

        ArrayList<Product> products = new BusinessLogic.BackOffice.StockReport.BllBo_GetFull().businessLogic(new Product());
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Nike Office | Stock Report</title>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
    </head>
    <body>
        <div class="cont" >
            <div id="div_print">
                <div class="m-4" >
                    <h2>Stock Report</h2>
                </div>

                <div class="cont1">  
                    <!--the id will be used in js file-->
                    <table id="table-sales-report" class="table table-striped border" >
                        <thead>

                            <tr>
                                <th class="text-capitalize">Product No</th>
                                <th class="text-capitalize">Product Name</th>
                                <th class="text-capitalize">Color</th>
                                <th class="text-capitalize">Size</th>
                                <th class="text-capitalize">physical quantity</th> 
                            </tr>
                        </thead>
                        <tbody>
                            <%
                                for (Product p : products) {
                                    for (ProductDetail pd : p.getProductDetail()) {
                            %>
                            <tr>

                                <td><pre:out value="<%= p.getProductNo()%>"/></td>
                                <td><pre:out value="<%= p.getProductName()%>"/></td>
                                <td><pre:out value="<%= pd.getSize()%>"/></td>  
                                <td><pre:out value="<%= pd.getColor()%>"/></td>
                                <td><pre:out value="<%= pd.getPhysicalQty()%>"/></td>


                            </tr>
                            <%         }
                                }

                            %>
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
                    <!--<button type="button" class="btn btn-primary ms-4"  onclick="PrintElem(elem)">Print <i class="fas fa-print"></i></button>-->
                    <input name="b_print" type="button" class="ipt btn btn-primary ms-4" onClick="printdiv('div_print');" value=" Print ">
                </div>
            </div>
        </div>
                       <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/Report/Bo.Print.js" type="text/javascript"></script>
        
        <script src="../../../Scripts/BackOffice/Report/Bo.StockReport.js" type="text/javascript"></script>

    </body>
</html>