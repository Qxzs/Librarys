<%@ page import="com.sun.org.apache.xpath.internal.operations.String" %><%--
  Created by IntelliJ IDEA.
  User: lbqljl
  Date: 2019/4/17
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/update2.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>

<div id="update">
    <h4 align="center">添加成员</h4>
    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath}/inseruser">
        <div class="form-group">
            <label class="col-xs-3 control-label">用户名</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" name="username" id="username" placeholder="用户名">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 control-label">密码</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="pwd" name="pwd" placeholder="密码">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 control-label">性别</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="sex" name="sex" placeholder="性别">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 control-label">班级</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="classs" name="classs" placeholder="所在班级">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 control-label">联系方式</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="tel" name="tel" placeholder="联系方式">
            </div>
        </div>
        <div class="form-group">
            <label class="col-xs-3 control-label">申请职位</label>
            <div class="col-sm-6">
                <input type="text" class="form-control" id="statue" name="statue" placeholder="职位">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-10">
                <input type="submit" value="提交" class="btn btn-primary col-sm-1 left1" />
                <input type="reset" value="撤销" class="col-xs-1 left btn btn-primary" />
                <a class="btn btn-primary col-xs-1 left" href="login.jsp">返回</a>
            </div>
        </div>
    </form>
</div>
<script>
    function toRoot() {
        window.location.href ="../librarys/login.jsp";
    }
    <%--function toAdduser() {--%>
        <%--var username = $("#username").val();--%>
        <%--var pwd = $("#pwd").val();--%>
        <%--var statue = $("#statue").val();--%>
        <%--var classs = $("#classs").val();--%>
        <%--var sex = $("#sex").val();--%>
        <%--var tel = $("#tel").val();--%>
        <%--var u = {--%>
            <%--"id":0,--%>
            <%--"usernaem":username,--%>
            <%--"pwd":pwd,--%>
            <%--"statue":statue,--%>
            <%--"sex":sex,--%>
            <%--"tel":tel,--%>
            <%--"classs":classs--%>
        <%--}--%>
        <%--$.ajax({--%>
            <%--url:"${pageContext.request.contextPath}/inseruser",--%>
            <%--type:"post",--%>
            <%--dataType:"json",--%>
            <%--contentType:"application/json;charset=utf-8",--%>
            <%--data:{u:JSON.stringify(u)},--%>
            <%--success:function (data) {--%>
                <%--alert(data);--%>
            <%--}--%>
        <%--})--%>
    <%--}--%>
</script>
</body>
</html>
