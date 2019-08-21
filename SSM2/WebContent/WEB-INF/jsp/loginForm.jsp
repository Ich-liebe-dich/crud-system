<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <!-- bootstrap 不支持IE的兼容模型，让IE运行最新的渲染模式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- 控制移动端浏览器视口的大小和缩放 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签必须放在最前面，任何其他内容都必须跟随其后！ -->
    <title>xx教务系统 | 登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://cdn.staticfile.org/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.staticfile.org/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.staticfile.org/twitter-bootstrap/4.1.0/js/bootstrap.min.js"></script>
<style>
      body{
            font-family: 'microsoft yahei',Arial,sans-serif;
            margin:0;
            padding:0;
           
        } 
       
    </style>
</head>
<body>
	  <!-- modal-dialog ：使悬浮框居中！ -->
             <div class="modal-dialog">
            	 <!-- <br> <br> <br> <br> <br> ：使悬浮框下移！ -->
                <br> <br> <br> <br> <br> 
                <!-- modal-content ：使悬浮框显现！ -->
                 <div class="modal-content">       
                    <div class="modal-header">
                        <h1 class="text-center text-primary">教务系统登录</h1>
                    </div>
                    <div class="modal-body">
                        <form id="fmlogin" class="form" action="${ctx}/login/check" method="post" >
                            <div class="form-group">
                                <input id="account" name="account"  required="required" type="number" class="form-control input-lg" value="${stu.id}" placeholder="登录账号" >
                            </div>
                            <div class="form-group">
                                <input name="password" required="required" type="password" class="form-control input-lg" placeholder="登录密码" >                       
                            </div>
                            <div class="form-check">
					            <label class="form-check-label">
					                <input type="radio" id="optionsRadios1"  name="role" value="student" checked="checked">我是学生
					            </label>
					            <label class="form-check-label">
					                <input type="radio" id="optionsRadios2" name="role" value="teacher">我是教师
					            </label>
					            <label class="form-check-label">
					                <input type="radio" id="optionsRadios3" name="role" value="admin">我是管理员
					            </label>
					        </div>
                            <div class="form-group">
                                <button id="btnlogin" type="submit" class="btn btn-primary btn-lg btn-block">登录</button>
                            </div>
                            <div class="text-center">
                           		<!-- 内联元素：span -->
                           		<span style="color:red;font-size:20px;" id="msg">${msg}</span>
                            </div>
                        </form>
                    </div>
                </div> 
           </div> 
<input type="hidden" id="ctx" value="${ctx}" />
</body>
<script>
$(function(){
	var ctx =  $("#ctx").val();
	var url = 'url('+ctx+'/images/bgcimg.jpg)';
	console.log(url);
	$("body").css("background",url);
	$("#account").focus(function(){
		$("#msg").html("");
	})
	
})
</script>
</html>