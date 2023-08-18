<%-- 
    Document   : Bo.EditUser
    Created on : Feb 23, 2022, 9:32:01 AM
    Author     : Tan Lin Yi
--%>
<%@page import="Model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            request.setAttribute("admin", "Admin");
            request.setAttribute("staff", "Staff");

            request.setAttribute("users", new BusinessLogic.BackOffice.User.BllBo_Get().businessLogic(new User().setUsername(request.getParameter("username"))));
        %>
        <title>Nike Office | Edit User</title>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
        <link href="../../../StyleSheets/BackOffice/User/Bo.user.css" rel="stylesheet" type="text/css"/>
        <%@include file="Bo.UserComfirm.jsp"%>
    </head>
    <body>
        <div class="cont">
            <div class="cont2">

                <div>
                    <h2>Edit User</h2>
                </div>
                <form  method="post" action="${pageContext.servletContext.contextPath}/EditUser">

                    <div class="row mb-4">
                        <div class="col-md-5">
                            <div class="form-outline">
                                <input type="text" name="username" class="form-control" value="${users[0].username}" readonly/>
                                <label class="form-label" for="username">Username</label>
                            </div>
                        </div>                  
                        <div class="col-md-5">
                            <div class="form-outline">
                                <input type="text" name="name" class="form-control" value="${users[0].name}" />
                                <label class="form-label" for="name">Name*</label>
                            </div>
                        </div>
                    </div>

                    <div class="row mb-4">
                        <div class="col-md-5">
                            <div class="form-outline">
                                <input type="text" name="phone" class="form-control" value="${users[0].phone}"/>
                                <label class="form-label" for="phone">Phone*</label>

                            </div>
                        </div>

                        <div class="col-md-5">
                            <div class="form-outline">
                                <input type="mail"  name="mail" class="form-control" value="${users[0].mail}"/>
                                <label class="form-label" for="mail">Email*</label>
                            </div>
                        </div>
                    </div>
                    <div class="row mb-4">
                        <div class="col-md-5">
                            <div class="form-outline">

                                <input type="text" name="status" class="form-control" value="${users[0].status}" disabled/>
                                <label class="form-label" for="status">Status</label>
                            </div>
                        </div>

                        <div class="col-md-5">
                            <div class="form-outline">
                                <input type="text" id="userGroup" class="form-control" value="${users[0].userGroup.userGroupName}"  disabled/>
                                <label class="form-label" for="userGroup">User Group </label>
                            </div>

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
        <script src="../../../Scripts/BackOffice/User/Bo.User.js" type="text/javascript"></script>
        <script src="../../../Scripts/BackOffice/User/Bo.UserEdit.js" type="text/javascript"></script>
    </body>


</html>

