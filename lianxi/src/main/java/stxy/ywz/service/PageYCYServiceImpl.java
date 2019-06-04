package stxy.ywz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecordy;
import stxy.ywz.mapper.PageYCYMapper;

@Service
public class PageYCYServiceImpl implements PageYCYService {
	@Autowired
	private PageYCYMapper pageYCYMapper;

	public List<Recruit> queryAllRecruit(SeeRecordy seeRecordy) {
		
		return pageYCYMapper.queryAllRecruit(seeRecordy);
	}
  
	public int getCount() {
		
		return pageYCYMapper.getCount();
	}

	public List<Recruit> querybRecruit(SeeRecordy seeRecordy) {
		
		return pageYCYMapper.querybRecruit(seeRecordy);
	}

	public int getCountb(String cusername) {
		
		return pageYCYMapper.getCountb(cusername);
	}

	
}
