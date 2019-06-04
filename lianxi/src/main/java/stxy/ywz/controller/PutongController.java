package stxy.ywz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import stxy.ywz.bean.Company;
import stxy.ywz.bean.News;
import stxy.ywz.bean.Page;
import stxy.ywz.bean.Person;
import stxy.ywz.bean.Putong;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;
import stxy.ywz.service.PutongService;

@Controller
@RequestMapping("/pu")
public class PutongController {
	
	@Autowired
	PutongService putongService;
		
	/*没有登录回到登录前首页*/
	@RequestMapping("/main")
	public String gomain(Model model) {
		model.addAttribute("msg", "请先登陆");
		return "redirect:/main.do";
		
	}
	
	/*普通用户到注册页面*/
	@RequestMapping("/pureg")
	public String register(){		
		return "common/puregist";		
	}	
	
	/*普通用户注册信息*/
	@RequestMapping(value ="/puregist", method = RequestMethod.POST)
	public String puregist(Putong putong,HttpSession session,Model model){
		
	  boolean flag =putongService.insertpt(putong);
	  if(flag) {
	    	 
   	   model.addAttribute("msg", "注册成功");
   	   return "common/puregcheck";
      }
      else{
   	   model.addAttribute("msg", "注册信息存在错误！！！");
   	   return "common/puregcheck";
   			  
      }
				
	}
	
	/*注册完信息后返回网站首页登录*/
	@RequestMapping("/backmain")
	public String backmain() {
		return "redirect:/main.do?pageNow=1";
	}
	
	//普通用户登录
	@RequestMapping(value = "/pulog" )
	public String pulogin(Putong putong,Model model,HttpSession session)
	{
		Putong p=putongService.loginpt(putong);
		if (p !=null) {
			session.setAttribute("username",putong.getUsername());
			model.addAttribute("Putong",p);
			return "redirect:/pu/pumain.do";
		}
		else {
			model.addAttribute("msg", "账号和密码不匹配");
			return "redirect:/main.do";
		}
	}
	
	 /*普通用户登录进入到普通用户首页 */
	@RequestMapping("/pumain")
	public String pumain(SeeRecord seeRecord, Model model, String pageNow,
			HttpSession session) {
		//System.out.println(pageNow);

		Page page = null;
		String username1=(String) session.getAttribute("username");
		int totalCount = putongService.getCount();
		//System.out.println(totalCount);
		if(username1==null) {
			model.addAttribute("msg", "请先登陆");
			return "redirect:/main.do";
		}
		
		if (pageNow != null && pageNow != "") {
			int pageNow1 = Integer.parseInt(pageNow);
			//System.out.println(pageNow1);
			page = new Page(totalCount, pageNow1);
			
		}
		else
		{
			pageNow="1";
			int pageNow1 = Integer.parseInt(pageNow);
			page = new Page(totalCount, pageNow1);
		}
		//System.out.println(page);
		seeRecord.setPage(page);
		List<Recruit> listr = putongService.queryAllRecname(seeRecord);
		model.addAttribute("page", page);
		model.addAttribute("listr", listr);
		return "putong/pumain";
	}
	
	/*校验用户名是否已存在*/
	@ResponseBody
	@RequestMapping("/ajaxUsername")
	public String ajaxUsername(@RequestParam("username")String username) {
		Putong p=putongService.selectUserame(username);
		if(p!=null) {
			//System.out.println(111);
			return "false";}
		else { 
			//System.out.println(222);
			return "success";
			
		}
		
	}
	/*校验邮箱是否已存在*/
	@ResponseBody
	@RequestMapping("/ajaxEmail")
	public String ajaxEmail(@RequestParam("email")String email) {
		Putong p=putongService.selectEmail(email);
		if(p!=null) {
			System.out.println(111);
			return "false";}
		else { 
			System.out.println(222);
			return "success";
			
		}
	}
	/*修改个人信息前查询本人信息*/
	@RequestMapping("/updateusername")
	public String updateusername(Model model,HttpSession session) {
		String username=(String) session.getAttribute("username");
		Putong p=putongService.selectUserame(username);
		if(p!=null) 
			model.addAttribute("username", p.getUsername());
			model.addAttribute("password", p.getPassword());
			model.addAttribute("email", p.getEmail());
		
		return "putong/updatename";
		
	}
	
	/*修改个人账号信息*/
	@RequestMapping("/updatesubmit")
	public String updatesubmit(Putong putong,Model model) {
		boolean b=putongService.updateUsername(putong);
		if(b) 
			model.addAttribute("msg", "账号信息修改成功,请重新登录");
		    return "redirect:/main.do?pageNow=1";
	}
	/*跳转到填写个人简历网页*/
	@RequestMapping("/grjl")
	public String grjl(Model model,String cusername,String recname) {
		model.addAttribute("msg", cusername);
		model.addAttribute("msg1", recname);
		return "putong/grjl";
	}
	
	
	//新闻状态为0的列表
	@RequestMapping("/list1")
	public String list1(Model model) {
		List<News> H = putongService.list1();
		model.addAttribute("newsList",H);
		return "putong/newslist";
	}
	
	/*提交个人简历*/
	@RequestMapping("/submitgrjl")
	public String submitgrjl(Person person,Model model) {
		boolean b=putongService.insertGrjl(person);
		if(b) {
			model.addAttribute("msg", "提交成功");
			return "redirect:/pu/pumain.do";
		}
		else {
			model.addAttribute("msg", "填写的信息存在错误");
			return "redirect:/pu/pumain.do";
		}
		
	}
	
	/*模糊查询分页*/
	@RequestMapping("/searchrecname")
	public String searchrecname(Model model,String recname,String pageNow,SeeRecord seeRecord) {
		Page page = null;
		System.out.println(recname);
		int totalCount = putongService.getCount(recname);
		System.out.println(pageNow);
		if (pageNow != null && pageNow != "") {
			int pageNow1 = Integer.parseInt(pageNow);
			page = new Page(totalCount, pageNow1);
			
		}
		else
		{
			pageNow="1";
			int pageNow1 = Integer.parseInt(pageNow);
			page = new Page(totalCount, pageNow1);
		}
		//System.out.println(page);
		seeRecord.setPage(page);
		List<Recruit> listr = putongService.queryRecname(recname,page.getStartPos(),page.getPageSize());
		model.addAttribute("page", page);
		model.addAttribute("listr", listr);
        model.addAttribute("recname", recname);
		return "putong/searchrecname";
		
	}
	
	/*个人简历通知*/
	@RequestMapping("/grjlinform")
	public String selectgrjl(HttpSession session,Model model) {
		String username=(String) session.getAttribute("username");
		List<Company> listp=putongService.selectgrjl(username);
		if(listp!=null) 
			System.out.println(listp);
			model.addAttribute("listp", listp);
		    return "putong/grjlinform";
	}
	
	/*普通用户退出网站*/
	@RequestMapping("/quitpu")
	public String quitcom(HttpSession session) {
		session.invalidate();
		return "redirect:/main.do";
	}
	
}
