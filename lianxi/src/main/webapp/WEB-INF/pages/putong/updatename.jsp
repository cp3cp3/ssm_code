<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css" />
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/ywzs/css/upname.css" />
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
			<form action="<%=request.getContextPath() %>/pu/searchrecname.do" method="post">
				<input type="text" name="recname" class="search_input" placeholder="关键字查找职业或公司" />
				<i class="reset_input"><i></i></i>
			</form>
		</div>
		<ul>
			<li class="nav_index menu_cur"><a href="<%=request.getContextPath() %>/pu/pumain.do"><i></i><span>首页</span><b></b><div class="clear"></div></a></li>
			<li class="nav_site"><a href="<%=request.getContextPath() %>/pu/updateusername.do"><i></i><span>修改个人信息</span><b></b><div class="clear"></div></a></li>
			<li class="nav_about"><a href=""><i></i><span>简历通知</span><b></b><div class="clear"></div></a></li>
			
		</ul>
	</div><div style="float:right;width:250px;height:18px">
	<p>欢迎用户:${sessionScope.username}</p></div>
		<div id="user">
					<div class="account">
				<div class="login_b_t">
					<div class="pd10">
						<div class="fl"><a id="reg_now" href="<%=request.getContextPath() %>/pu/quitpu.do" >退出网站</a></div><div class="fr"><a>普通用户</a></div><div class="clear"></div>
					</div>
				</div>
			</div>
			<div class="pd10">
			</div>
			</div>	
	<div id="header">
		<div class="wrap">
			<i class="menu_open"></i>
			<div class="logo"><a style="font-size:35px;" href="<%=request.getContextPath() %>/pu/pumain.do" title="爱昵图库(Inpic)">666招聘网</a></div>
			<i class="search_open"></i>
		</div>
		<div class="logo_msk"></div>
	</div>
	<div id="container">
		<div id="sort">
			<table width="100%" border="0" cellspacing="0">
				<tr>
					<td class="sort_left">
						<div class="sort_cate">
							<div class="sort_b"><a href="<%=request.getContextPath() %>/pu/pumain.do"><div class="sort_b_inner"><i class="cate_default"></i><span>首页</span><div class="clear"></div></div></a></div>
						</div>
					</td>
					<td>
						<div class="sort_sort">
							<div class="sort_b"><a href="#" onclick="return false;"><div class="sort_b_inner"><i class="cate_sort"></i><span>新闻中心</span><div class="clear"></div></div></a></div>
						</div>
					</td>
					<td class="sort_right">
						<div class="sort_tag">
							<div class="sort_b"><a href="" onclick="return false;"><div class="sort_b_inner"><i class="cate_tag"></i><span>公司</span><div class="clear"></div></div></a></div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		
		 <div class='row'>
  <form  action="<%=request.getContextPath() %>/pu/updatesubmit.do" method="post">
    <label>
      <input type="text" readonly="readonly" value="${username}" name="username">
      <span>用户</span>
    </label>
    <label>
      <input type="password" value="${password}" name="password">
      <span>密码</span>
    </label>
    <label>
      <input type="text" value="${email}" name="email">
      <span>邮箱</span>
    </label>
    <br><br><br><br><br><br><br><br><br><br><br>
    <input value="提交" type="submit">&nbsp;&nbsp;&nbsp;   
    </form>
  </div>
  
 </div>
  
	<div id="sort_content">
		<div class="asort">
			
		</div>
				
		<div class="asort">
			<div class="hd">
				<div class="wrap">
					<div class="fl"><span>新闻中心</span><div class="clear"></div></div>
					<div class="fr"></div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="ct">
				<div class="wrap">
					<ul class="choose_sort">
													<a href="<%=request.getContextPath() %>/pu/list1.do" style="color:red"><li s_data="rec"><i class="s"></i><span>新闻</span><i class="e"></i></li></a>
													<a href="" style="color:red"><li s_data="rec"><i class="s"></i><span>关于我们</span><i class="e"></i></li></a>
													
											</ul>
					<div class="clear"></div>
				</div>
			</div>
		</div>

		<div class="asort">
			<div class="hd">
				<div class="wrap">
					<div class="fl"><i></i><span>公司</span><div class="clear"></div></div>
					<div class="fr"></div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="ct">
				<div class="wrap">
					<!--<h4 class="cate_trade"><i></i><span>行业</span></h4>-->
					<ul>
												<a href="<%=request.getContextPath() %>/pu/pumain.do" style="color:red"><li t_data=""><i></i><span>公司招聘信息</span><i class="e"></i></li></a>
												
												
											</ul>
					<div class="clear"></div>
				</div>
			</div>
		</div>
		
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