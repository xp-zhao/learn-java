<%@ page language="java" contentType="text/html; charset=utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post">
    <input id="username" name="username" value="name"/>
    <input id="password" name="password" value="password">
    <button id="login" name="login" type="submit">登录</button>
</form>
</body>
</html>
