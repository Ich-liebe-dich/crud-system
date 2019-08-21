<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
 <script src="${ctx}/js/jquery.min.js"></script>
  <script src="${ctx}/js/popper.min.js" ></script>
<script src="${ctx}/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
  <div class="card">
    <div class="card-header">当前位置：学生管理 > 学生查询 </div>
    <div class="card-body">
        <h2>${stu.name}</h2>
        <p>学号：${stu.id}</p>
        <p>性别：${stu.sex}</p>
        <p>年龄：${stu.age}</p>
    </div>
  </div>
</div>
</body>
</html>