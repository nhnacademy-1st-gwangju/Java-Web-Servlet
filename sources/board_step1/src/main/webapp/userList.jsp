<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>NHN Board - 사용자 목록 페이지</title>
</head>
<body>
<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
<h1><fmt:message key="userlist"/></h1>
<table>
    <tr>
        <th>name</th>
        <th>profile</th>
    </tr>
    <c:forEach var="item" items="${requestScope.users}">
        <tr>
            <td><a href="/userInfo.do?id=${item.id}">${item.name}</a></td>
            <td><img src="/tomcatImg/${item.profileFileName}" alt="이미지"></td>
        </tr>
    </c:forEach>
</table>
<a href="/main.jsp"><fmt:message key="home"/></a>
</fmt:bundle>
</body>
</html>
