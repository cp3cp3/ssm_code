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
	
	/*发布职业信息*/
	@RequestMapping("/rsave")
	public String Rsave(Recruit recruit,Model model) {
		recruitYCYService.insert(recruit);
		model.addAttribute("msg", "发布成功");
		return "redirect:/company/comain.do";
		
	}
	/*跳转到发布职业信息页面*/
	@RequestMapping("/zpf")
	public String Zpf() {
		return "company/comzpf";
	}
	 
	
	/*公司查看所有招聘信息*/
	@RequestMapping("/list")
	public String list(Model model) {
		List<Recruit> li = recruitYCYService.list();
		model.addAttribute("recruitList",li);
		System.out.println(li);
		
		return "company/comallzp";
	}
	
	/*管理员查看所有招聘信息*/
	@RequestMapping("/adlist")
	public String adlist(Model model) {
		List<Recruit> li = recruitYCYService.adlist();
		model.addAttribute("adrecruitList",li);
		System.out.println(li);
		
		return "admins/adcomzp";
	}
	
	/*公司查看本公司招聘信息*/
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
	
	/*查到数据跳转到本公司修改招聘信息页面*/
	@RequestMapping("/listbyid")
	public String listbyid(@RequestParam("recid") Integer recid,Model model) {
		Recruit recruit = recruitYCYService.listbyid(recid);
		model.addAttribute("listByid",recruit);
		return "company/comzpupdate";
	}
	  
	/*修改招聘信息后跳转到招聘信息页面*/
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
	
	/*公司删除一条招聘信息*/
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
	
	
	/*管理员删除一条招聘信息*/
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
