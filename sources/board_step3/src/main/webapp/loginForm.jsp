<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<html>
<head>
    <title>NHN Board - Login</title>
</head>
<body>
<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
<h1><fmt:message key="login"/></h1>
<form method="post" action="/login.do">
    id: <input type="text" name="id" /><br/>
    password: <input type="text" name="password" /><br/>

    <input type="submit" />
</form>
</fmt:bundle>
</body>
</html>
