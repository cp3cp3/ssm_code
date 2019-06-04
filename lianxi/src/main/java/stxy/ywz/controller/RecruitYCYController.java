package stxy.ywz.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import stxy.ywz.bean.Recruit;
import stxy.ywz.service.RecruitYCYService;

@Controller
@RequestMapping("/recruit")
public class RecruitYCYController {
	
	@Autowired
	private RecruitYCYService recruitYCYService;
	
	/*����ְҵ��Ϣ*/
	@RequestMapping("/rsave")
	public String Rsave(Recruit recruit,Model model) {
		recruitYCYService.insert(recruit);
		model.addAttribute("msg", "�����ɹ�");
		return "redirect:/company/comain.do";
		
	}
	/*��ת������ְҵ��Ϣҳ��*/
	@RequestMapping("/zpf")
	public String Zpf() {
		return "company/comzpf";
	}
	 
	
	/*��˾�鿴������Ƹ��Ϣ*/
	@RequestMapping("/list")
	public String list(Model model) {
		List<Recruit> li = recruitYCYService.list();
		model.addAttribute("recruitList",li);
		System.out.println(li);
		
		return "company/comallzp";
	}
	
	/*����Ա�鿴������Ƹ��Ϣ*/
	@RequestMapping("/adlist")
	public String adlist(Model model) {
		List<Recruit> li = recruitYCYService.adlist();
		model.addAttribute("adrecruitList",li);
		System.out.println(li);
		
		return "admins/adcomzp";
	}
	
	/*��˾�鿴����˾��Ƹ��Ϣ*/
	@RequestMapping("/blist")
	public String blist(Model model,
			HttpSession session) {
		/*session.setAttribute("cusername1", "username");*/
		String cusername1=(String) session.getAttribute("username");
		List<Recruit> li = recruitYCYService.blist(cusername1);
		model.addAttribute("brecruitList",li);
		System.out.println(li);
		
		return "company/comsl";
	}
	
	/*�鵽������ת������˾�޸���Ƹ��Ϣҳ��*/
	@RequestMapping("/listbyid")
	public String listbyid(@RequestParam("recid") Integer recid,Model model) {
		Recruit recruit = recruitYCYService.listbyid(recid);
		model.addAttribute("listByid",recruit);
		return "company/comzpupdate";
	}
	  
	/*�޸���Ƹ��Ϣ����ת����Ƹ��Ϣҳ��*/
	@RequestMapping("/bupdate")
	public String bupdate(Recruit recruit,Model model,HttpSession session) {
		int i = recruitYCYService.bupdate(recruit);
		System.out.println(i);
		if(i>0) {
			String cusername1=(String) session.getAttribute("username");
			List<Recruit> li = recruitYCYService.blist(cusername1);
			model.addAttribute("brecruitList",li);
			return "redirect:/page/pageb.do?pageNow=1";
		}
		return null;
	}
	
	/*��˾ɾ��һ����Ƹ��Ϣ*/
	@RequestMapping("/bdelete")
	public String bdelete(@RequestParam("recid") Integer recid,Model model,HttpSession session) {
		int i = recruitYCYService.bdelete(recid);
		System.out.println(i);
		
			if(i>0) {
				String cusername1=(String) session.getAttribute("username");
				List<Recruit> li = recruitYCYService.blist(cusername1);
				model.addAttribute("brecruitList",li);
				return "redirect:/page/pageb.do?pageNow=1";
			}
		
		return null;
	}
	
	
	/*����Աɾ��һ����Ƹ��Ϣ*/
	@RequestMapping("/addelete")
	public String addelete(@RequestParam("recid") Integer recid,Model model) {
		int i = recruitYCYService.bdelete(recid);
		System.out.println(i);
		
			if(i>0) {
				
				List<Recruit> li = recruitYCYService.adlist();
				model.addAttribute("adrecruitList",li);
				System.out.println(li);
				
				return "redirect:/page/pagead.do?pageNow=1";
			}
		
		return null;
	}
	
	


}
