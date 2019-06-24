<%@page import="po.book"%>
<%@page import="po.users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
<title>document</title>
</head>
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/update2.css">
<body>

<%
 users u = (users) session.getAttribute("fuser");
%>
<div id="update">
 <h4 align="center">修改资料</h4>
 <form class="form-horizontal" method="get" action="${pageContext.request.contextPath}/updateu">
     <div class="form-group">
         <label class="col-xs-3 control-label">id</label>
         <div class="col-sm-6">
             <input type="text" class="form-control" name="id" value="<%=u.getId()%>" placeholder="id" readonly>
         </div>
     </div>
  <div class="form-group">
   <label class="col-xs-3 control-label">用户名</label>
   <div class="col-sm-6">
    <input type="text" class="form-control" name="username" value="<%=u.getUsername()%>" placeholder="用户名">
   </div>
  </div>

  <div class="form-group">
   <label class="col-xs-3 control-label">密码</label>
   <div class="col-sm-6">
    <input type="text" class="form-control" value="<%=u.getPwd()%>"name="pwd" placeholder="密码">
   </div>
  </div>

  <div class="form-group">
   <label class="col-xs-3 control-label">性别</label>
   <div class="col-sm-6">
    <input type="text" class="form-control"value="<%=u.getSex()%>" name="sex" placeholder="性别">
   </div>
  </div>
  <div class="form-group">
   <label class="col-xs-3 control-label">班级</label>
   <div class="col-sm-6">
    <input type="text" class="form-control"value="<%=u.getClasss()%>" name="classs" placeholder="班级">
   </div>
  </div>
  <div class="form-group">
   <label class="col-xs-3 control-label">联系方式</label>
   <div class="col-sm-6">
    <input type="text" class="form-control"value="<%=u.getTel()%>" name="tel" placeholder="班级">
   </div>
  </div>
  <div class="form-group">
   <div class="col-sm-offset-2 col-sm-10">
    <input type="submit" value="提交" class="btn btn-primary col-sm-1 left1" />
    <input type="reset" value="撤销" class="col-xs-1 left btn btn-primary" />
    <a class="btn btn-primary col-xs-1 left" href="usermain.jsp">返回</a>
   </div>
  </div>
 </form>
</div>
</body>
</html>