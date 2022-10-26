<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NHN Mart - 결제 완료 페이지</title>
</head>
<body>
<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
    <fmt:message key="payments"/>: ${requestScope.sum}<br/>
    <fmt:message key="afterPay"/>:  ${requestScope.payResult}<br/>
    <a href="/"><fmt:message key="goToHome"/></a><br/>
</fmt:bundle>
</body>
</html>
