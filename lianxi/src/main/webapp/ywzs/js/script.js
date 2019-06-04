var user_Boolean = false;
var password_Boolean = false;
var repassword_Boolean = false;
var emaile_Boolean = false;
var cuser_Boolean=false;
function checkpass(){
	var na=form2.password.value;
    reg=/^[a-zA-Z0-9_]+$/;     
	   if(!reg.test(na))  
	{  	
		divpassword.innerHTML='<font class="tips_false">×</font>';
		password_Boolean = false;
	}else{  
	    if( na.length <6 || na.length >16)
	    {
	       
	      divpassword.innerHTML='<font class="tips_false">×</font>';
	      password_Boolean = false;
	      }
	      else if((na.length >=6 || na.length <=16))
	      { 
	      divpassword.innerHTML='<font class="tips_true">✔</font>';
	      password_Boolean = true;
	      }
	}  
	  }
function checkrepass(){
    var passwd1=form2.password.value;  
    var passwd2=form2.repassword.value;
    if (passwd1 != passwd2) {
         divrepassword.innerHTML='<font class="tips_false">×</font>';
        // alert("密码不一致!");
         repassword_Boolean = false;;
     } 
    else{
         divrepassword.innerHTML='<font class="tips_true">✔</font>';
         repassword_Boolean = true;;
    }
}
function checkemail(){
	 var na=form2.email.value;
	var reg=/^([1-9])+([0-9_-])+@qq.com+/;
	    //apos=form1.email.value.indexOf("@qq.com");
		//dotpos=form1.email.value.lastIndexOf(".");
			if (!reg.test(na)) 
			  {
			  	divemail.innerHTML='<font class="tips_false">×</font>';
			  	emaile_Boolean = false;
			  }
			else {
				if(na.length <12|| na.length>17){
					divemail.innerHTML='<font class="tips_true">×</font>';
					emaile_Boolean = false;
				}
				else{
					divemail.innerHTML='<font class="tips_true">✔</font>';
				}
				emaile_Boolean = true;
			}
}
function validate() {
	
	var params = form2.cusername.value;
	if(params.length!=0){
	 reg=/^[a-zA-Z0-9_]+$/;     
    if(!reg.test(params)){
         {alert("输入错误!");   
         divcusername.innerHTML='<font class="tips_false">×</font>';
         user_Boolean = false;}
                }
                else{
                	if(params.length<3||params.length>16){
                divcusername.innerHTML='<font class="tips_false">×</font>';
                user_Boolean = false;
                	}else {
                		 divcusername.innerHTML='<font class="tips_false">✔</font>';
                		 user_Boolean = true;
                	}
                }
      }
	else if(params.length==""){
		divusername.innerHTML='<font class="tips_false">×</font>'
			user_Boolean = false;
	}
	$.ajax({
		url:"checkCusername.do",
		data:"cusername="+params,
		dataType:"text",
		type:"post",
		success:function(data){
		     if(data=="success"){
		    	 
		    	 divname.innerHTML='<font class="tips_true">该昵称可用</font>';
		    	
		    	user_Boolean = true;
		    }else{
		    	
		    	divname.innerHTML='<font class="tips_true">该昵称不可用</font>';
		    	
		    	user_Boolean = false;
		     }
		}
	});
}
function checkcname(){
	var params = form2.cname.value;
	$.ajax({
		url:"checkCname.do",
		data:"cname="+params,
		dataType:"text",
		type:"post",
		success:function(data){
		     if(data=="success"){
		    	 
		    	 divcname.innerHTML='<font class="tips_true">欢迎贵公司入驻</font>';
		    	 divcname1.innerHTML='<font class="tips_true">✔</font>';
		    	 cuser_Boolean = true;
		    }else{
		    	
		    	divcname.innerHTML='<font class="tips_true">贵公司已有代表人入驻</font>';
		    	divcname1.innerHTML='<font class="tips_true">×</font>';
		    	cuser_Boolean = false;
		     }
		}
	});
	
}

function checkAll(){
	  if(user_Boolean== false && password_Boolea== false && repassword_Boolean== false 
			  && emaile_Boolean == false && cuser_Boolean==false){
	    alert("注册成功");
	  }else {
	    alert("请完善信息");
	  }
}


