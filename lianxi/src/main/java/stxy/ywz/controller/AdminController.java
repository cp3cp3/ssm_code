package stxy.ywz.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import stxy.ywz.bean.Admin;
import stxy.ywz.bean.Company;
import stxy.ywz.bean.Page;
import stxy.ywz.bean.SeeRecord;
import stxy.ywz.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	/*没有登录回到登录前首页*/
	@RequestMapping("/main")
	public String gomain(Model model) {
		model.addAttribute("msg", "请先登陆");
		return "redirect:/main.do";
		
	}
	
	/*进入管理员登录页面*/
	@RequestMapping("/adlog")
	public String adlog() {
		return "common/adlogin";
	}
	
	/*跳转到管理员首页*/
	@RequestMapping("/admain")
	public String admain() {
		return "admins/admain";
	}
	
	
	
	/*管理员登录进入管理员首页*/
	@RequestMapping("/adlogin")
	public String adlogin(Admin admins,HttpSession session,
			HttpServletRequest request,Model model) {
		
		String ausername1=admins.getAusername();
		
		Admin admin=adminService.getNmaeAndPwd(admins);
		if(admin!=null) {
			if(admin.getAstate()==0) {
			session.setAttribute("username", ausername1);
			model.addAttribute("username",ausername1);
			return "admins/admain";
			}
			else if(admin.getAstate()==1) {
				model.addAttribute("msg", "你的账号已被注销！请联系客服");
				return "common/adlogin";
			}
		}
		else {
			model.addAttribute("msg", "用户名和密码不匹配!请重填");
			return "common/adlogin";
		}
		return "common/adlogin";
		
	}
	/*管理员修改账号信息前查询本人信息*/
	@RequestMapping("/updateausername")
	public String updateausername(Model model,HttpSession session,HttpServletRequest request) {
		String ausername1=(String) session.getAttribute("username");
		Admin admin=adminService.getAcusername(ausername1);
		model.addAttribute("lista",admin);
		return "admins/updatename";
	}
	
	/*管理员提交修改的个人信息*/
	
	@RequestMapping("/updatesubmit")
	public String updatesubmit(Admin admin,Model model) {
		boolean b=adminService.updateAusername(admin);
		if(b) 
			model.addAttribute("msg", "个人信息修改成功");
			return "redirect:/admin/quitadmin.do";
		
	}
	
	
	/*管理员查询待审核公司代表人账号信息*/
	@RequestMapping("/checkcname")
	public String checkcname( SeeRecord seeRecord, Model model,
			String pageNow) throws SQLException {
		System.out.println(pageNow);
		
		Page page = null;
		int totalCount = adminService.getCount();
		System.out.println(totalCount);
		
		
		if (pageNow != null && pageNow != "") {
			int pageNow1 = Integer.parseInt(pageNow);
			page = new Page(totalCount, pageNow1);
			
		}
		System.out.println(page);
		seeRecord.setPage(page);
		List<Company> listc = adminService.queryAllCusername(seeRecord);
		model.addAttribute("page", page);
		model.addAttribute("listc", listc);

		return "admins/adcheck";

	}
	
	 /*审核公司代表人信息*/
	@RequestMapping("/checksubmit")
	public String checksubmit(Model model,HttpServletRequest request) 
	{
		//String pageNow="1";
		String cusername1=request.getParameter("cusername");
		int i=adminService.updateCusername(cusername1);
		if(i>0) 
			model.addAttribute("msg", cusername1+"用户已通过审核");
		    //request.setAttribute("pagNow", pageNow);
		return "redirect:/admin/checkcname.do?pageNow=1";
		
	}
	
	/*退出登录*/
	@RequestMapping("/quitadmin")
	public String quitadmin(HttpSession	session,Model model) {
		model.addAttribute("msg", "成功退出");
		session.invalidate();
		return "common/adlogin";
		
		
	}

}
