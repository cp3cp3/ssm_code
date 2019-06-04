package stxy.ywz.service;

import java.util.List;

import stxy.ywz.bean.News;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;

public interface OtherService {
	/*找出所有可用招聘信息*/
	 List<Recruit> queryAllRecname(SeeRecord seeRecord);
	 int getCount();
	 
	 /*模糊搜索分页*/
	 List<Recruit> queryRecname(String recname,int startPos,int pageSize);
	 int getCount(String recname);

}
