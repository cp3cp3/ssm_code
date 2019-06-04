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
	/*��ͨ�û�ע����Ϣ*/
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

	/*��ͨ�û���¼*/
	public Putong loginpt(Putong putong) {
		System.out.println(putong.getUsername());
		return putongMapper.loginpt(putong);

	}

	/*У���û����Ƿ����*/
	public Putong selectUserame(String username) {
		
		return putongMapper.selectUserame(username);
	}

	//У�������Ƿ��Ѵ���
	public Putong selectEmail(String Email) {
		
		return putongMapper.selectEmail(Email);
	}
	
	/*��ͨ�û����뵽��ͨ�û���ҳ*/
	public List<Recruit> queryAllRecname(SeeRecord seeRecord) {
		
		return putongMapper.queryAllRecname(seeRecord);
	}

	public int getCount() {
		
		return putongMapper.getCount();
	}
	

	/*�޸ĸ�����Ϣǰ��ѯ������Ϣ*/
	public Putong selectUsername(Putong putong) {
		
		return putongMapper.selectUsername(putong);
	}

	/*�޸ĸ�����Ϣ*/
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

	//��ѯ״̬Ϊ0��������
	public List<News> list1() {
		
		return putongMapper.list1();
	}
    /* �ύ���˼���*/
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
	
    /*ģ����ѯ��ҳ*/
	public List<Recruit> queryRecname(String recname, int startPos, int pageSize) {
		
		return putongMapper.queryRecname(recname, startPos, pageSize);
	}

	public int getCount(String recname) {
		
		return putongMapper.getsearchCount(recname);
	}

	/*����֪ͨ*/
	public List<Company> selectgrjl(String username) {
		
		return putongMapper.selectgrjl(username);
	}

	
	
}
