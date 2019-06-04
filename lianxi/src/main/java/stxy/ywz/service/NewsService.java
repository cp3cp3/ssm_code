package stxy.ywz.service;

import java.util.List;

import stxy.ywz.bean.News;
import stxy.ywz.bean.Pages;

public interface NewsService {
	//增加一条新闻
		public void insert(News news);
		
		//查询所有新闻
	    public List<News> list(Pages page);
	    
		//查询所有新闻
	    public List<News> listall();
	    
	  //搜索总数量
	    public Integer searchTotalCount(Pages page);
	    
		//查询状态为0所有新闻
	    public List<News> list1();
		
		//通过iD查找一个新闻
		public News selectoneByPrimaryKey(Integer nid);
		
		//修改新闻信息
		public int update(News news);
		
		//修改新闻状态
		public int edit(News news);
		
		//删除一条新闻
		public int delete(News news);

}
