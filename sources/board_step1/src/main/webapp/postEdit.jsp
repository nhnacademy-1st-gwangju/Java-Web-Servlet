<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NHN Board - 게시글 수정 페이지</title>
</head>
<body>
<fmt:setLocale value="${applicationScope.lang}"/>
<fmt:bundle basename="locale">
<h1><fmt:message key="editpost"/></h1>
<form method="post" action="/posts/edit.do?id=${requestScope.editPost.id}">
    <fmt:message key="posttitle"/>: <input type="text" name="title" value="${requestScope.editPost.title}"/><br/>
    <fmt:message key="postcontent"/>: <input type="text" name="content" value="${requestScope.editPost.content}"/><br/>
    <fmt:message key="postwriter"/>: <input type="text" name="writer" value="${requestScope.editPost.writerUserId}"/><br/>
    <input type="submit" />
</form>
</fmt:bundle>
</body>
</html>
