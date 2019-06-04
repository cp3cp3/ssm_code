package stxy.ywz.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import stxy.ywz.bean.Pagey;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecordy;
import stxy.ywz.service.PageYCYService;

@Controller
@RequestMapping("/page")
public class PageYCYController {
	@Autowired
	private PageYCYService pageYCYService;
	
	
	@RequestMapping("/pageall")
	public String pageall(SeeRecordy seeRecordy, Model model,
			@RequestParam("pageNow") String pageNow) {
		
		
		Pagey pagey =null;
		int totalCount = pageYCYService.getCount();
		
		if (pageNow != null && pageNow != "") {
			int pageNow1 = Integer.parseInt(pageNow);
			pagey = new Pagey(totalCount, pageNow1);
			
		}
		seeRecordy.setPage(pagey);
		List<Recruit> listb = pageYCYService.queryAllRecruit(seeRecordy);
		model.addAttribute("page", pagey);
		model.addAttribute("recruitList", listb);
		System.out.println(pagey.getTotalPageCount());
		System.out.println(pagey.getPageNow());

		return "company/comallzp";
		
		
	}
	
	
	@RequestMapping("/pagead")
	public String pagead(SeeRecordy seeRecordy, Model model,
			@RequestParam("pageNow") String pageNow) {
		
		
		Pagey pagey =null;
		int totalCount = pageYCYService.getCount();
		
		if (pageNow != null && pageNow != "") {
			int pageNow1 = Integer.parseInt(pageNow);
			pagey = new Pagey(totalCount, pageNow1);
			
		}
		seeRecordy.setPage(pagey);
		List<Recruit> listb = pageYCYService.queryAllRecruit(seeRecordy);
		model.addAttribute("page", pagey);
		model.addAttribute("adrecruitList", listb);
		System.out.println(pagey.getTotalPageCount());
		System.out.println(pagey.getPageNow());

		return "admins/adcomzp";
		
		
	}
	
	/*查看本公司信息并分页*/
	@RequestMapping("/pageb")
	public String pageb(SeeRecordy seeRecordy, Model model,
			@RequestParam("pageNow") String pageNow,HttpSession session) {
		
		String cusername1=(String) session.getAttribute("username");
		System.out.println(cusername1);
		Pagey pagey =null;
		
		int totalCount = pageYCYService.getCountb(cusername1);
		
		if (pageNow != null && pageNow != "") {
			int pageNow1 = Integer.parseInt(pageNow);
			pagey = new Pagey(totalCount, pageNow1,cusername1);
			
			System.out.println(pagey);
		}
		seeRecordy.setPage(pagey);
		List<Recruit> listb = pageYCYService.querybRecruit(seeRecordy);
		System.out.println("请输出listb：");
		System.out.println(listb);
		model.addAttribute("page", pagey);
		model.addAttribute("bgrecruitList", listb);
		System.out.println(pagey.getTotalPageCount());
		System.out.println(pagey.getPageNow());

		return "company/comsl";
		
		
	}
	
}
