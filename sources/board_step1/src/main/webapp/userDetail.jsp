<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>NHN Board - 사용자 정보 페이지</title>
</head>
<body>
<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
<h1><fmt:message key="userinfo"/></h1>
<table>
    <tr>
        <th>name</th>
        <th>profile</th>
    </tr>
    <tr>
        <td>${requestScope.findUser.name}</td>
        <td><img src="/tomcatImg/${requestScope.findUser.profileFileName}"
                 alt="${requestScope.findUser.profileFileName}"></td>
    </tr>
</table>
<br/>
<c:choose>
    <c:when test="${sessionScope.id == 'admin'}">
        <a href="/users/edit.do?id=${requestScope.findUser.id}"><fmt:message key="edit"/></a><br />
        <a href="/users/profile.do?id=${requestScope.findUser.id}"><fmt:message key="addprofile"/></a><br />
        <form action="/users/delete.do?id=${requestScope.findUser.id}" method="post">
            <button type="submit"><fmt:message key="delete"/></button>
        </form>
    </c:when>
</c:choose>
<a href="/users/view.do"><fmt:message key="userlist"/></a><br />
<a href="/main.jsp"><fmt:message key="home"/></a>
</fmt:bundle>
</body>
</html>
