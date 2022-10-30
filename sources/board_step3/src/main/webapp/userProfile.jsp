<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NHN Board - 사용자 이미지 등록 페이지</title>
</head>
<body>
<fmt:setLocale value="${applicationScope.lang}" />
<fmt:bundle basename="locale">
<h1><fmt:message key="addprofile"/></h1>
<form method="post" action="/profile?id=${requestScope.editUser.id}" enctype="multipart/form-data">
    <fmt:message key="addprofile"/>: <input type="file" name="profile" value="${requestScope.editUser.profileFileName}"/><br/>
    <input type="submit" />
</form>
</fmt:bundle>
</body>
</html>
