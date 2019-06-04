package stxy.ywz.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import stxy.ywz.bean.Company;
import stxy.ywz.bean.News;
import stxy.ywz.bean.Person;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;

public interface CompanyService {
	/*公司代表人注册*/
	boolean companyreg(Company company);
	
	/*校验用户名*/
    Company getCusername(String cusername);
    
    /*校验公司名*/
    Company getCname(String cname);
    
	
    /*公司代表人登录*/
    Company getCuserAndPwd(Company company);
    
    /*公司代表人进入到公司首页*/
	List<Recruit> queryAllRecname(SeeRecord seeRecord);
	 int getCount();
	 
	//查询状态为0所有新闻
	    public List<News> list1();
    
    /*修改账号信息前查询*/
    Company getName(String cusername);
    
   /* 修改帐号信息*/
    boolean updateCusername(Company company);
    
    /*模糊搜索分页*/
	 List<Recruit> queryRecname(String recname,int startPos,int pageSize);
	 int getCount(String recname);
	 
	 /*待面试用户简历*/
	 List<Person> queryWaitPerson(@RequestParam("cusername")String cusername,int startPos,int pageSize);
	 int getCountPerson(@RequestParam("cusername")String cusername);
	 /* 删除已面试用户简历*/
	 boolean deleteWaitPerson(int resumeid);
}
