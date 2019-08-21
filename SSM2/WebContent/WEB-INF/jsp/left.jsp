<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
<!-- 

<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
 <script src="${ctx}/js/jquery.min.js"></script>
  <script src="${ctx}/js/popper.min.js" ></script>
<script src="${ctx}/js/bootstrap.min.js"></script>

-->
  <style type="text/css">
  	.child {
  		color: black;
  	}
  </style>
</head>
<body>
<%--  admin选择 --%>
<c:if test="${sessionScope.user_type eq 'admin' }">

<div class="container">
  <div id="accordion">
    <div class="card">
      <div class="card-header">
        <a class="card-link" data-toggle="collapse" href="#collapseOne">
          学生管理
        </a>
      </div>
      <div id="collapseOne" class="collapse show" data-parent="#accordion">
        <div class="card-body">
           <a class="nav-link child" href="student/selectStudent/1" target="main">学生查询</a>
    		<a class="nav-link child" href="student/addStudent?flag=1" target="main">添加学生</a>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseTwo">
        课程管理
      </a>
      </div>
      <div id="collapseTwo" class="collapse" data-parent="#accordion">
        <div class="card-body">
          <a class="nav-link child" href="course/selectCourse/1" target="main">课程查询</a>
    	  <a class="nav-link child" href="course/addCourse?flag=1" target="main">添加课程</a>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
          教师管理
        </a>
      </div>
      <div id="collapseThree" class="collapse" data-parent="#accordion">
        <div class="card-body">
          <a class="nav-link child" href="teacher/selectTeacher/1" target="main">教师查询</a>
    	  <a class="nav-link child" href="teacher/addTeacher?flag=1" target="main">添加教师</a>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseFour">
              通知管理
        </a>
      </div>
      <div id="collapseFour" class="collapse" data-parent="#accordion">
            <div class="card-body">
     		 	<a class="nav-link child" href="${ctx}/notice/myReceive/${sessionScope.user_session.id}" target="main">收件箱</a>
 	  			<a class="nav-link child" href="${ctx}/notice/myWrite/${sessionScope.user_session.id}" target="main">已发送</a>
 	  			<a class="nav-link child" href="${ctx}/notice/writeNotice" target="main">写通知（</a>	
        	</div>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" target="_top" href="${ctx}/login/exit">
              退出
        </a>
      </div>
    </div>
  </div>


</c:if>

<%--  teacher选择 --%>
<c:if test="${sessionScope.user_type eq 'teacher' }">
<div class="container">
  <div id="accordion">
    <div class="card">
      <div class="card-header">
        <a class="card-link" data-toggle="collapse" href="#collapseOne">
            个人信息
        </a>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
        我的课程
      </a>
      </div>
      <div id="collapseThree" class="collapse" data-parent="#accordion">
        <div class="card-body">
          <a class="nav-link child" href="course/selectCourse" target="main">我的课程</a>
    	  <a class="nav-link child" href="course/addCourse?flag=1" target="main">新增课程</a>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseFour">
          我的通知
        </a>
      </div>
      <div id="collapseThree" class="collapse" data-parent="#accordion">
      	<div class="card-body">
          <a class="nav-link child" href="course/selectCourse" target="main">我的通知</a>
    	  <a class="nav-link child" href="course/addCourse?flag=1" target="main">发布通知</a>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" target="_top"  href="${ctx}/login/exit">
              退出
        </a>
      </div>
    </div>
  </div>
</div>

</c:if>

<%--  student选择 --%>
<c:if test="${sessionScope.user_type eq 'student' }">
<div class="container">
  <div id="accordion">
    <div class="card">
      <div class="card-header">
        <a class="card-link"  href="${ctx}/student/info/${sessionScope.user_session.id}" target="main">
            个人信息
        </a>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" data-toggle="collapse" href="#collapseThree">
        我的课程
      </a>
      </div>
      <div id="collapseThree" class="collapse" data-parent="#accordion">
        <div class="card-body">
          <a class="nav-link child" href="${ctx}/student/myCourse/${sessionScope.user_session.id}" target="main">已选课程查询</a>
        </div>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" href="${ctx}/notice/myReceive/${sessionScope.user_session.id}" target="main">
          我的通知
        </a>
      </div>
    </div>
    <div class="card">
      <div class="card-header">
        <a class="collapsed card-link" target='_top' href="login/exit" >
              退出
        </a>
      </div>
    </div>
  </div>
</div>
<script>
</script>
</c:if>

</body>
</html>