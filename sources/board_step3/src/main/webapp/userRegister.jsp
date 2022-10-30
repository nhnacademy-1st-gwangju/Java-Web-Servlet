<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NHN Board - 사용자 등록 페이지</title>
</head>
<body>
<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
<h1><fmt:message key="userregister"/></h1>
<form method="post" action="/users/register.do">
    ID: <input type="text" name="id" /><br/>
    PW: <input type="text" name="password" /><br/>
    <fmt:message key="username"/>: <input type="text" name="name" /><br/>
    <input type="submit" />
</form>
</fmt:bundle>
</body>
</html>
