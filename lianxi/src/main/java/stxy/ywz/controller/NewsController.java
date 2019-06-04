package stxy.ywz.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import stxy.ywz.bean.News;
import stxy.ywz.bean.Pages;
import stxy.ywz.service.NewsService;

@Controller
@RequestMapping("/admin")
	public class NewsController {
		
		@Autowired
		private NewsService newsService;
		
		@RequestMapping("/newsadd")
		public String add() {
			return "admins/news_add";
		}
		
		//添加新闻
		@RequestMapping("/save")
		public String save(News news) {
			newsService.insert(news);
			return "redirect:/admin/list.do";
		}
		
		@RequestMapping("/list")
		public String searchInvList(Pages page,HttpServletRequest request) throws UnsupportedEncodingException {

	        //组装page对象,传入方法中查询列表 回显数据
	        Pages p =page;
	       System.out.println(page.getPageNow());
	        int pageSize=4; //设置每页大小
	        p.setPageSize(pageSize);
	        int pageNow=p.getPageNow();
	        
	        //当当前页面为0时转变成1
	        if (pageNow==0) {
	        	pageNow=1;
	            p.setPageNow(pageNow);
	        }
	        int startPos =page.getStartPos();
	        
	        if (!(p.getPageNow()==0)) {
	        	startPos = getStartRowBycurrentPage(pageNow, pageSize);
	        }        
	        p.setStartPos(startPos);       

	        Integer totalCount = newsService.searchTotalCount(page);//总条数

	        int totalPageCount=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);//总页数=总条数/页大小+1

	        p.setTotalPageCount(totalPageCount);//总页数

	        page.setTotalCount(totalCount);//总行数
	        
	        if(page.getPageNow()>page.getTotalPageCount()) {
	        	request.setAttribute("message", "已到页尾，无法显示下一页");
	        	page.setPageNow(totalPageCount);
	        }
	        
	        List<News> H = newsService.list(page);
	        request.setAttribute("newsList", H);
	        

	        request.setAttribute("page", page);

	        return "admins/news_list";
	    }


		 public int getStartRowBycurrentPage(int pageNow,int pageSize){
			 
		        int startPos=0;	
		        
		        if (pageNow==1) {	            
		            return startPos=0;
		        }	 
		        
		        startPos=(pageNow-1)*pageSize;	        
		        return startPos;	        
		    }

		
		//新闻状态为0的列表
			@RequestMapping("/list1")
			public String list1(Model model) {
				List<News> H = newsService.list1();
				model.addAttribute("newsList",H);
				return "common/newslist";
			}

		//通过主键id查询单条新闻
		@RequestMapping("/nid")
		public String selectoneByPrimaryKey(@RequestParam("nid") Integer nid,Model model) {
			News H = newsService.selectoneByPrimaryKey(nid);
			model.addAttribute("newsList",H);
			return "admins/news_edit";
		}

		//修改一个新闻信息
		@RequestMapping("/update")
		public String update(News news,Model model) {
			int H = newsService.update(news);
			if (H > 0) {
				List<News> list = newsService.listall();
				model.addAttribute("newsList",list);
				return "redirect:/admin/list.do";
			}
			return null;
		}
		
		//更改新闻状态
			@RequestMapping("/edit")
			public String edit(News news,Model model) {			
				if(news.getNstate() != 0) {
				    int nstate = 0;
					news.setNstate(nstate);
					System.out.println(news .getNstate());
					newsService.edit(news);				
				}else {
					int nstate =1;
					news.setNstate(nstate);
					newsService.edit(news);
				}
				List<News> list = newsService.listall();
				model.addAttribute("newsList",list);
					return "redirect:/admin/list.do";
			}

		//删除一条新闻
		@RequestMapping("/delete")
		public String delete(News news,Model model) {
			int H = newsService.delete(news);
			if (H > 0) {
				List<News> list = newsService.listall();
				model.addAttribute("newsList",list);
				return "redirect:/admin/list.do";
			}
			return null;
		}
	

}
