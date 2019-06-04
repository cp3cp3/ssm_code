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
		
	/*û�е�¼�ص���¼ǰ��ҳ*/
	@RequestMapping("/main")
	public String gomain(Model model) {
		model.addAttribute("msg", "���ȵ�½");
		return "redirect:/main.do";
		
	}
	
	/*��ͨ�û���ע��ҳ��*/
	@RequestMapping("/pureg")
	public String register(){		
		return "common/puregist";		
	}	
	
	/*��ͨ�û�ע����Ϣ*/
	@RequestMapping(value ="/puregist", method = RequestMethod.POST)
	public String puregist(Putong putong,HttpSession session,Model model){
		
	  boolean flag =putongService.insertpt(putong);
	  if(flag) {
	    	 
   	   model.addAttribute("msg", "ע��ɹ�");
   	   return "common/puregcheck";
      }
      else{
   	   model.addAttribute("msg", "ע����Ϣ���ڴ��󣡣���");
   	   return "common/puregcheck";
   			  
      }
				
	}
	
	/*ע������Ϣ�󷵻���վ��ҳ��¼*/
	@RequestMapping("/backmain")
	public String backmain() {
		return "redirect:/main.do?pageNow=1";
	}
	
	//��ͨ�û���¼
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
			model.addAttribute("msg", "�˺ź����벻ƥ��");
			return "redirect:/main.do";
		}
	}
	
	 /*��ͨ�û���¼���뵽��ͨ�û���ҳ */
	@RequestMapping("/pumain")
	public String pumain(SeeRecord seeRecord, Model model, String pageNow,
			HttpSession session) {
		//System.out.println(pageNow);

		Page page = null;
		String username1=(String) session.getAttribute("username");
		int totalCount = putongService.getCount();
		//System.out.println(totalCount);
		if(username1==null) {
			model.addAttribute("msg", "���ȵ�½");
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
	
	/*У���û����Ƿ��Ѵ���*/
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
	/*У�������Ƿ��Ѵ���*/
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
	/*�޸ĸ�����Ϣǰ��ѯ������Ϣ*/
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
	
	/*�޸ĸ����˺���Ϣ*/
	@RequestMapping("/updatesubmit")
	public String updatesubmit(Putong putong,Model model) {
		boolean b=putongService.updateUsername(putong);
		if(b) 
			model.addAttribute("msg", "�˺���Ϣ�޸ĳɹ�,�����µ�¼");
		    return "redirect:/main.do?pageNow=1";
	}
	/*��ת����д���˼�����ҳ*/
	@RequestMapping("/grjl")
	public String grjl(Model model,String cusername,String recname) {
		model.addAttribute("msg", cusername);
		model.addAttribute("msg1", recname);
		return "putong/grjl";
	}
	
	
	//����״̬Ϊ0���б�
	@RequestMapping("/list1")
	public String list1(Model model) {
		List<News> H = putongService.list1();
		model.addAttribute("newsList",H);
		return "putong/newslist";
	}
	
	/*�ύ���˼���*/
	@RequestMapping("/submitgrjl")
	public String submitgrjl(Person person,Model model) {
		boolean b=putongService.insertGrjl(person);
		if(b) {
			model.addAttribute("msg", "�ύ�ɹ�");
			return "redirect:/pu/pumain.do";
		}
		else {
			model.addAttribute("msg", "��д����Ϣ���ڴ���");
			return "redirect:/pu/pumain.do";
		}
		
	}
	
	/*ģ����ѯ��ҳ*/
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
	
	/*���˼���֪ͨ*/
	@RequestMapping("/grjlinform")
	public String selectgrjl(HttpSession session,Model model) {
		String username=(String) session.getAttribute("username");
		List<Company> listp=putongService.selectgrjl(username);
		if(listp!=null) 
			System.out.println(listp);
			model.addAttribute("listp", listp);
		    return "putong/grjlinform";
	}
	
	/*��ͨ�û��˳���վ*/
	@RequestMapping("/quitpu")
	public String quitcom(HttpSession session) {
		session.invalidate();
		return "redirect:/main.do";
	}
	
}
