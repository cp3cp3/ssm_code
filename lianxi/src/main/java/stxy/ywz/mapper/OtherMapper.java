package stxy.ywz.mapper;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import stxy.ywz.bean.News;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;



public interface OtherMapper {
	/*�ҳ����п�����Ƹ��Ϣ*/
	 List<Recruit> queryAllRecname(SeeRecord seeRecord);
	 int getCount();
	 
	 /*ģ��������ҳ*/
	 List<Recruit> queryRecname(@RequestParam("recname")String recname,int startPos,int pageSize);
	 int getsearchCount(@RequestParam("recname")String recname);
	

}
