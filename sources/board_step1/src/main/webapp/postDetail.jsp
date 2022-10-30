<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>NHN Board - 게시글 정보 페이지</title>
</head>
<body>
<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
<h1><fmt:message key="postinfo"/></h1>
<table>
    <tr>
        <th><fmt:message key="posttitle"/></th>
        <th><fmt:message key="postcontent"/></th>
        <th><fmt:message key="postwriter"/></th>
        <th><fmt:message key="addtime"/></th>
        <th><fmt:message key="postviewcount"/></th>
    </tr>
    <tr>
        <td>${requestScope.findPost.title}</td>
        <td>${requestScope.findPost.content}</td>
        <td><a href="/userInfo.do?id=${requestScope.postWriterId}">${requestScope.findPost.writerUserId}</a></td>
        <td>${requestScope.findPost.writeTime}</td>
        <td>${requestScope.findPost.viewCount}</td>
    </tr>
</table>
<br />
<c:choose>
    <c:when test="${sessionScope.userName == requestScope.findPost.writerUserId}">
        <a href="/posts/edit.do?id=${requestScope.findPost.id}"><fmt:message key="edit"/></a><br />
        <form action="/posts/delete.do?id=${requestScope.findPost.id}" method="post">
            <button type="submit"><fmt:message key="delete"/></button>
        </form>
    </c:when>
</c:choose>
<a href="/posts/view.do"><fmt:message key="postlist"/></a><br />
<a href="/main.jsp"><fmt:message key="home"/></a>
</fmt:bundle>
</body>
</html>
