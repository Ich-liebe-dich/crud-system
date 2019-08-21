<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    	<div class="card-header">当前位置：学生管理 > 修改学生 </div>
    	<div class="card-body">
		  <h2>修改学生</h2>
		  <form:form modelAttribute="course" method="post" action="${ctx}/course/updateCourse/update">
		  	<table>
		  		<tr>
			  		<td>
			  			课程编号：
			  		</td>
			  		<td>
			  			<form:input path="id" readonly="true"/>
			  		</td>	
		  		</tr>
		  		<tr>
		  			<td>课程名：</td>
		  			<td><form:input path="name"/></td>
		  		</tr>
		  		<tr>
		  			<td>学时：</td>
		  			<td><form:input path="hour"/></td>
		  	    </tr>
		  	    <tr>
		  			<td>学分：</td>
		  			<td><form:input path="credit"/></td>
		  		</tr>
		  		<tr>
		  			<td>简介：</td>
		  			<td><form:input path="desc"/></td>
		  		</tr>
		  		<tr>
		  			<td>备注：</td>
		  			<td><form:input path="remark"/></td>
		  		</tr>
		  		<tr>
		  			<td>容量：</td>
		  			<td><form:input path="capacity" /></td>
		  		</tr>
		  		<tr><td><input type="submit" value="提交"/></td></tr>
		  	</table>
		  </form:form>    
		 </div>
	</div>
</div>

</body>
</html>