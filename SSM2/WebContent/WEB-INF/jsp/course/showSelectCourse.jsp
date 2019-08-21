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
    <div class="card-header">当前位置：课程管理 > 课程查询 </div>
    <div class="card-body">
    		<a href="${ctx}/excel/course?name=course">导出</a>
    	  <form method="post" action="${ctx}/course/queryCourse/1" >
  			课程号：<input type="number" name="id" id="id">
  			名称：<input name="name" id="name">
  			学分：<input type="number" name="credit" id="credit">
  			学时：<input type="number" name="hour" id="hour">
  			 <input type="submit" value="查询" /> 
    	  </form><br>
    	  <button id="delete">删除</button>  	  
		  <table class="table table-hover">
		    <thead>
		      <tr>
		        <th>&nbsp;&nbsp;</th>
		        <th>课程号</th>
		        <th>名称</th>
		        <th>学时</th>
		        <th>学分</th>
		        <th>简介</th>
		        <th>任课教师</th>
		        <th>操作</th>
		      </tr>
		    </thead>
		    <tbody>
		      <c:forEach items="${requestScope.courseList}" var="course" varStatus="stat">
		      	 <tr>
		      	    <td> <input type="checkbox" id="box_${stat.index}" value="${course.id}"></td>
			        <td>${course.id}</td>
			        <td>${course.name}</td>
			        <td>${course.hour}</td>
			        <td>${course.credit}</td>
			        <td>${course.desc}</td>
			        <td>${course.teacher.name}</td>
			        <td><a href="${ctx}/course/updateCourse?id=${course.id}">修改</a></td>
			      </tr>
		      </c:forEach>      
		     </tbody>
		  </table>
		  <ul class="pagination justify-content-center">
		  <li class="page-item"><a class="page-link" href="${ctx}/course/selectCourse/${requestScope.page.pageIndex==1?requestScope.page.pageIndex:requestScope.page.pageIndex-1}">上一页</a></li>
		  <li class="page-item">&nbsp;&nbsp;跳转到第<input type="number" id="pageIndex">页&nbsp;&nbsp;</li>
		  <li class="page-item"><a class="page-link" href="${ctx}/course/selectCourse/${requestScope.page.pageIndex==requestScope.page.totalSize?requestScope.page.totalSize:requestScope.page.pageIndex+1}">下一页</a></li>
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
        		window.location.href = $("#PageContext").val()+"/course/selectCourse/"+index;
        	}else{
        		alert("请输入正确的页码！");
        	}
        }  
    })
})
$(function(){
	 	   /** 获取上一次选中的部门数据 */
	 	   var boxs  = $("input[type='checkbox'][id^='box_']");
	    	
	 	   /** 删除员工绑定点击事件 */
	 	   $("#delete").click(function(){
	 		   /** 获取到用户选中的复选框  */
	 		   var checkedBoxs = boxs.filter(":checked");
	 		   if(checkedBoxs.length < 1){
	 			  alert("请选择一个需要删除的用户！");
	 		   }else{
	 			   /** 得到用户选中的所有的需要删除的ids */
	 			   var ids = checkedBoxs.map(function(){
	 				   return this.value;
	 			   })
	 			   
	 			   if(confirm("删除后无法复原，确认删除吗？")){
 					   // 发送请求
 					   window.location =  $("#PageContext").val()+"/course/deleteCourse?ids=" + ids.get();
	 			   }
	 				   
	 		   }
	 	   })
	 })
	  
</script>
</body>
</html>