<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  </style>
</head>
<body>
<div class="container">
  <div class="card">
    <div class="card-header">当前位置：课程管理 > 我的课程 </div>
	    <div class="card-body">
	    	<form method="post" action="${ctx}/course/queryCourse/${sessionScope.user_session.id}" >
  			课程号：<input type="number" name="id" id="id">
  			名称：<input name="name" id="name">
  			学分：<input type="number" name="credit" id="credit">
  			学时：<input type="number" name="hour" id="hour">
  			 <input type="submit" value="查询" />   	  
    	  </form><br>
		  <table class="table table-hover">
		    <thead>
		      <tr>
		        <th>课程号</th>
		        <th>名称</th>
		        <th>学时</th>
		        <th>学分</th>
		        <th>简介</th>
		        <th>任课教师</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach items="${requestScope.stu.courses}" var="course">
		      	 <tr>
			        <td>${course.id}</td>
			        <td>${course.name}</td>
			        <td>${course.hour}</td>
			        <td>${course.credit}</td>
			        <td>${course.desc}</td>
			        <td>${course.teacher.name}</td>
			      </tr>
		      </c:forEach>      
		     </tbody>
		  </table>
	    </div>
    </div>
    </div>
</body>
</html>