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
    	<div class="card-header">当前位置：课程管理 > 添加课程 </div>
    	<div class="card-body">
		  <h2>添加课程</h2>
		      <form action="${ctx}/course/addCourse" method="post">
		      <input type="hidden" name="flag" value="2">
		        <div class="form-group">
		          <label for="id">课程号:</label>
		          <input type="number" class="form-control" id="id" name="id" placeholder="请输入课程号">
		        </div>
		        <div class="form-group">
		          <label for="name">课程名:</label>
		          <input type="text" class="form-control" id="name" name="name" placeholder="请输入课程名称">
		        </div>
		       <div class="form-group">
		          <label for="hour">学时：</label>
		          <input type="number" class="form-control" id="hour" name="hour" placeholder="请输入学时">
		        </div>
		        <div class="form-group">
		          <label for="credit">学分:</label>
		          <input type="number" class="form-control" id="credit" name="credit" placeholder="请输入学分">
		        </div>
		         <div class="form-group">
		          <label for="desc">简介：</label>
		          <input type="text" class="form-control" id="desc" name="desc" placeholder="请输入简介" >
		        </div>
		        <div class="form-group">
		          <label for="remark">备注:</label>
		          <input type="text" class="form-control" id="remark" name="remark" placeholder="请输入备注" >
		        </div>
		        <div class="form-group">
		          <label for="capacity">课程容量</label>
		          <input type="number" class="form-control" id="capacity" name="capacity" placeholder="请输入课程容量">
		        </div>
		        <input type="submit" value="提交" />
		      </form>
		  </div>
	</div>
</div>

</body>
</html>