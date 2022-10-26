<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>NHN Mart - 결제 완료 페이지</title>
</head>
<body>
결제 금액: ${requestScope.sum}<br />
결제 후 잔액:  ${requestScope.payResult}<br />
<a href="/">메인으로 돌아가기</a><br />
</body>
</html>
