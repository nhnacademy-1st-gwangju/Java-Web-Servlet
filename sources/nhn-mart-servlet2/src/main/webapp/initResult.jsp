<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<html>
<head>
    <title>NHN Mart - init 결과창</title>
</head>
<body>
<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
    <a href="/"><fmt:message key="goToHome" /></a>
    <a href="/foods.do"><fmt:message key="foodList" /></a>
</fmt:bundle>
</body>
</html>
