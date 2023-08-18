<%-- 
    Document   : newuser
    Created on : Feb 23, 2022, 9:31:22 AM
    Author     : Tan Lin Yi
--%>

<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nike Office | Add User</title>
        <%@include file="Bo.UserComfirm.jsp"%>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
        <link href="../../../StyleSheets/BackOffice/User/Bo.user.css" rel="stylesheet" type="text/css"/>

    </head>
    <body>
        <div class="cont">
            <div class="cont2">
                <div id="h2user">
                    <h2>Add User</h2>
                    <br>
                </div>
                <form method="post" action="${pageContext.servletContext.contextPath}/NewUser">
                    <!------------ information ----------->
                    <div><h5>Information</h5></div>
                    <div class="row mb-4">
                        <div class="col-md-5">
                            <div class="form-outline">

                                <input type="text" name="username" class="form-control" />
                                <label class="form-label" for="username">Username (Must Be Unique)*</label>
                            </div>
                        </div>

                        <div class="col-md-5">
                            <div class="form-outline">
                                <input type="text" name="name" class="form-control" />
                                <label class="form-label" for="name">Name*</label>
                            </div>
                        </div>
                    </div>

                    <div class="row mb-4">
                        <div class="col-md-5">
                            <div class="form-outline">
                                <input type="password" name="password" class="form-control" showcounter="true" />
                                <label class="form-label" for="password">Password*</label>
                            </div>
                        </div>


                        <div class="col-md-5">
                            <div class="form-outline">
                                <input type="mail" name="mail" class="form-control" />
                                <label class="form-label" for="mail">Email*</label>
                            </div>
                        </div>
                    </div>

                    <div class="row mb-4">
                        <div class="col-md-5">
                            <div class="form-outline">
                                <input type="phone" name="phone" class="form-control"  />
                                <label class="form-label" for="phone">Phone*</label>
                            </div>
                        </div>

                        <div class="col-md-5">
                            <select class="form-outline form-control"  id="userGroupId" name="userGroupId">
                                <option disable selected hidden>User Group*</option>
                                <option value="1">Admin</option>
                                <option value="2">Staff</option>
                            </select>
                        </div>
                    </div>

                    <!-- Save and Cancel button -->
                    <div class="col d-flex justify-content-end mb-4">
                        <!-- Cancel button -->
                        <a class="btn btn-secondary" 
                           href="${pageContext.servletContext.contextPath}/Views/BackOffice/User/Bo.UserSummary.jsp">Back</a>
                        <!-- Print button -->
                        <button type="submit" class="btn btn-primary ms-4">Save</button> 
                    </div>
                </form>
            </div>          
        </div>

        <%@include file="../Bo.Footer.jsp" %>
        <script src="../../../Scripts/BackOffice/User/Bo.UserNew.js" type="text/javascript"></script>
        <script src="../../../Scripts/BackOffice/User/Bo.User.js" type="text/javascript"></script>

    </body>


</html>


