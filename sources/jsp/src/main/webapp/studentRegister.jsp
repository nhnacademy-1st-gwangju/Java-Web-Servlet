<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%-- FrontServlet으로 위임 (.do) --%>
<form method="post" action="/student/register.do">
    학번: <input type="text" name="id" /><br/>
    이름: <input type="text" name="name" /><br/>
    성별: <input type="text" name="gender" /><br/>
    나이: <input type="text" name="age" /><br/>
    <input type="submit" />
</form>
</body>
</html>
