package stxy.ywz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stxy.ywz.bean.Company;
import stxy.ywz.bean.News;
import stxy.ywz.bean.Person;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;
import stxy.ywz.mapper.CompanyMapper;

@Service
public class CompanyServiceImpl implements CompanyService {
	
	@Autowired
	private CompanyMapper companymapper;
	private boolean flag;

	/*注册公司代表人信息*/
	public boolean companyreg(Company company) {
		try {
		/*boolean flag = false;*/
		  int i=companymapper.insertCompany(company);
		  if(i>0) {
			  flag=true;
		  }
		}catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		  return flag;
	}

   /*验证用户名是否存在*/
	public Company getCusername(String cusername) {
		return companymapper.selectCuserame(cusername);
	}

	/*验证公司是否已入驻*/
	public Company getCname(String cname) {
		
		return companymapper.selectCname(cname);
	}

	
	/*公司代表人登录验证*/
	public Company getCuserAndPwd(Company company) {
		
		return companymapper.findCuserAndPwd(company);
	}
	/*公司代表人进入到公司首页*/
	public List<Recruit> queryAllRecname(SeeRecord seeRecord) {
		
		return companymapper.queryAllRecname(seeRecord);
	}

	public int getCount() {
		
		return companymapper.getCount();
	}

	/*修改帐号信息前查询*/
	public Company getName(String cusername) {
		
		return companymapper.selectName(cusername);
	}
    /*修改个人账号信息*/
	public boolean updateCusername(Company company) {
		boolean flag=false;
		try {
		    int i=companymapper.updateCusername(company);
			if(i>0) {
				flag=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	//查询状态为0所有新闻
	public List<News> list1() {
		
		return companymapper.list1();
	}

	/*模糊搜索分页*/
	public List<Recruit> queryRecname(String recname, int startPos, int pageSize) {
		
		return companymapper.queryRecname(recname, startPos, pageSize);
	}

	public int getCount(String recname) {
		
		return companymapper.getsearchCount(recname);
	}

	 /*待面试用户简历*/
	public List<Person> queryWaitPerson(String cusername, int startPos, int pageSize) {
		
		return companymapper.queryWaitPerson(cusername, startPos, pageSize);
	}

	public int getCountPerson(String cusername) {
		
		return companymapper.getCountPerson(cusername);
	}
	/* 删除已面试用户简历*/
	public boolean deleteWaitPerson(int resumeid) {
		
		return companymapper.deleteWaitPerson(resumeid);
	}

	

	
   



}
