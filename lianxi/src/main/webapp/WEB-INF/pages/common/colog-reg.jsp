<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="<%=request.getContextPath() %>/ywzs/css/style.css">

<link href="<%=request.getContextPath() %>/ywzs/css/Lato1.css" rel="stylesheet">
<link rel='stylesheet prefetch' href='<%=request.getContextPath() %>/ywzs/css/Icons.css'>
<script src="<%=request.getContextPath() %>/ywzs/js/jquery.min.js"></script>
<script language="javascript" src="<%=request.getContextPath() %>/ywzs/js/script.js">
</script>
</head>

<div style="text-align:center;margin:10px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>公司代表人要发布招聘信息先进行登录或注册企业账号</p>
<h4 style="font-weight:bold;">网站：<a href="<%=request.getContextPath() %>/main.do" target="_blank" style="color:red;text-decoration: none;">666招聘网</a></h4>
</div>
<div class="cotn_principal">
  <div class="cont_centrar">
    <div class="cont_login">
      <div class="cont_info_log_sign_up">
        <div class="col_md_login">
          <div class="cont_ba_opcitiy">
            <h2>登录</h2>
            <h3 style="color:red">${msg}</h3>
            <p>通过用户名登录系统</p>
            <button class="btn_login" onClick="cambiar_login()">Login</button>
          </div>
        </div>
        <div class="col_md_sign_up">
          <div class="cont_ba_opcitiy">
            <h2>免费注册</h2>
            <p>注册企业账号信息</p>
            <button class="btn_sign_up" onClick="cambiar_sign_up()">Register</button>
          </div>
        </div>
      </div>
      <div class="cont_back_info">
        <div class="cont_img_back_grey"> <img src="<%=request.getContextPath() %>/images/image/po1.jpg" alt="" /> </div>
      </div>
      <div class="cont_forms" >
        <div class="cont_img_back_"> <img src="<%=request.getContextPath() %>/images/image/po1.jpg" alt="" /> </div>
        <form action="<%=request.getContextPath() %>/company/colog.do" method="post" name="form1">
        <div class="cont_form_login"> <a href="#" onClick="ocultar_login_sign_up()" ><i class="material-icons">&#xE5C4;</i></a>
          <h2 style="color:blue;">登录</h2>
          <!-- <span style="color:red" id="divcusername1"></span> -->
         
          <input type="text" placeholder="Username(不能为空)" name="cusername" id="cusername" required="required" onblur="ajaxName()"/>
          <input type="password" placeholder="Password(不能为空)" name="password" id="password" required="required"/>
          <button class="btn_login" onClick="cambiar_login()" type="submit">登录</button>
        </div>
        </form>
        
        
        <form action="<%=request.getContextPath() %>/company/coreg.do" method="post" name="form2">
        <div class="cont_form_sign_up"> <a href="" onClick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
          <h2 style="color:blue;">免费注册</h2>
          <span id="divname" style='color:red'></span>
          <input type="text" placeholder="用户名由3-16个数字或字母组成" name="cusername" required="required"  id="cusername" onblur="validate()"/>
     
           <span class="tips" id="divcusername" style='color:red'></span>
          <input type="password" placeholder="密码由6-16个数字或字母组成" name="password" required="required" onblur="checkpass()"/>
          <span class="tips" id="divpassword" style='color:red'></span>
          <input type="password" placeholder="确认密码" name="repassword" required="required" onblur="checkrepass()"/>
          <span class="tips" id="divrepassword" style='color:red'></span>
          <input type="text" placeholder="公司名" id="cname" name="cname" required="required" onblur="checkcname()"/>
           <span class="tips" id="divcname1" style='color:red'></span>
           <br><span id="divcname" style='color:red'></span>
          <input type="text" placeholder="qq邮箱" name="email" required="required" onblur="checkemail()"/>
            <span class="tips" id="divemail" style='color:red'></span>
           <input type="text" placeholder="地址" name="address" required="required"/>
          <button class="btn_sign_up" onblur="checkAll()" type="submit">免费注册</button>
           </div> 
        </form>
      </div>
    </div>
  </div>
</div>

<script src="<%=request.getContextPath() %>/ywzs/js/index.js"></script>

</body>
</html>


