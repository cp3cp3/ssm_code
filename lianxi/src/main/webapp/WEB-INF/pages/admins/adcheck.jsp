<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/style.css" />
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
			<form action="" method="post">
				<input type="text" name="search" class="search_input" placeholder="关键字查找职业或公司" />
				<i class="reset_input"><i></i></i>
			</form>
		</div>
		<ul>
			<li class="nav_index menu_cur"><a href=""><i></i><span>首页</span><b></b><div class="clear"></div></a></li>
			<li class="nav_site"><a href="<%=request.getContextPath() %>/admin/updateausername.do"><i></i><span>修改个人信息</span><b></b><div class="clear"></div></a></li>
			<li class="nav_about"><a href="<%=request.getContextPath() %>/admin/checkcname.do?pageNow=1"><i></i><span>待审核公司</span><b></b><div class="clear"></div></a></li>
			<li class="nav_about"><a href="<%=request.getContextPath() %>/admin/newsadd.do"><i></i><span>发布新闻</span><b></b><div class="clear"></div></a></li>
			<li class="nav_about"><a href="<%=request.getContextPath() %>/admin/list.do"><i></i><span>查看新闻</span><b></b><div class="clear"></div></a></li>
			
		</ul>
	</div><div style="float:right;width:250px;height:18px">
	<p>欢迎管理员:${sessionScope.username}</p></div>
		<div id="user">
					<div class="account">
				<div class="login_b_t">
					<div class="pd10">
						<div class="fl"><a id="reg_now" href="<%=request.getContextPath() %>/admin/quitadmin.do">退出网站</a></div><div class="fr"><a>管理员</a></div><div class="clear"></div>
					</div>
				</div>
			</div>
			<div class="pd10">
			</div>
			</div>	
	<div id="header">
		<div class="wrap">
			<i class="menu_open"></i>
			<div class="logo"><a style="font-size:35px;" href="<%=request.getContextPath() %>/admin/admain.do" title="爱昵图库(Inpic)">666招聘网</a></div>
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
							<div class="sort_b"><a href="<%=request.getContextPath() %>/admin/admain.do"><div class="sort_b_inner"><i class="cate_default"></i><span>首页</span><div class="clear"></div></div></a></div>
						</div>
					</td>
					<td>
						<div class="sort_sort">
							<div class="sort_b"><a href="#" onclick="return false;"><div class="sort_b_inner"><i class="cate_sort"></i><span>普通用户</span><div class="clear"></div></div></a></div>
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
		
		<table id="table">
	<thead>
		<tr>
			<th>待审核</th>
			<th>用户名</th>
			<th>公司名</th>
			<th>邮箱</th>
			<th>地址</th>
		</tr>
	</thead>
	<c:if test="${!empty listc }">  
                <c:forEach items="${listc}" var="co">
                
	<tbody>
	<td><a href="<%=request.getContextPath() %>/admin/checksubmit.do?cusername=${co.cusername}" style="font-weight:bold;font-size:20px;color:blue;">审核</a></td>
      <td>${co.cusername}</td>
      <td>${co.cname}</td>
      <td>${co.email}</td>
      <td>${co.address}</td>
	</tbody>
	</c:forEach></c:if>
</table>
		<center>
			<tr>
				<div>
				<font size="2">共 ${page.totalPageCount} 页</font><font size="2">
				第${page.pageNow}页&nbsp;&nbsp;
				<c:if test="${page.pageNow>1}"> 
					<a style="color:blue" onMouseOver = "this.style.color = 'red'"  href="<%=request.getContextPath() %>/admin/checkcname.do?pageNow=1">首页</a>
					
					</c:if>
				<c:if test="${page.pageNow-1>0}">
				 <a style="color:blue" onMouseOver = "this.style.color = 'red'"  href="<%=request.getContextPath() %>/admin/checkcname.do?pageNow=${page.pageNow-1}">上一页</a>
				  </c:if>
					
					<c:if test="${page.pageNow<page.totalPageCount}">
					
					 <a style="color:blue" onMouseOver = "this.style.color = 'red'"  href="<%=request.getContextPath() %>/admin/checkcname.do?pageNow=${page.pageNow+1}">下一页</a>
					
					<a style="color:blue" onMouseOver = "this.style.color = 'red'"  href="<%=request.getContextPath() %>/admin/checkcname.do?pageNow=${page.totalPageCount}">尾页</a>
					</c:if>
				</font>
				
				
				
				
				</div>

			</tr>
		</center>


		<div id="sort_content">
		<div class="asort">
			
		</div>
				
		<div class="asort">
			<div class="hd">
				<div class="wrap">
					<div class="fl"><span>普通用户</span><div class="clear"></div></div>
					<div class="fr"></div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="ct">
				<div class="wrap">
					<ul class="choose_sort">
													<a href="<%=request.getContextPath() %>/admin/findAllperson.do" style="color:red"><li s_data="rec"><i class="s"></i><span>普通用户简历</span><i class="e"></i></li></a>
													<a href="" style="color:red"><li s_data="like"><i class="s"></i><span>普通用户信息</span><i class="e"></i></li></a>
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
												<a href="<%=request.getContextPath() %>/page/pagead.do?pageNow=1" style="color:red"><li t_data=""><i></i><span>公司招聘信息</span><i class="e"></i></li></a>
												<a href="" style="color:red"><li t_data="1"><i></i><span>公司代表人信息</span><i class="e"></i></li></a>
												
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
<style>
* { margin: 0; padding: 0; }
body { font-family: 'Microsoft Yahei'; font-size: 18px; background-color: #f8f8f8; }

#table {
  width: 1200px;
  margin: 40px auto 0;
  border-collapse: collapse;
  background-color: #fff;
}
#table td,
#table th {
  padding: 0.75em 1.5em;
}
#table thead {
  color: #fff;
  background-color: #31bc86;
}
#table thead th {
  text-align: left;
}
#table tbody {}
#table tbody tr {
  border-bottom: 2px dashed #000;
  cursor: default;
  transition: all .125s ease-in-out;
}
#table tbody tr:hover {
  /*background-color: rgba(129,208,177,.3);*/
}
#table tbody tr.event-bgColor {
  background-color: rgba(255, 192, 203, .2);
}
#table tbody tr.default-bgColor {
  background-color: #fff;
}
#table tbody tr.hover-bgColor {
  background-color: rgba(255, 192, 203, .8);
}
#table tbody tr.selected-bgColor {
  background-color: rgb(255, 192, 203);
}
input {
  width: 16px;
  height: 16px;
}
#selectAll {
  margin-left: -4px;
}
.checkbox {
  -webkit-user-select: none;
  -moz-user-select: none;
  -ms-user-select: none;
  -o-user-select: none;
  user-select: none;
}
</style>

</html>