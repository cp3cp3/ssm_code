package stxy.ywz.mapper;

import java.util.List;

import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecordy;

public interface PageYCYMapper {

	/*�ҳ����п�����Ƹ��Ϣ*/
	 List<Recruit> queryAllRecruit(SeeRecordy seeRecordy);
	 List<Recruit> querybRecruit(SeeRecordy seeRecordy);
	 int getCount();
	 int getCountb(String cusername);
}

