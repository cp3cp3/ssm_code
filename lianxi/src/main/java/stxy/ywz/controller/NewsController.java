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
		
		//�������
		@RequestMapping("/save")
		public String save(News news) {
			newsService.insert(news);
			return "redirect:/admin/list.do";
		}
		
		@RequestMapping("/list")
		public String searchInvList(Pages page,HttpServletRequest request) throws UnsupportedEncodingException {

	        //��װpage����,���뷽���в�ѯ�б� ��������
	        Pages p =page;
	       System.out.println(page.getPageNow());
	        int pageSize=4; //����ÿҳ��С
	        p.setPageSize(pageSize);
	        int pageNow=p.getPageNow();
	        
	        //����ǰҳ��Ϊ0ʱת���1
	        if (pageNow==0) {
	        	pageNow=1;
	            p.setPageNow(pageNow);
	        }
	        int startPos =page.getStartPos();
	        
	        if (!(p.getPageNow()==0)) {
	        	startPos = getStartRowBycurrentPage(pageNow, pageSize);
	        }        
	        p.setStartPos(startPos);       

	        Integer totalCount = newsService.searchTotalCount(page);//������

	        int totalPageCount=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);//��ҳ��=������/ҳ��С+1

	        p.setTotalPageCount(totalPageCount);//��ҳ��

	        page.setTotalCount(totalCount);//������
	        
	        if(page.getPageNow()>page.getTotalPageCount()) {
	        	request.setAttribute("message", "�ѵ�ҳβ���޷���ʾ��һҳ");
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

		
		//����״̬Ϊ0���б�
			@RequestMapping("/list1")
			public String list1(Model model) {
				List<News> H = newsService.list1();
				model.addAttribute("newsList",H);
				return "common/newslist";
			}

		//ͨ������id��ѯ��������
		@RequestMapping("/nid")
		public String selectoneByPrimaryKey(@RequestParam("nid") Integer nid,Model model) {
			News H = newsService.selectoneByPrimaryKey(nid);
			model.addAttribute("newsList",H);
			return "admins/news_edit";
		}

		//�޸�һ��������Ϣ
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
		
		//��������״̬
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

		//ɾ��һ������
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
