package stxy.ywz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stxy.ywz.bean.News;
import stxy.ywz.bean.Pages;
import stxy.ywz.mapper.NewsMapper;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsMapper newsMapper;

	public void insert(News news) {
		newsMapper.insert(news);
	}

	public List<News> list(Pages page) {
		return newsMapper.list(page);
	}
	public Integer searchTotalCount(Pages page) {
		return newsMapper.searchTotalCount(page);
	}

	public News selectoneByPrimaryKey(Integer nid) {
		return newsMapper.selectoneByPrimaryKey(nid);
	}

	public int update(News news) {		
		return newsMapper.update(news);
	}

	public int delete(News news) {		
		return newsMapper.delete(news);
	}

		public int edit(News news) {		
		return newsMapper.edit(news);
	}

		public List<News> list1() {
			return newsMapper.list1();
		}

		public List<News> listall() {
			return newsMapper.listall();
		}


}
