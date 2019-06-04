<%@ page language="java" isELIgnored="false" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<meta name="renderer" content="webkit">
<title></title>
<link rel="stylesheet" href="<%=basePath %>/lyf/css/pintuer.css">
<link rel="stylesheet" href="<%=basePath %>/lyf/css/admin.css">
<script src="<%=basePath %>/lyf/js/jquery.js"></script>
<script src="<%=basePath %>/lyf/js/pintuer.js"></script>
		
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><a href="<%=request.getContextPath() %>/admin/admain.do">666招聘网</a> </strong></div>
  <div class="padding border-bottom">
  </div>
  <table id="dg" class="table table-hover text-center">
    <tr>
      <th width="4%">编号</th>
      <th width="8%">管理员名称</th>
      <th width="15%">标题</th>
      <th >内容</th>
      <th width="10%">发布时间</th>
      <th width="4%">状态</th>
      <th width="20%">操作</th>
    </tr>
    <c:forEach items="${newsList}" var="l">
		<tr>
      		<td>${l.nid}</td>
			<td>${l.ausername}</td>
			<td>${l.title}</td>
			<td>${l.content}</td>
			<td>${l.time}</td>
            <td>${l.nstate}</td>
      		<td>     		
      		<div class="button-group">       		
      		<a class="button border-main" href="<%=basePath %>admin/nid.do?nid=${l.nid}"><span class="icon-edit"></span> 修改</a>     
      		<a class="button border-main" href="<%=basePath %>/admin/edit.do?nid=${l.nid}&nstate=${l.nstate}"><span class="icon-edit"></span>注销</a> 		
      		<a class="button border-red" href="<%=basePath %>/admin/delete.do?nid=${l.nid}" onclick="return del(1,2)"><span class="icon-trash-o"></span> 删除</a>
      		 </div>
      		</td>
    	   	</tr>
	</c:forEach>    
  </table>
  <form class="text-center">
   <label class="button border-red">第${page.pageNow}页 </label> 
   <a class="button bg-yellow" href="<%=basePath %>/admin/list.do?pageNow=1">首页</a> <!-- onclick="return checkFirst()"  onclick="return checkNext()" -->
   <a class="button bg-red" href="<%=basePath %>/admin/list.do?pageNow=${page.pageNow-1}" >上一页</a> 
   <a class="button bg-red" href="<%=basePath %>/admin/list.do?pageNow=${page.pageNow+1}" >下一页</a> 
   <a class="button bg-yellow" href="<%=basePath %>/admin/list.do?pageNow=${page.totalPageCount}">尾页</a>
</div>
</form>

          <input type="hidden" class="input" id="message" value="${message}" />
</body></html>


           <script>
			if(document.getElementById("message").value!=null&&document.getElementById("message").value!=""){

				alert(document.getElementById("message").value);
			}
			</script>
			<%
				request.setAttribute("message",null);
			%>

 