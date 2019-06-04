package stxy.ywz.service;

import java.util.List;

import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecordy;

public interface PageYCYService {
  
	/*找出所有可用招聘信息*/
	 List<Recruit> queryAllRecruit(SeeRecordy seeRecordy);
	 int getCount();
	 List<Recruit> querybRecruit(SeeRecordy seeRecordy);
	 int getCountb(String cusername);
} 
