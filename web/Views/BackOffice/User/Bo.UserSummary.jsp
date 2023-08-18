<%-- 
    Document   : Bo.SummaryUser
    Created on : Feb 23, 2022, 9:33:12 AM
    Author     : Tan Lin Yi
--%>

<%@page import="Model.User"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%
            request.setAttribute("users", new BusinessLogic.BackOffice.User.BllBo_GetFull().businessLogic(new User()));

        %>
        <title>Nike Office | User Summary</title>
        <link href="../../../StyleSheets/BackOffice/User/Bo.user.css" rel="stylesheet" type="text/css"/>
        <%@include file="../Bo.HeaderANDNav.jsp"%>
        <%--<%@include file="Bo.UserComfirm.jsp"%>--%>


    </head>
    <body>
        <div class="cont">

            <div class="m-4">
                <h2>User Summary</h2>
            </div>
            <div class="cont1">  
                <!--the id will be used in js file-->
                <table id="table-user-summary" class="table table-striped border">
                    <thead>
                        <tr>
                    <a class="btn btn-primary btn-lg btn-floating btn-sm bg-primary float-end" 
                       data-mdb-toggle="tooltip" title="Add"  href="Bo.UserAdd.jsp" role="button">
                        <i class="fas fa-plus"></i>
                    </a>
                    </tr>
                    <tr>
                        <th class="text-capitalize">Action</th>
                        <th class="text-capitalize">Username</th>
                        <th class="text-capitalize">Name</th>
                        <th class="text-capitalize">User Group</th>
                        <th class="text-capitalize">Status</th>      
                        <th class="text-capitalize">Created Date</th>
                        <th class="text-capitalize">Created By</th>
                        <th class="text-capitalize">Updated Date</th>
                        <th class="text-capitalize">Updated By</th>


                    </tr>
                    </thead>
                    <tbody>
                        <pre:forEach items="${users}" var="user">
                            <tr>
                                <td>  
                                    <a class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                                       data-mdb-toggle="tooltip" title="View"  href="Bo.UserView.jsp?username=${user.username}" role="button">
                                        <i class="fas fa-solid fa-eye" ></i>
                                    </a>
                                    <a class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                                       data-mdb-toggle="tooltip" title="Edit"  href="Bo.UserEdit.jsp?username=${user.username}" role="button">
                                        <i class="fas fa-pen" ></i>
                                    </a>

                                    <button type="button" class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                                            data-mdb-toggle="tooltip" title="Activate"
                                            onclick="bouserActivate('${user.username}')">
                                        <i class="fas fa-check"></i>
                                    </button>

                                    <button type="button" class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                                            data-mdb-toggle="tooltip" title="Deactivate"
                                            onclick="bouserDeactivate('${user.username}')">
                                        <i class="fas fa-times"></i>
                                    </button>  
                                        
                                     <a class="btn btn-primary btn-lg btn-floating btn-sm bg-primary" 
                                       data-mdb-toggle="tooltip" title="Reset Password"  href="Bo.ResetPassword.jsp?username=${user.username}" role="button">
                                        <i class="fas fa-sync-alt" ></i>
                                    </a>
                              
                                </td>
                                <td><pre:out value="${user.username}" /></td>
                                <td><pre:out value="${user.name}" /></td>
                                <td><pre:out value="${user.userGroup.userGroupName}" /></td>  
                                <td><pre:out value="${user.status}" /></td>
                                <td><pre:out value="${user.createdDate}" /></td>
                                <td><pre:out value="${user.createdBy}" /></td>
                                <td><pre:out value="${user.updatedDate}" /></td>
                                <td><pre:out value="${user.updatedBy}" /></td>

                            </tr>

                        </pre:forEach>
                    </tbody>
                </table>
            </div>
        </div>
        <%@include file="../Bo.Footer.jsp" %> 
        <script src="../../../Scripts/BackOffice/User/Bo.UserSummary.js" type="text/javascript"></script>
        <script src="../../../Scripts/BackOffice/User/Bo.User.js" type="text/javascript"></script>
<!--        <script src="../../../Scripts/BackOffice/Bo.ForgetPassword.js" type="text/javascript"></script>-->
       
    </body>
</html>