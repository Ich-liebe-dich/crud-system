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
    	<div class="card-header">当前位置：教师管理 > 修改教师 </div>
    	<div class="card-body">
		  <h2>修改教师</h2>
		  <form:form modelAttribute="teacher" method="post" action="${ctx}/teacher/updateTeacher/update">
		  	<table>
		  		<tr>
			  		<td>
			  			教师编号：
			  		</td>
			  		<td>
			  			<form:input path="id" readonly="true"/>
			  		</td>	
		  		</tr>
		  		<tr>
		  			<td>姓名：</td>
		  			<td><form:input path="name"/></td>
		  		</tr>
		  		<tr>
		  			<td>
		  				<form:radiobutton path="sex" value="男"/>男&nbsp;
		  				<form:radiobutton path="sex" value="女"/>女&nbsp;
		  			</td>
		  	    </tr>
		  		<tr><td><input type="submit" value="提交"/></td></tr>
		  	</table>
		  </form:form>    
		 </div>
	</div>
</div>

</body>
</html>