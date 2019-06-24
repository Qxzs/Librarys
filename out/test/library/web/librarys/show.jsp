<%@page import="java.util.List"%>
<%@page import="po.book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<html>
<head>
<title>document</title>
</head>
<body>
<%
List<book> list = (List<book>) session.getAttribute("book");
if(!list.isEmpty()){
out.print(list);
}
 %>
</body>
</html>