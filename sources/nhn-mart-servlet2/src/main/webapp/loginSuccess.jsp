<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NHN Mart - 로그인 성공</title>
</head>
<body>
<%
    HttpSession httpSession = request.getSession(false);
    String id = httpSession.getAttribute("id").toString();
    String money = config.getServletContext().getAttribute("money").toString();
%>
<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
    <p><fmt:message key="loginSuccess" /></p><br/>
    <p><%= id %> <fmt:message key="welcome" /></p><br/>
    <p><fmt:message key="account" />: <%= money %></p><br/>
    <a href="/logout.do"><fmt:message key="logout" /></a><br/>
    <a href="/init"><fmt:message key="init" /></a><br/>
    <a href="/foods.do"><fmt:message key="foodList" /></a><br/>
</fmt:bundle>
</body>
</html>
