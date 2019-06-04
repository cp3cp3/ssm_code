<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理员登录页面</title>
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ywzs/css/default.css">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ywzs/css/styles.css">
</head>
<body>

<div class="panel-lite">
  <div class="thumbur">
	<div class="icon-lock"></div>
  </div>
  <form  action="<%=request.getContextPath() %>/admin/adlogin.do" method="post">
  <h4>管理登录</h4>
  <h3 style="color:red">${msg}</h3>
  <div class="form-group">
	<input type="text" required="required" class="form-control" name="ausername" id="ausername"/>
	<label class="form-label">Username    </label>
  </div>
  <div class="form-group">
	<input type="password" required="required" class="form-control" name="password" id="password"/>
	<label class="form-label">Password</label>
  </div><h3>666招聘网&nbsp;<a href="<%=request.getContextPath() %>/main.do"><li class="icon-arrow"></li> </a></h3>
  <button class="floating-btn" type="submit"><i class="icon-arrow"></i></button></form>
</div>

</body>
</html>
