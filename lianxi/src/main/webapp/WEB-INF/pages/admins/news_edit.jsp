<%@ page language="java" contentType="text/html;  charset=utf-8" isELIgnored="false"  pageEncoding="utf-8"%>
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
    <title>网站信息</title>  
    <link rel="stylesheet" href="<%=basePath %>/lyf/css/pintuer.css">
    <link rel="stylesheet" href="<%=basePath %>/lyf/css/admin.css">
    <script src="<%=basePath %>/lyf/js/jquery.js"></script>
    <script src="<%=basePath %>/lyf/js/pintuer.js"></script>  
</head>
<body>
<div class="panel admin-panel">
  <div class="panel-head"><strong><a href="<%=request.getContextPath() %>/admin/admain.do">666招聘网</a>&nbsp;&nbsp;<span class="icon-pencil-square-o"></span> 新闻信息修改</strong></div>
  <div class="body-content">
    <form method="post" class="form-x" action="<%=basePath %>/admin/update.do">
    
     <div class="form-group">
        <div class="label">
          <label>编号：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="nid" value="${newsList.nid}" readonly="true" required/>
          <div class="tips"></div>
        </div>
      </div>
    
      <div class="form-group">
        <div class="label">
          <label>管理员名称：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="ausername" value="${newsList.ausername}" readonly="true" required/>
          <div class="tips"></div>
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label>标题：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="title" value="${newsList.title}" required/>
          <div class="tips"></div>
        </div>
      </div>
      
      <div class="form-group">
        <div class="label">
          <label>新闻内容：</label>
        </div>
        <div class="field">
          <input type="text" class="input" name="content" value="${newsList.content}" required/>
          <div class="tips"></div>
        </div>
      </div>
      
       <div class="form-group">
        <div class="label">
          <label>日期：</label>
        </div>
        <div class="field">
          <input type="date" class="input" name="time" value="${newsList.time}" required/>
          <div class="tips"></div>
        </div>
      </div>
      
      
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
        </div>
      </div>
    </form>
  </div>
</div>
          <input type="hidden" class="input" id="message" value="${message}" />
</body></html>


			