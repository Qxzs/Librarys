<%@page contentType="text/html; charset=utf-8" %>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>登录</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/logStyle.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	</head>
	<body>
	<%
	 String str =(String) session.getAttribute("reflag");
	 if (str==null){

	 }
	 else{
	     %>
	<script>
		alert("注册成功，请登录");
	</script>
	<%
         session.removeAttribute("reflag");
	 }
	%>

	<div id="wrap">
		<div id="nav">
			<h3>图书馆</h3>
		</div>
		<div id="contain">
			<h3>请登录</h3>
			<hr>
			<input type="text" placeholder="用户名" name="username" id="username"><br>
			<input type="password" placeholder="密码" name="pwd" id="pwd"><br>
			<input type="text" placeholder="验证码" class="Verification" id="verifyCode" name="verifyCode">
			<img src="${pageContext.request.contextPath}/getVerifyCode" name="verifyCodes" id="verifyCodeImage" onclick="changeImage()" alt="132">
			<br>
			<input type="radio" name="statue" value="0" class="r1"/><span class="span1">管理员</span>
			<input type="radio" name="statue" value="1" class="r2"/><span class="span2">用户</span>
			<br>
			<button onclick="testJson()">登录</button>
			<button onclick="toAdd()" class="add">注册</button>
		</div>
	</div>
 <script src="${pageContext.request.contextPath}/js/handles.js" type="text/javascript"></script>

	</body>
</html>
