package stxy.ywz.mapper;

import java.util.List;

import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecordy;

public interface PageYCYMapper {

	/*找出所有可用招聘信息*/
	 List<Recruit> queryAllRecruit(SeeRecordy seeRecordy);
	 List<Recruit> querybRecruit(SeeRecordy seeRecordy);
	 int getCount();
	 int getCountb(String cusername);
}

