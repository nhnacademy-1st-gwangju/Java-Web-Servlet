<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NHN Board - 사용자 수정 페이지</title>
</head>
<body>
<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
<h1><fmt:message key="edituser"/></h1>
<form method="post" action="/users/edit.do?id=${requestScope.editUser.id}">
    PW: <input type="text" name="password" value="${requestScope.editUser.password}"/><br/>
    <fmt:message key="username"/>: <input type="text" name="name" value="${requestScope.editUser.name}"/><br/>
    <input type="submit" />
</form>
</fmt:bundle>
</body>
</html>
