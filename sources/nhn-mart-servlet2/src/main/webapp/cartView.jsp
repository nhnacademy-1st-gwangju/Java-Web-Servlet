<%@ page contentType="text/html;charset=UTF-8" language="java" session="false"%>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>NHN Mart - 장바구니 목록</title>
</head>
<body>
<p>장바구니에 담긴 상품 목록: 양파  ${applicationScope.cartOnion}개, 계란 ${applicationScope.cartEgg} 개, 파 ${applicationScope.cartGreenOnion}개, 사과 ${applicationScope.cartApple}개</p><br/>
<p>전체 금액: ${requestScope.sum}</p><br/>
<p>----결제창----</p>
<form method="post" action="/pay.do">
    양파: <input type="text" name="pay" value="${applicationScope.cartOnion}" readonly><br />
    계란: <input type="text" name="pay" value="${applicationScope.cartEgg}" readonly><br />
    파: <input type="text" name="pay" value="${applicationScope.cartGreenOnion}" readonly><br />
    사과: <input type="text" name="pay" value="${applicationScope.cartApple}" readonly><br />
    전체 금액: <input type="text" name="pay" value="${requestScope.sum}" readonly><br />
    <br />
    <input type="submit" value="결제 하기">
</form>
<a href="/foods.do">상품 목록</a>
</body>
</html>
