package stxy.ywz.mapper;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import stxy.ywz.bean.News;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;



public interface OtherMapper {
	/*找出所有可用招聘信息*/
	 List<Recruit> queryAllRecname(SeeRecord seeRecord);
	 int getCount();
	 
	 /*模糊搜索分页*/
	 List<Recruit> queryRecname(@RequestParam("recname")String recname,int startPos,int pageSize);
	 int getsearchCount(@RequestParam("recname")String recname);
	

}
