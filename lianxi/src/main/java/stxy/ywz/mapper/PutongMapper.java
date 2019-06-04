package stxy.ywz.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import stxy.ywz.bean.Company;
import stxy.ywz.bean.News;
import stxy.ywz.bean.Person;
import stxy.ywz.bean.Putong;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;


@Repository
public interface PutongMapper {
	
	//普通用户注册信息
	 int insertpt(Putong putong);
	
	//普通用户登录
	public Putong loginpt(Putong putong);
	
	
	//校验用户名是否已存在
	Putong selectUserame(String username);
	
	//校验邮箱是否已存在
	Putong selectEmail(String Email);
	
	/*普通用户进入到普通用户首页*/
	 List<Recruit> queryAllRecname(SeeRecord seeRecord);
	 int getCount();
	 
	//查询状态为0所有新闻
	    public List<News> list1();
	
	/*修改个人信息前查询本人信息*/
	Putong selectUsername(Putong putong);
	
	/*修改个人账号信息*/
	int updateUsername(Putong putong);
	
	/*提交个人简历*/
	int insertGrjl(Person person);
	
	 /*模糊搜索分页*/
	 List<Recruit> queryRecname(@RequestParam("recname")String recname,int startPos,int pageSize);
	 int getsearchCount(@RequestParam("recname")String recname);
	 
	 /*简历通知*/
	 List<Company> selectgrjl(String username);

}
