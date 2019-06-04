<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" import="java.util.*" language="java" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head><style type="text/css">   
body{    
      background-image: url(<%=basePath %>/lyf/image/ubg.jpg);
      background-repeat: repeat-y;      
 }      
$(document).ready(function(){  
  $("#s1").(function(){  
       <span style="background-color: rgb(255, 204, 204);">
       });
       });
</style>    
    <title>用户列表</title>
    <link rel="stylesheet" href="<%=basePath %>/lyf/css/news.css">
</head>


<body>
<div class="container">  
      <h1><a onMouseOver = "this.style.color = 'red'"  style="color:#666666;" href="<%=request.getContextPath() %>/pu/pumain.do">666网站</a>  &nbsp;&nbsp;新闻板块</h1>  
      <table class="table" align="center" bgcolor="aqua" border="1px">
   <c:forEach items="${newsList}" var="l">
      <div class="news-list">       
        <div class="news-list-left"> 
          <div class="news-list-item">  
            <div class="author-time">                                
                 <span>${l.ausername}</span> 发表于 <span>${l.time}</span>
            </div>  
            <div class="news-des">  
              <h3 class="news-title">${l.title}</h3>  
              <div class="news-content-des">${l.content}</div>  
            </div>  
          </div>   
      </div>  
    </div>  
    </div>
    </c:forEach>
    </table>
</body>
</html>