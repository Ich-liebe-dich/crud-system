<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
 <script src="${ctx}/js/jquery.min.js"></script>
  <script src="${ctx}/js/popper.min.js" ></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
  <style>
  body {
  	margin-left: -10%;
  }
  .center {
  	margin: 0 auto;
  	text-align: center;
  }
  </style>
</head>
<body>
<div class="container">
  <div class="card">
    <div class="card-header">当前位置：学生管理 > 学生查询 </div>
    <div class="card-body">
    	<a href="${ctx}/excel/stu?name=stuExcel">导出</a>
    	 <form method="post" action="${ctx}/student/queryStudent">
  			学号：<input type="number" name="id" id="id">
  			姓名：<input name="name" id="name">
  			性别：<label><input name="sex" type="radio" value="男" />男 </label>&nbsp; 
  			<label><input name="sex" type="radio" value="女" />女 </label> 
  			年龄：<input type="text" name="age" id="age">
  			<input type="submit" value="查询" />   	  
    	  </form><br>
		  <table class="table table-hover">
		    <thead>
		      <tr>
		        <th>学号</th>
		        <th>姓名</th>
		        <th>性别</th>
		        <th>年龄</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach items="${requestScope.stuList}" var="stu">
		      	 <tr>
			        <td>${stu.id}</td>
			        <td>${stu.name}</td>
			        <td>${stu.sex}</td>
			        <td>${stu.age}</td>
			      </tr>
		      </c:forEach>      
		     </tbody>
		  </table>
		  <ul class="pagination justify-content-center">
		  <li class="page-item"><a class="page-link" href="${ctx}/student/selectStudent/${requestScope.page.pageIndex==1?requestScope.page.pageIndex:requestScope.page.pageIndex-1}">上一页</a></li>
		  <li class="page-item">&nbsp;&nbsp;跳转到第<input type="number" id="pageIndex">页&nbsp;&nbsp;</li>
		  <li class="page-item"><a class="page-link" href="${ctx}/student/selectStudent/${requestScope.page.pageIndex==requestScope.page.totalSize?requestScope.page.totalSize:requestScope.page.pageIndex+1}">下一页</a></li>
		  </ul>
		  <div class="center">
		  共&nbsp;${requestScope.page.recordCount}&nbsp;条数据&nbsp;&nbsp;
		  第&nbsp;${requestScope.page.pageIndex}&nbsp;页&nbsp;&nbsp;
		  共&nbsp;${requestScope.page.totalSize}&nbsp;页
		 </div>
    </div> 
  </div>
</div>
<input id="PageContext" type="hidden" value="${ctx}" />
<script>
$(function(){
	$("#pageIndex").bind('keypress',function(event){ 
        var index = $("#pageIndex").val();
        if(event.keyCode == 13) { 
        	if((index <= ${requestScope.page.totalSize}) && index >= 1){
        		window.location.href = $("#PageContext").val()+"/student/selectStudent/"+index;
        	}else{
        		alert("请输入正确的页码！");
        	}
        }  
    })
})
</script>
</body>
</html>