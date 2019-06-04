<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>填写个人简历</title>

</head>
<body>
<form action="<%=request.getContextPath() %>/pu/submitgrjl.do" method="post">
<table  border=5  bordercolor=red align=center>
<tr height=70 bgcolor=green align='center'>
<td width=720 colspan=6 align=center
><font size=5 ><b><a style="text-decoration: none;">个人简历
</a></b></font></td>
</tr>
<tr height=50 bgcolor=green>
<td width=110 align=center><font size=5>接收人：</td>
<td width=150 align=center><font size=5><input readonly="readonly" style="height: 50px;font-size:20px;" type="text" name="cusername" value="${msg}"></td>
<td width=110 align=center><font size=4>本人用户名：</td>
<td width=150 align=center><font size=5><input readonly="readonly" style="height: 50px;font-size:20px;" type="text" name="username" value="${sessionScope.username}"></td>
<td width=200 colspan=2 rowspan=4><img src="<%=request.getContextPath() %>/images/lizhi.jpg" alt="孙海洋照片" width=200 height=200></td>
 </tr>
<tr height=50 bgcolor=green>
<td width=110 align=center><font size=4 align=center>真实姓名：</td>
<td width=150 align=center><font size=5><input style="height: 50px;font-size:20px;" type="text" name="uname" required="required"  value=""></td>
<td width=110 align=center><font size=5>性别：</td>
<td width=150 align=center><font size=5>  <input type="radio" name="sex" value="男"/>男
     &nbsp;&nbsp; <input type="radio" name="sex" value="女"/>女</p></td>
</tr>

<tr height=50 bgcolor=green>
<td width=110 align=center><font size=5>学历：</td>
<td width=150 align=center><font size=5 align=center><input style="height: 50px;font-size:20px;" type="text" required="required" name="degree" value=""></td>
<td width=110 align=center><font size=4>求职岗位：</td>
<td width=150 align=center><font size=4><input readonly="readonly" style="height: 50px;font-size:20px;" type="text" name="skill" value="${msg1}"></td>
</tr>

<tr height=50 bgcolor=green>
<td width=110 align=center><font size=5>经验：</td>
<td width=150 align=center><font size=4><input style="height: 50px;font-size:20px;" type="text" name="experience" required="required" placeholder="只填数字(*年以上)" value=""></td>
<td width=110 align=center><font size=4>邮箱：</td>
<td width=150 align=center><font size=3><input style="height: 50px;font-size:20px;" type="text" name="email" required="required" value=""></td>
</tr>





<tr height=50 bgcolor=green>
<td width=720 colspan=6 align=center><font size=5>自我评价</td>
</tr>

<tr height=50 bgcolor=green>
<td width=720  colspan=6><input style="width:1015px;height: 50px;font-size:20px;" type="text" required="required" name="appraise" value="">
</td>
</tr>

<tr height=50 bgcolor=green>
<td width=720 colspan=6><button style="width:1020px;height: 50px;font-size:20px;" type="submit">提交个人简历</button></td>
</tr>
</table></form>
 
<center>
<h3><a href="<%=request.getContextPath() %>/pu/pumain.do" target="_blank"  style="text-decoration: none;">放弃填写</a></h3>
 </center>
 
 
</body>
</html>