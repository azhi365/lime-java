<%@ page import="org.jasig.cas.client.authentication.AttributePrincipal" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/css.css">
</head>
<body>

<%
    AttributePrincipal principal = (AttributePrincipal) request.getUserPrincipal();
    String username = principal.getName();
    String password = principal.getProxyTicketFor(username);
    System.out.println(username);
%>
<%= username%>
</body>
</html>
