<%@page contentType="text/html; charset=gb2312" %>
<html>
	<head>
		<meta charset="gb2312" />
		<title>登录</title>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/logStyle.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
	</head>
	<body>
		<div id="login">
			<img src="${pageContext.request.contextPath}/img/log.jpg"  width="1400"/>
			<div class="log">
				<h3 align="center">登录</h3>
				    <br />
					<br />
					<form>
				<span>用户:</span> <input type="text" name="username" id="username" />
					<br />
					<br />
					<br />
				<span>密码: </span><input type="password" name="pwd" id="pwd"/>
					<br />
					<br />
					<br />
				<input type="radio" name="statue" value="0" class="statue"/>管理员
				<input type="radio" name="statue" value="1" class="statue"/>普通
				   <br /><br />
				<input type="button" value="登陆" onclick="testJson()"/>
				</form>
			</div>
		</div>
		<script type="text/javascript">
		 function testJson(){
		  var username = $("#username").val();
		  var pwd = $("#pwd").val();
		  var statue = $("input:radio:checked").val();
		  var urls = "${pageContext.request.contextPath}/logins?username="+username+"&pwd="+pwd+"&statue="+statue;
		  $.ajax({
		   url:urls,	   
		   contentType:"application/json;charset=utf-8",
		   success:function(data){   
		    if(data==1){
		     window.location.href = "../librarys/usermain.jsp";
		    }
		    else if(data ==2){
		    window.location.href = "../librarys/rootmain.jsp";
		    }
		    else{
		    window.location.href = "../index.jsp";
		    }
		   }  
		  })
		 
		 }
		</script>
	</body>
</html>
