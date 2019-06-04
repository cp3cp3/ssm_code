package stxy.ywz.service;

import java.util.List;

import stxy.ywz.bean.Company;
import stxy.ywz.bean.News;
import stxy.ywz.bean.Person;
import stxy.ywz.bean.Putong;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;

public interface PutongService {
	
	//普通用户注册信息
		 boolean insertpt(Putong putong);
		
		//普通用户登录
		public Putong loginpt(Putong putong);

		//校验用户名是否已存在
		Putong selectUserame(String username);
		
		//校验邮箱是否已存在
		Putong selectEmail(String Email);
		
		/*普通用户进入到普通用户首页*/
		List<Recruit> queryAllRecname(SeeRecord seeRecord);
		 int getCount();
		 
		
		/*修改个人信息前查询本人信息*/
		Putong selectUsername(Putong putong);
		
		/*修改个人账号信息*/
		boolean updateUsername(Putong putong);
		
		//查询状态为0所有新闻
	    public List<News> list1();
	    
	    /*提交个人简历*/
		boolean insertGrjl(Person person);
		
		 /*模糊搜索分页*/
		 List<Recruit> queryRecname(String recname,int startPos,int pageSize);
		 int getCount(String recname);
		 
		 /*简历通知*/
		 List<Company> selectgrjl(String username);
}
