<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<c:set var="basePath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/sso/login.do" method="post">
    <input id="username" name="username" value="name"/>
    <input id="password" name="password" value="password">
    <input id="callbackURL" name = "callbackURL" value="" style="display:none"/>
    <button id="login" name="login" type="submit">登录</button>
</form>
</body>
<script type="text/javascript" src="${basePath}/static/js/jquery-3.1.1.js" ></script>
<script type="text/javascript" src="${basePath}/static/login/login.js" ></script>
</html>
