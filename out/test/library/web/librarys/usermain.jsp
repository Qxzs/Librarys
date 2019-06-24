<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="po.book"%>


<%@page contentType="text/html; charset=utf-8" %>
<html>
<head>
<title>document</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>
<body>
<form method="post">
	<input type="text" name="book" id="book" />
	<input type="radio" value="0" name="c">书名
	<input type="radio" value="1" name="c">作者
	<input type="button" value="搜索" onclick="search()"/>
	</form>
	<%   List<book> list = (List<book>) session.getAttribute("book");
         
         if(list!=null){
          
          out.print("<table border=1>");
          out.print("<tr>");
          out.print("<th width=50>"+"序号");
          out.print("<th width=100>"+"书名");
          out.print("<th width=50>"+"简介");
          out.print("<th width=100>"+"出版时间");
          out.print("<th width=100>"+"可借数量");
          out.print("<th width=100>"+"作者");
          out.print("<th width=100>"+"位置");
          out.print("</tr>");
        
          for(int i =0;i<list.size();i++){
           
            out.print("<tr>");
            out.print("<td >"+list.get(i).getBook_id()+"</td>"); 
            out.print("<td >"+list.get(i).getBook_name()+"</td>");
            out.print("<td >"+list.get(i).getBook_face()+"</td>");
            out.print("<td >"+list.get(i).getBook_create()+"</td>");
            out.print("<td >"+list.get(i).getBook_num()+"</td>");
            out.print("<td >"+list.get(i).getBook_author()+"</td>");
            out.print("<td >"+list.get(i).getBook_address()+"</td>");
            out.print("</tr>");
          }
          out.print("</table>");
           }
      %>
		<script>
			function search(){
			 
			  var name= $("#book").val();
			  var cho = $("input:radio:checked").val();
			  var str = encodeURI(name);
			  var cno = encodeURI(cho);


			  var urls ="${pageContext.request.contextPath}/search?name="+str+"&cno="+cno;
			  alert(urls);
			  $.ajax({   
			  	url:urls,
			  	type:"get",
			  	contentType:"application/json;charset=utf-8",
			  	success:function(data){
			  	 
			  	 window.location.href = data;
			  	 
			  	}
			  });
			}
			
		</script>

</body>
</html>