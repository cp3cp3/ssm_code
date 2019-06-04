package stxy.ywz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import stxy.ywz.bean.Page;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;
import stxy.ywz.service.OtherService;

@Controller
public class OtherController {
	@Autowired
	private OtherService otherservice;
	
	/*ÍøÕ¾Ê×Ò³*/
	@RequestMapping("/main")
	public String main(SeeRecord seeRecord, Model model,
			 String pageNow) {
		Page page = null;
		int totalCount = otherservice.getCount();
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
		List<Recruit> listr = otherservice.queryAllRecname(seeRecord);
		model.addAttribute("page", page);
		model.addAttribute("listr", listr);

		return "common/main";
	}
	/*Ä£ºýËÑË÷·ÖÒ³*/
	@RequestMapping("/serchrecname.do")
	public String serchrecname(SeeRecord seeRecord, Model model,
			 String pageNow,String recname) {
		Page page = null;
		System.out.println(recname);
		int totalCount = otherservice.getCount(recname);
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
		List<Recruit> listr = otherservice.queryRecname(recname,page.getStartPos(),page.getPageSize());
		model.addAttribute("page", page);
		model.addAttribute("listr", listr);
        model.addAttribute("recname", recname);
		return "common/searchrecname";
	}
	
	
}
