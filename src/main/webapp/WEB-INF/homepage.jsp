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
            You are a Customer
        </sec:authorize>
            <sec:authorize access="hasRole('LIBRARIAN')">
                You are a Librarian
            </sec:authorize></br>
            <sec:authorize access="isAuthenticated()">
                Username: <sec:authentication property="name"/>
            </sec:authorize></br>
            <form action="/logout">
                <input type="submit" value="Logout" />
            </form>
    </body>
</html>
