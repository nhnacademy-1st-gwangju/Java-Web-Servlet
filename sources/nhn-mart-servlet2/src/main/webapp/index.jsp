<%@ page import="java.util.Objects" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>NHN Mart</title>
</head>
<body>
<%
    HttpSession session = request.getSession(false);
    String money = null;
    String id = null;
    if (!Objects.isNull(session)) {
        money = config.getServletContext().getAttribute("money").toString();
        id = session.getAttribute("id").toString();
    }
%>
<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
    <h1><fmt:message key="welcomeHome"/></h1>
    <a href="/init"><fmt:message key="init"/></a><br/>
    <a href="/change-lang"><fmt:message key="change-lang"/></a><br/>
    <a href="/foods.do"><fmt:message key="foodList"/></a><br/>
    <a href="/cart.do"><fmt:message key="cartList"/></a><br/>
    <p><fmt:message key="init-lang"/>: ${applicationScope.lang}</p><br/>
    <%
        if (money != null) {
    %>
    <p><%= id %><fmt:message key="welcome"/></p><br/>
    <p><fmt:message key="account"/>: <%= money %>
    </p><br/>
    <%
        }
    %>
</fmt:bundle>
</body>
</html>
