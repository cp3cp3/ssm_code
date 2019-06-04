<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css"  href="<%=request.getContextPath() %>/css/style.css" />
<link rel="apple-touch-icon-precomposed" href="http://www.17sucai.com/static/images/favicon.ico">
<script>
var logined = 0
</script>
<title>首页</title>
</head>

<body>
<script>
var now_page = 1,
search_value = '';
</script>

		<div id="menu">
		<div class="search_wrap">
			<form action="<%=request.getContextPath() %>/serchrecname.do" method="post">
				<input type="text" name="recname" class="search_input" placeholder="关键字查找职业" />
				<i class="reset_input"><i></i></i>
			</form>
		</div>
		<ul>
			<li class="nav_index menu_cur"><a href="<%=request.getContextPath() %>/main.do?pageNow=1"><i></i><span>首页</span><b></b><div class="clear"></div></a></li>
			<li class="nav_site"><a href=""><i></i><span>设计成员</span><b></b><div class="clear"></div></a></li>
			<li class="nav_about"><a href="<%=request.getContextPath() %>/admin/list1.do"><i></i><span>新闻版块</span><b></b><div class="clear"></div></a></li>
		</ul>
	</div>
		<div id="user">
					<div class="account">
				<div class="login_b_t">
					<div class="pd10">
						<div class="fl">还没有账号<a id="reg_now" href="<%=request.getContextPath() %>/pu/pureg.do">立即注册</a></div><div class="fr"><a>普通用户</a></div><div class="clear"></div>
					</div>
				</div>
			</div>
			<div class="pd10">
				<form method="post" action="<%=request.getContextPath() %>/pu/pulog.do">
					<div class="login_b_i">
						<div class="login_input">
							<div class="login_user"><input type="text" name="username" placeholder="用户名" required="required"/><i></i></div>
							<div class="login_password"><input type="password" name="password" placeholder="密码" required="required"/><i></i></div>
						</div>
					</div>
					<button class="login_submit" type="submit">登录</button>
				</form>
				<div class="login_quick">
					<p>用其他身份登录</p>
					<a href="<%=request.getContextPath() %>/admin/adlog.do" id="weibo_app"><span><i></i>管理员</span></a>
					<a href="<%=request.getContextPath() %>/company/colog-reg.do" id="qq_connect"><span><i></i>公司代表</span></a>
				</div>
			</div>
			</div>	
	<div id="header">
		<div class="wrap">
			<i class="menu_open"></i>
			<div class="logo"><a style="font-size:35px;" href="<%=request.getContextPath() %>/main.do" title="爱昵图库(Inpic)">666招聘网</a></div>
			<i class="search_open"></i>
		</div>
		<div class="logo_msk"></div>
	</div>
	<div id="container">
		<div id="sort">
			<table width="100%" border="0" cellspacing="0">
			</table>
		</div>
		<div id="content">	
			<div id="list">
			<c:if test="${!empty listr }">  
                <c:forEach items="${listr}" var="r">
				<ul>
										<li>
						<div class="wrap">
							<a class="alist" href="<%=request.getContextPath() %>/main.do" onClick="return confirm('您还没有登录，此投递简历权限只限于普通用户');">
								<div class="list_litpic fl"><img src="<%=request.getContextPath() %>/images/142013403687.gif" /></div>
								<div class="list_info">
									<h4>${r.recname } | <span style="color:red;">${r.extent }K</span></h4>
									<h5>${r.degree } | <span>${r.experience }年以上</span> | <span>${r.address }</span></h5>
									<div class="list_info_i">
											<dd>公司代表人:${r.cusername } <span>友情提示：点击即可提交简历</span></dd>
											<div class="clear"></div>
										<div class="clear"></div>
									</div>
								</div>
								<div class="clear"></div>
							</a>
						</div>
					</li>
										
									</ul></c:forEach></c:if><br>
									<center>
			<tr>
				<div>
				<font size="2">共 ${page.totalPageCount} 页</font><font size="2">
				第${page.pageNow}页&nbsp;&nbsp;
				<c:if test="${page.pageNow>1}"> 
					<a style="color:blue" onMouseOver = "this.style.color = 'red'"  href="<%=request.getContextPath() %>/main.do?pageNow=1">首页</a>
					
					</c:if>
				<c:if test="${page.pageNow-1>0}">
				 <a style="color:blue" onMouseOver = "this.style.color = 'red'"  href="<%=request.getContextPath() %>/main.do?pageNow=${page.pageNow-1}">上一页</a>
				  </c:if>
					
					<c:if test="${page.pageNow<page.totalPageCount}">
					
					 <a style="color:blue" onMouseOver = "this.style.color = 'red'"  href="<%=request.getContextPath() %>/main.do?pageNow=${page.pageNow+1}">下一页</a>
					
					<a style="color:blue" onMouseOver = "this.style.color = 'red'"  href="<%=request.getContextPath() %>/main.do?pageNow=${page.totalPageCount}">尾页</a>
					</c:if>
				</font>
				
				
				
				
				

			</tr>
		</center>
				<br><br>
			</div>
		</div>
		
		<div class="push_msk"></div>
	</div>

	
	
	
	<div class="loading_dark"></div>
	<div id="loading_mask">
		<div class="loading_mask">
			<ul class="anm">
				<li></li>
				<li></li>
				<li></li>
				<li></li>
				<li></li>
			</ul>
		</div>
	</div>
		
	<script language="javascript" src="<%=request.getContextPath() %>/js/zepto.min.js"></script>
	<script language="javascript" src="<%=request.getContextPath() %>/js/fx.js"></script>
	<script language="javascript" src="<%=request.getContextPath() %>/js/script.js"></script>
	
</body>
</html>