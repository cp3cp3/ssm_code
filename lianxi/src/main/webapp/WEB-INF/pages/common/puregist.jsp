<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>普通用户注册页面</title>
 <link rel="stylesheet" href="<%=request.getContextPath() %>/css/normalize.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/css/styleregist.css">

</head>
<body>
<div class="reg_div">
    <p>用户注册</p><form action="<%=request.getContextPath() %>/pu/puregist.do" name="form" method="post">
    <ul class="reg_ul">
      <li>
          <span>用户名：</span>
          <input type="text" name="username" value="" placeholder="3-16数字或字母" class="reg_user" onblur="ajaxUsername()">
          <span class="tip user_hint"></span><br><span id="divusername" style="color:red;"></span>
      </li>
      <li>
          <span>密码：</span>
          <input type="password" name="password" value="" placeholder="6-16位密码" class="reg_password" >
          <span class="tip password_hint"></span>
      </li>
      <li>
          <span>确认密码：</span>
          <input type="password" name="repassword" value="" placeholder="确认密码" class="reg_confirm">
          <span class="tip confirm_hint"></span>
      </li>
      <li>
          <span>邮箱：</span>
          <input type="text" name="email" value="" placeholder="邮箱" class="reg_email" onblur="ajaxEmail()">
          <span class="tip email_hint"></span><br><span id="divuseremail" style="color:red;"></span>
      </li>
      
      <li>
        <button type="submit" name="button" class="red_button">注册</button>
      </li>
    </ul></form>
  </div>
  
  <script type="text/javascript">
  function ajaxUsername(){
	  var params=form.username.value;
	  $.ajax({
			url:"ajaxUsername.do",
			data:"username="+params,
			dataType:"text",
			type:"post",
			success:function(data){
			     if(data=="success"){
			    	 
			    	 divusername.innerHTML='<font class="tips_true">该昵称可用</font>';
			    	
			    	
			    }else{
			    	
			    	divusername.innerHTML='<font class="tips_true">该昵称不可用</font>';
			    	
			    	
			     }
			}
		});
  }
  
  function ajaxEmail(){
	  var params=form.email.value;
	  $.ajax({
			url:"ajaxEmail.do",
			data:"email="+params,
			dataType:"text",
			type:"post",
			success:function(data){
			     if(data=="success"){
			    	 
			    	 divuseremail.innerHTML='<font class="tips_true">该邮箱可用</font>';
			    	
			    	
			    }else{
			    	
			    	divuseremail.innerHTML='<font class="tips_true">邮箱已被注册</font>';
			    	
			    	
			     }
			}
		});
  }
  </script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.mins.js"></script>
  <script type="text/javascript" src="<%=request.getContextPath() %>/js/scripts.js"></script>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p style="color:blue;font-size:20px;">这个是拥有一切工作岗位的招聘网站</p>
<p style="color:blue;font-size:20px;">那就是：<a href="<%=request.getContextPath() %>/main.do" target="_blank" style="color:red;">666招聘网</a></p>


</body>
</html>