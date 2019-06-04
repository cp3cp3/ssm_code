package stxy.ywz.mapper;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import stxy.ywz.bean.Company;
import stxy.ywz.bean.News;
import stxy.ywz.bean.Person;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;

public interface CompanyMapper {
	/*注册公司代表人信息*/
	int insertCompany(Company company);
	
	/*校验用户名*/
	Company selectCuserame(String cusuername);
	
	/*校验公司名*/
	Company selectCname(String cname);
	
	/*公司代表人登录*/
	Company findCuserAndPwd(Company company);
	
	/*公司代表人进入到公司首页*/
	 List<Recruit> queryAllRecname(SeeRecord seeRecord);
	 int getCount();
	
	/*修改账号前查询本人信息*/
	Company selectName(String cusername);
	
	/*进行修改公司账号信息*/
	int updateCusername(Company company);
	
	//查询状态为0所有新闻
    public List<News> list1();
    
    /*模糊搜索分页*/
	 List<Recruit> queryRecname(@RequestParam("recname")String recname,int startPos,int pageSize);
	 int getsearchCount(@RequestParam("recname")String recname);

	 /*待面试用户简历*/
	 List<Person> queryWaitPerson(@RequestParam("cusername")String cusername,int startPos,int pageSize);
	 int getCountPerson(@RequestParam("cusername")String cusername);
	 
	/* 删除已面试用户简历*/
	 boolean deleteWaitPerson(int resumeid);
}
