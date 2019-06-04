<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
			<form action="<%=request.getContextPath() %>/pu/searchrecname.do" method="post">
				<input type="text" name="recname" class="search_input" placeholder="关键字查找职业" />
				<i class="reset_input"><i></i></i>
			</form>
		</div>
		<ul>
			<li class="nav_index menu_cur"><a href="<%=request.getContextPath() %>/pu/pumain.do""><i></i><span>首页</span><b></b><div class="clear"></div></a></li>
			<li class="nav_site"><a href="<%=request.getContextPath() %>/pu/updateusername.do"><i></i><span>修改个人信息</span><b></b><div class="clear"></div></a></li>
			<li class="nav_about"><a href=""><i></i><span>已投简历</span><b></b><div class="clear"></div></a></li>
			
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
							<div class="sort_b"><a href="#" onclick="return false;"><div class="sort_b_inner"><i class="cate_tag"></i><span>公司</span><div class="clear"></div></div></a></div>
						</div>
					</td>
				</tr>
			</table>
		</div>
		<div id="content">	
			<div id="list">
			<c:if test="${!empty listr }">  
                <c:forEach items="${listr}" var="r">
				<ul>
										<li>
						<div class="wrap">
							<a class="alist" href="<%=request.getContextPath() %>/pu/grjl.do?cusername=${r.cusername}&recname=${r.recname}">
								<div class="list_litpic fl"><img src="<%=request.getContextPath() %>/images/142013403687.gif" /></div>
								<div class="list_info">
									<h4>${r.recname } | <span style="color:red;">${r.extent }K</h4>
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
											</ul></c:forEach></c:if>
											<center>
			<tr>
				<div>
				<font size="2">共 ${page.totalPageCount} 页</font><font size="2">
				第${page.pageNow}页&nbsp;&nbsp;
				<c:if test="${page.pageNow>1}"> 
					<a style="color:blue" onMouseOver = "this.style.color = 'red'"  href="<%=request.getContextPath() %>/pu/searchrecname.do?pageNow=1&recname=${recname}">首页</a>
					
					</c:if>
				<c:if test="${page.pageNow-1>0}">
				 <a style="color:blue" onMouseOver = "this.style.color = 'red'"  href="<%=request.getContextPath() %>/pu/searchrecname.do?pageNow=${page.pageNow-1}&recname=${recname}">上一页</a>
				  </c:if>
					
					<c:if test="${page.pageNow<page.totalPageCount}">
					
					 <a style="color:blue" onMouseOver = "this.style.color = 'red'"  href="<%=request.getContextPath() %>/pu/searchrecname.do?pageNow=${page.pageNow+1}&recname=${recname}">下一页</a>
					
					<a style="color:blue" onMouseOver = "this.style.color = 'red'"  href="<%=request.getContextPath() %>/pu/searchrecname.do?pageNow=${page.totalPageCount}&recname=${recname}">尾页</a>
					</c:if>
				</font>
				
			</tr>
		</center>
				<br><br>
				
			</div>
		</div>
		
		
		<div class="push_msk"></div>
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
													<a style="color:red"><li s_data="rec"><i class="s"></i><span>关于我们</span><i class="e"></i></li></a>
													
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