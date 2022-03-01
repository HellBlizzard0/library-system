<%-- 
    Document   : home
    Created on : Feb 28, 2022, 1:18:26 PM
    Author     : aalsaqqa
--%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
    <head>
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <sec:authorize access="hasRole('CUSTOMER')">
            CUSTOMER Role
        </sec:authorize>
            <sec:authorize access="hasRole('ADMINISTRATOR')">
                ADMINISTRATOR Role
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                Welcome Back, <sec:authentication property="name"/>
            </sec:authorize>
    </body>
</html>
