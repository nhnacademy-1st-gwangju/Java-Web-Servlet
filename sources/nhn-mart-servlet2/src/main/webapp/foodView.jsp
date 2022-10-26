<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>NHN Mart - 상품 목록</title>
</head>
<body>
<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
    <h3><fmt:message key="foodTitle"/></h3>
    <fmt:message key="onionName"/>: ${requestScope.onionCount}<fmt:message key="ea"/>(1000<fmt:message key="won"/>)<br/>
    <fmt:message key="eggName"/>: ${requestScope.eggCount}<fmt:message key="box"/>(5000<fmt:message key="won"/>)<br/>
    <fmt:message key="greenOnionName"/>: ${requestScope.greenOnionCount}<fmt:message key="ea"/>(500<fmt:message key="won"/>)<br/>
    <fmt:message key="appleName"/>: ${requestScope.appleCount}<fmt:message key="ea"/>(2000<fmt:message key="won"/>)<br/>
    <br/>
    <br/>

    <form method="post" action="/cart.do">
        <fmt:message key="onionName"/>: <input type="number" name="cart"><br/>
        <fmt:message key="eggName"/>: <input type="number" name="cart"><br/>
        <fmt:message key="greenOnionName"/>: <input type="number" name="cart"><br/>
        <fmt:message key="appleName"/>: <input type="number" name="cart"><br/>
        <input type="submit" value="<fmt:message key="doCart"/>">
    </form>
</fmt:bundle>
</body>
</html>
