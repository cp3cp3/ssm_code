package stxy.ywz.service;

import java.util.List;

import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecordy;

public interface PageYCYService {
  
	/*�ҳ����п�����Ƹ��Ϣ*/
	 List<Recruit> queryAllRecruit(SeeRecordy seeRecordy);
	 int getCount();
	 List<Recruit> querybRecruit(SeeRecordy seeRecordy);
	 int getCountb(String cusername);
} 
