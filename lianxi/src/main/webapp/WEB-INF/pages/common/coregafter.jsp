<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta http-equiv="Refresh" content="5;URL=colog-reg.do" />
<title>公司注册结果</title>
</head>
<style>
a {
	text-decoration: none;
}</style>
<body>
<center>
 <h2 style="color:red">${msg}</h2>
 <h3>若5秒后页面没有返回登录注册页面，请点击 
 <a  onMouseOver = "this.style.color = 'red'" 
 onMouseOut = "this.style.color = ''" href="<%=request.getContextPath() %>/company/colog-reg.do">登录注册</a></h3>
</center>
</body>
</html>