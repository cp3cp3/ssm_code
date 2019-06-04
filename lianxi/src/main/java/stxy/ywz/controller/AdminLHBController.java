package stxy.ywz.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.support.HttpAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpServerErrorException;

import stxy.ywz.bean.Person;
import stxy.ywz.service.AdminLHBService;

@Controller
@RequestMapping("/admin")		///****
public class AdminLHBController {

	@Autowired
	private AdminLHBService adminLHBService;
	
	//查询个人简历
	@RequestMapping("/findAllperson")		//*****
	public String findAllperson(Model model,HttpSession session, HttpServletRequest request){
		List<Person> person=adminLHBService.findAllperson();
		model.addAttribute("listc", person);
		session.setAttribute("listc", person);
		request.setAttribute("listc", person);
		return "admins/findAllperson";		//****
		}
	//删除个人简历
	@RequestMapping("/deleteperson")
	public String deleteperson(int resumeid,Person person1, Model model1){
		boolean updatePerson =adminLHBService.updatePerson(resumeid);
		if(updatePerson)
		
			model1.addAttribute("msg","个人简历删除成功");
			return "redirect:/admin/findAllperson.do";		//*****
		
	}
		
	
	
}
