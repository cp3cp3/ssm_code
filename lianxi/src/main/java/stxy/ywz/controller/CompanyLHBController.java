package stxy.ywz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import stxy.ywz.bean.Person;
import stxy.ywz.service.CompanyLHBService;

@Controller
@RequestMapping("/company")
public class CompanyLHBController {

	@Autowired
	private CompanyLHBService companyLHBService;
	
	//公司查询个人简历
	@RequestMapping("/findAllperson")
	public String findAllperson(String cusername, Model model,HttpSession session, HttpServletRequest request){
		String cusername1=(String) session.getAttribute("username");
		List<Person> person=companyLHBService.findGSperson(cusername1);
		model.addAttribute("listc", person);
		session.setAttribute("listc", person);
		request.setAttribute("listc", person);
		return "company/findAllperson";		//****
		}
	//录取个人简历
	@RequestMapping("/luquPerson")
	public String luquPerson(int resumeid,Person person1, Model model1){
		boolean luquPerson =companyLHBService.luquPerson(resumeid);
		if(luquPerson)
		
			model1.addAttribute("msg","个人简历接收成功");
			return "redirect:/company/findAllperson.do";		//*****
		
	}
	
	//删除个人简历
	@RequestMapping("/deletePerson")
	public String deleteperson(int resumeid,Person person1, Model model1){
		int luquPerson =companyLHBService.deletePerson(resumeid);
		
			return "redirect:/company/findAllperson.do";		//*****
		
	}
	
	
	
}
