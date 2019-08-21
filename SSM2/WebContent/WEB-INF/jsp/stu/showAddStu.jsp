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
    	<div class="card-header">当前位置：学生管理 > 添加学生 </div>
    	<div class="card-body">
		  <h2>添加学生</h2>
		      <form action="${ctx}/student/addStudent" method="post">
		      <input type="hidden" name="flag" value="2">
		        <div class="form-group">
		          <label for="id">学号:</label>
		          <input type="number" class="form-control" id="id" name="id" placeholder="请输入学号">
		        </div>
		        <div class="form-group">
		          <label for="name">姓名:</label>
		          <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
		        </div>
		         <div class="form-group">
		          <label for="password">密码:</label>
		          <input type="text" class="form-control" id="password" name="password" placeholder="请输入密码">
		        </div>
		        <div class="form-check">
		            性别：
		            <label class="form-check-label">
		                <input type="radio" id="optionsRadios1"  name="sex" value="男" checked> 男
		            </label>
		            <label class="form-check-label">
		                <input type="radio" id="optionsRadios2" name="sex" value="女">女
		            </label>
		        </div>
		        <div class="form-group">
		          <label for="age">年龄:</label>
		          <input type="number" class="form-control" id="age" name="age"  placeholder="请输入年龄">
		        </div>
		        <input type="submit" value="提交" />
		      </form>
		  </div>
	</div>
</div>

</body>
</html>