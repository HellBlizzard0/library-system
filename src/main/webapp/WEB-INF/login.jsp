<%-- 
    Document   : test
    Created on : Feb 28, 2022, 11:59:40 AM
    Author     : aalsaqqa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <header></header>
    <body>
        <div>

            <div id="loginbox" style="margin-top: 50px;"
                 class="mainbox col-md-3 col-md-offset-2 col-sm-6 col-sm-offset-2">

                <div class="panel panel-info">

                    <div class="panel-heading">
                        <div class="panel-title">Sign In</div>
                    </div>

                    <div style="padding-top: 30px" class="panel-body">

                        <!-- Login Form -->
                        <form action="${pageContext.request.contextPath}/authenticateTheUser"
                              method="POST" class="form-horizontal">

                            <!-- Place for messages: error, alert etc ... -->
                            <div class="form-group">
                                <div class="col-xs-15">
                                    <div>

                                        <!-- Check for login error -->

                                        <c:if test="${param.error != null}">

                                            <div class="alert alert-danger col-xs-offset-1 col-xs-10">
                                                Invalid username and password.
                                            </div>

                                        </c:if>
                                        <!-- Check for logout -->

                                        <c:if test="${param.logout != null}">

                                            <div class="alert alert-success col-xs-offset-1 col-xs-10">
                                                You have been logged out.
                                            </div>

                                        </c:if>

                                    </div>
                                </div>
                            </div>

                            <!-- User name -->
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>

                                <input type="text" name="username" placeholder="username" class="form-control">
                            </div>

                            <!-- Password -->
                            <div style="margin-bottom: 25px" class="input-group">
                                <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>

                                <input type="password" name="password" placeholder="password" class="form-control" >
                            </div>

                            <!-- Login/Submit Button -->
                            <div style="margin-top: 10px" class="form-group">
                                <div class="col-sm-6 controls">
                                    <button type="submit" class="btn btn-success">Login</button>
                                </div>
                            </div>

                            <!-- I'm manually adding tokens ... Bro! -->

                            <input type="hidden"
                                   name="${_csrf.parameterName}"
                                   value="${_csrf.token}" />

                        </form>

                    </div>

                </div>

            </div>

        </div>
    </body>

</html>
