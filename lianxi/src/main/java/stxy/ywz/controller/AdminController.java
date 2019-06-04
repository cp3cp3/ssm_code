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
	
	/*û�е�¼�ص���¼ǰ��ҳ*/
	@RequestMapping("/main")
	public String gomain(Model model) {
		model.addAttribute("msg", "���ȵ�½");
		return "redirect:/main.do";
		
	}
	
	/*�������Ա��¼ҳ��*/
	@RequestMapping("/adlog")
	public String adlog() {
		return "common/adlogin";
	}
	
	/*��ת������Ա��ҳ*/
	@RequestMapping("/admain")
	public String admain() {
		return "admins/admain";
	}
	
	
	
	/*����Ա��¼�������Ա��ҳ*/
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
				model.addAttribute("msg", "����˺��ѱ�ע��������ϵ�ͷ�");
				return "common/adlogin";
			}
		}
		else {
			model.addAttribute("msg", "�û��������벻ƥ��!������");
			return "common/adlogin";
		}
		return "common/adlogin";
		
	}
	/*����Ա�޸��˺���Ϣǰ��ѯ������Ϣ*/
	@RequestMapping("/updateausername")
	public String updateausername(Model model,HttpSession session,HttpServletRequest request) {
		String ausername1=(String) session.getAttribute("username");
		Admin admin=adminService.getAcusername(ausername1);
		model.addAttribute("lista",admin);
		return "admins/updatename";
	}
	
	/*����Ա�ύ�޸ĵĸ�����Ϣ*/
	
	@RequestMapping("/updatesubmit")
	public String updatesubmit(Admin admin,Model model) {
		boolean b=adminService.updateAusername(admin);
		if(b) 
			model.addAttribute("msg", "������Ϣ�޸ĳɹ�");
			return "redirect:/admin/quitadmin.do";
		
	}
	
	
	/*����Ա��ѯ����˹�˾�������˺���Ϣ*/
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
	
	 /*��˹�˾��������Ϣ*/
	@RequestMapping("/checksubmit")
	public String checksubmit(Model model,HttpServletRequest request) 
	{
		//String pageNow="1";
		String cusername1=request.getParameter("cusername");
		int i=adminService.updateCusername(cusername1);
		if(i>0) 
			model.addAttribute("msg", cusername1+"�û���ͨ�����");
		    //request.setAttribute("pagNow", pageNow);
		return "redirect:/admin/checkcname.do?pageNow=1";
		
	}
	
	/*�˳���¼*/
	@RequestMapping("/quitadmin")
	public String quitadmin(HttpSession	session,Model model) {
		model.addAttribute("msg", "�ɹ��˳�");
		session.invalidate();
		return "common/adlogin";
		
		
	}

}
