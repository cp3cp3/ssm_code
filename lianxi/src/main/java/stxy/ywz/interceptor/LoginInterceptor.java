package stxy.ywz.interceptor;

import java.lang.ProcessBuilder.Redirect;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor  implements HandlerInterceptor{

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception exception)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelAndView)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		   String url = request.getRequestURI();
	        if (url.indexOf("main.do") >= 0 ||url.indexOf("adlog.do")>=0 || url.indexOf("colog-reg.do")>=0 || 
	        		url.indexOf("checkCusername.do")>=0 ||url.indexOf("checkCname.do")>=0 ||url.indexOf("ajaxUsername.do")>=0 ||
	        		url.indexOf("puregist.do")>=0 ||url.indexOf("coreg.do")>=0 || url.indexOf("colog.do")>=0 ||url.indexOf("ajaxEmail.do")>=0 ||
	        		url.indexOf("pureg.do") >= 0||url.indexOf("serchrecname.do")>=0 ||url.indexOf("pulog.do")>=0||url.indexOf("list1.do")>=0) {
	            // 如果是登陆公开地址，则放行
	            return true;
	        }
	        if (request.getSession().getAttribute("username") != null) {
	            // 判断用户名在session中是否存在，存在则放行
	            return true;
	        }

	        /*if(request.getSession().getAttribute("username")==null) {*/
	        response.sendRedirect("main.do");
	        	/* return false;
	        }*/
			return false;

	        // 否则拦截
	      
	        //return false;
	    }
	

}
