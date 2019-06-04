package stxy.ywz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stxy.ywz.bean.Company;
import stxy.ywz.bean.News;
import stxy.ywz.bean.Person;
import stxy.ywz.bean.Putong;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;
import stxy.ywz.mapper.PutongMapper;


@Service
public class PutongServiceImpl implements PutongService {
	
	@Autowired
	private PutongMapper putongMapper;

	private boolean flag;
	/*普通用户注册信息*/
	public boolean insertpt(Putong putong) {
		
		try {
			int i= putongMapper.insertpt(putong);
		if(i>0) {
			  flag=true;
		  }
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		  return flag;
	}

	/*普通用户登录*/
	public Putong loginpt(Putong putong) {
		System.out.println(putong.getUsername());
		return putongMapper.loginpt(putong);

	}

	/*校验用户名是否存在*/
	public Putong selectUserame(String username) {
		
		return putongMapper.selectUserame(username);
	}

	//校验邮箱是否已存在
	public Putong selectEmail(String Email) {
		
		return putongMapper.selectEmail(Email);
	}
	
	/*普通用户进入到普通用户首页*/
	public List<Recruit> queryAllRecname(SeeRecord seeRecord) {
		
		return putongMapper.queryAllRecname(seeRecord);
	}

	public int getCount() {
		
		return putongMapper.getCount();
	}
	

	/*修改个人信息前查询本人信息*/
	public Putong selectUsername(Putong putong) {
		
		return putongMapper.selectUsername(putong);
	}

	/*修改个人信息*/
	public boolean updateUsername(Putong putong) {
		try {
		int i=putongMapper.updateUsername(putong);
		if(i>0) 
			return flag=true;;
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	//查询状态为0所有新闻
	public List<News> list1() {
		
		return putongMapper.list1();
	}
    /* 提交个人简历*/
	public boolean insertGrjl(Person person) {
		try {
			int i=putongMapper.insertGrjl(person);
			if(i>0) {
				  flag=true;
			  }
			}catch (Exception e) {
				e.printStackTrace();
				
			}
			  return flag;
	}
	
    /*模糊查询分页*/
	public List<Recruit> queryRecname(String recname, int startPos, int pageSize) {
		
		return putongMapper.queryRecname(recname, startPos, pageSize);
	}

	public int getCount(String recname) {
		
		return putongMapper.getsearchCount(recname);
	}

	/*简历通知*/
	public List<Company> selectgrjl(String username) {
		
		return putongMapper.selectgrjl(username);
	}

	
	
}
