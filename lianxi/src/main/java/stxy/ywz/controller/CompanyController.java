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
	
	/*û�е�¼�ص���¼ǰ��ҳ*/
	@RequestMapping("/main")
	public String gomain(Model model) {
		model.addAttribute("msg", "���ȵ�½");
		return "redirect:/main.do";
		
	}
	
	/*��˾�����˵�¼ע��ҳ��*/
	@RequestMapping("/colog-reg")
	public String logregist() {
		return "common/colog-reg";
	}
	
	/*��˾��������ҳ*/
	@RequestMapping("/comain")
	public String main(SeeRecord seeRecord, Model model,
		 String pageNow,HttpSession session) {
		Page page = null;
		String username1=(String) session.getAttribute("username");
		int totalCount = companyservice.getCount();
		if(username1==null) {
			model.addAttribute("msg", "���ȵ�½");
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
	
	/*��˾������ע���û�����֤*/
	@ResponseBody
	@RequestMapping("/checkCusername")
	public String  checkCusername(@RequestParam("cusername")String cusername){
		
		//���ݿ��û����ظ�У��
		Company com = companyservice.getCusername(cusername);
		if(com!=null){
			
			return "false";
		}else{
			
			return "success";
		}
	
	}
	
	/*��ѯ��˾�Ƿ��д���������פ*/
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

	/*��˾������ע���˺�*/
	@RequestMapping("/coreg")
	public String coregister(Company company,HttpSession session,
			Model model,HttpServletRequest request) {
		
		boolean flag=companyservice.companyreg(company);
      
       if(flag) {
    	 
    	   model.addAttribute("msg", "ע��ɹ����ȴ�����Ա��ˣ�ͨ�����֪ͨ");
    	   return "common/coregafter";
       }
       else{
    	   System.out.println("ע����Ϣ���ڴ��󣡣���");
    	   model.addAttribute("msg", "ע����Ϣ���ڴ��󣡣���");
    	   return "common/coregafter";
    			  
       }
	}
	
	
	
	/*��˾�����˵�¼��֤���ɹ������ϵͳ*/
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
				model.addAttribute("msg", "���˺��ѱ�ע����û��ͨ����ˣ�");
				return "common/colog-reg";
			}
		}
		else {
			model.addAttribute("msg", "�û��������벻ƥ�䣡");
			return "common/colog-reg";
		}
		return "common/colog-reg";
		
	}
	
	
	/*��ת���޸Ĵ������˺���Ϣҳ�沢���в�ѯ*/
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
	
	/*��˾�������޸��˺���Ϣ*/
	@RequestMapping("/submitupdate")
	public String updateCusername(Company company,Model model,
			HttpServletRequest request) {
		boolean b=companyservice.updateCusername(company);
		if(b) {
			model.addAttribute("msg", "�˺���Ϣ�޸ĳɹ�������ˣ�");
			return "redirect:/company/quitcom.do";
		}
		else {
			model.addAttribute("msg", "�˺���Ϣ�޸�ʧ��!");
			return "redirect:/quitcom.do";
		}
	}
	
	//����״̬Ϊ0���б�
	@RequestMapping("/list1")
	public String list1(Model model) {
		List<News> H = companyservice.list1();
		model.addAttribute("newsList",H);
		return "company/newslist";
	}
	
	/*ģ��������ҳ*/
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
	/*�������û�����*/
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
	/*ɾ���������û�����*/
	@RequestMapping("/deletesubmit")
	public String deletesubmit(int resumeid,Model model) {
		boolean b=companyservice.deleteWaitPerson(resumeid);
		if(b)
			model.addAttribute("msg", "ɾ�������Լ����ɹ�");
		return "redirect:/company/waitperson.do";
	}
	
	/*��˾�������˳���¼*/
	@RequestMapping("/quitcom")
	public String quitcom(HttpSession session) {
		session.invalidate();
		return "common/colog-reg";
	}
	
	

}
