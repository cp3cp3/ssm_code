package stxy.ywz.service;

import java.util.List;

import stxy.ywz.bean.News;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;

public interface OtherService {
	/*�ҳ����п�����Ƹ��Ϣ*/
	 List<Recruit> queryAllRecname(SeeRecord seeRecord);
	 int getCount();
	 
	 /*ģ��������ҳ*/
	 List<Recruit> queryRecname(String recname,int startPos,int pageSize);
	 int getCount(String recname);

}
