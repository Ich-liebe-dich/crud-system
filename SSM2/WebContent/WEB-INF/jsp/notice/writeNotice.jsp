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
    	<div class="card-header">当前位置：通知管理 > 写通知 </div>
    	<div class="card-body">
    	<form method="post" action="${ctx}/notice/submit" >
  			<div class="form-group">
  			  <input type="hidden" name="user_id" value="${sessionScope.user_session.id}"/>
  			  <label for="id">ID：</label>
		      <input type="number" name="receiver_id" id="id">
		      <label for="title">标题：</label>
		      <input name="title" id="title">
		      <label for="content">正文:</label>
		      <textarea class="form-control" rows="5" id="content" name="content"></textarea>
		    </div>
  			 <input type="submit" value="提交" />   	  
    	  </form><br>
		</div>
	</div>		  
</div>
</body>
</html>