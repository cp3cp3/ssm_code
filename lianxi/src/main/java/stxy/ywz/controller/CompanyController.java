package stxy.ywz.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import stxy.ywz.bean.Company;
import stxy.ywz.bean.News;
import stxy.ywz.bean.Page;
import stxy.ywz.bean.Person;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;
import stxy.ywz.service.CompanyService;

@Controller
@RequestMapping("/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyservice;
	
	/*没有登录回到登录前首页*/
	@RequestMapping("/main")
	public String gomain(Model model) {
		model.addAttribute("msg", "请先登陆");
		return "redirect:/main.do";
		
	}
	
	/*公司代表人登录注册页面*/
	@RequestMapping("/colog-reg")
	public String logregist() {
		return "common/colog-reg";
	}
	
	/*公司代表人首页*/
	@RequestMapping("/comain")
	public String main(SeeRecord seeRecord, Model model,
		 String pageNow,HttpSession session) {
		Page page = null;
		String username1=(String) session.getAttribute("username");
		int totalCount = companyservice.getCount();
		if(username1==null) {
			model.addAttribute("msg", "请先登陆");
			return "redirect:/main.do";
		}
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
		List<Recruit> listr = companyservice.queryAllRecname(seeRecord);
		//System.out.println(listr);
		session.setAttribute("username", username1);
		model.addAttribute("page", page);
		model.addAttribute("listr", listr);
		return "company/comain";
		
	}
	
	/*公司代表人注册用户名验证*/
	@ResponseBody
	@RequestMapping("/checkCusername")
	public String  checkCusername(@RequestParam("cusername")String cusername){
		
		//数据库用户名重复校验
		Company com = companyservice.getCusername(cusername);
		if(com!=null){
			
			return "false";
		}else{
			
			return "success";
		}
	
	}
	
	/*查询公司是否有代表人已入驻*/
	@ResponseBody
	@RequestMapping("/checkCname")
	public String checkCname(@RequestParam("cname")String cname) {
		Company com=companyservice.getCname(cname);
		if(com!=null) {
			return "false";
		}
		else {
			return "success";
		}
	}

	/*公司代表人注册账号*/
	@RequestMapping("/coreg")
	public String coregister(Company company,HttpSession session,
			Model model,HttpServletRequest request) {
		
		boolean flag=companyservice.companyreg(company);
      
       if(flag) {
    	 
    	   model.addAttribute("msg", "注册成功，等待管理员审核，通过后会通知");
    	   return "common/coregafter";
       }
       else{
    	   System.out.println("注册信息存在错误！！！");
    	   model.addAttribute("msg", "注册信息存在错误！！！");
    	   return "common/coregafter";
    			  
       }
	}
	
	
	
	/*公司代表人登录验证，成功则进入系统*/
	@RequestMapping("/colog")
	public String checklog(Company companys,HttpSession session,Model model) {
		String cusername1=companys.getCusername();
		
		Company com=companyservice.getCuserAndPwd(companys);
		if(com!=null) {
			if(com.getCstate()==0) {
				session.setAttribute("username", cusername1);
				session.setAttribute("cname",com.getCname());
				model.addAttribute("username", com.getCusername());
				model.addAttribute("cname", com.getCname());
				return "redirect:/company/comain.do";
			}
			else if(com.getCstate()==1) {
				model.addAttribute("msg", "该账号已被注销或还没有通过审核！");
				return "common/colog-reg";
			}
		}
		else {
			model.addAttribute("msg", "用户名和密码不匹配！");
			return "common/colog-reg";
		}
		return "common/colog-reg";
		
	}
	
	
	/*跳转到修改代表人账号信息页面并进行查询*/
	@RequestMapping("/updatecusername")
	public String updateCusername(String cusername,HttpServletRequest request,
			Model model,HttpSession session) {
		String cusername1=(String) session.getAttribute("username");
		request.setAttribute("listc", companyservice.getName(cusername1));
		Company com=companyservice.getName(cusername1);
			model.addAttribute("cusername",com.getCusername());
			model.addAttribute("password", com.getPassword());
			model.addAttribute("cname", com.getCname());
			model.addAttribute("email", com.getEmail());
			model.addAttribute("address", com.getAddress());
		return "company/updatename";
		
	}
	
	/*公司代表人修改账号信息*/
	@RequestMapping("/submitupdate")
	public String updateCusername(Company company,Model model,
			HttpServletRequest request) {
		boolean b=companyservice.updateCusername(company);
		if(b) {
			model.addAttribute("msg", "账号信息修改成功，待审核！");
			return "redirect:/company/quitcom.do";
		}
		else {
			model.addAttribute("msg", "账号信息修改失败!");
			return "redirect:/quitcom.do";
		}
	}
	
	//新闻状态为0的列表
	@RequestMapping("/list1")
	public String list1(Model model) {
		List<News> H = companyservice.list1();
		model.addAttribute("newsList",H);
		return "company/newslist";
	}
	
	/*模糊搜索分页*/
	@RequestMapping("/searchrecname")
	public String searchrecname(String recname,SeeRecord seeRecord,Model model
			,String pageNow) {
		
		Page page = null;
		System.out.println(recname);
		int totalCount = companyservice.getCount(recname);
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
		List<Recruit> listr = companyservice.queryRecname(recname,page.getStartPos(),page.getPageSize());
		model.addAttribute("page", page);
		model.addAttribute("listr", listr);
        model.addAttribute("recname", recname);
		return "company/searchrecname";
		
	}
	/*待面试用户简历*/
	@RequestMapping("/waitperson")
	public String waitperson( SeeRecord seeRecord, Model model,
			String pageNow,HttpSession session) throws SQLException {
		Page page = null;
		String cusername1=(String) session.getAttribute("username");
		int totalCount = companyservice.getCountPerson(cusername1);
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
		List<Person> listp = companyservice.queryWaitPerson(cusername1, page.getStartPos(), page.getPageSize());
		model.addAttribute("page", page);
		model.addAttribute("listp", listp);
        model.addAttribute("recname", cusername1);
		


		return "company/waitperson";

	}
	/*删除待面试用户简历*/
	@RequestMapping("/deletesubmit")
	public String deletesubmit(int resumeid,Model model) {
		boolean b=companyservice.deleteWaitPerson(resumeid);
		if(b)
			model.addAttribute("msg", "删除已面试简历成功");
		return "redirect:/company/waitperson.do";
	}
	
	/*公司代表人退出登录*/
	@RequestMapping("/quitcom")
	public String quitcom(HttpSession session) {
		session.invalidate();
		return "common/colog-reg";
	}
	
	

}
