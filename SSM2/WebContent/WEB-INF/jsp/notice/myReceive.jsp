<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
 <script src="${ctx}/js/jquery.min.js"></script>
  <script src="${ctx}/js/popper.min.js" ></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
  <style>
  body {
  	margin-left: -10%;
  }
  .card {
  	margin-top: 10px;
  }
  </style>
</head>
<body>
<div class="container">
	<div class="card">
    	<div class="card-header">当前位置：通知管理 > 收件箱 </div>
    	<div class="card-body">
    	<form method="post" action="${ctx}/notice/queryNotice" >
  			发送人：<input type="number" name="id" id="id">
  			标题：<input name="name" id="name">
  			起始时间：<input type="number" name="credit" id="credit">
  			截止时间：<input type="number" name="hour" id="hour">
  			 <input type="submit" value="查询" />   	  
    	  </form><br>
    		<c:forEach items="${requestScope.notice}" var="notice" varStatus="i">
    		 <div class="card">
    			<div class="card-body">
    				<h4>${notice.title}</h4>
    				<hr>
    				<p>${notice.content}</p>
    				<p style="float:right;padding:10px"><fmt:formatDate value="${notice.date}" type="date" pattern="yyyy-MM-dd HH:mm:ss"/></p>
    			</div>
  			 </div>
  			 </c:forEach>
		</div>
	</div>		  
</div>
</body>
</html>