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

	/*ע�ṫ˾��������Ϣ*/
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

   /*��֤�û����Ƿ����*/
	public Company getCusername(String cusername) {
		return companymapper.selectCuserame(cusername);
	}

	/*��֤��˾�Ƿ�����פ*/
	public Company getCname(String cname) {
		
		return companymapper.selectCname(cname);
	}

	
	/*��˾�����˵�¼��֤*/
	public Company getCuserAndPwd(Company company) {
		
		return companymapper.findCuserAndPwd(company);
	}
	/*��˾�����˽��뵽��˾��ҳ*/
	public List<Recruit> queryAllRecname(SeeRecord seeRecord) {
		
		return companymapper.queryAllRecname(seeRecord);
	}

	public int getCount() {
		
		return companymapper.getCount();
	}

	/*�޸��ʺ���Ϣǰ��ѯ*/
	public Company getName(String cusername) {
		
		return companymapper.selectName(cusername);
	}
    /*�޸ĸ����˺���Ϣ*/
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

	//��ѯ״̬Ϊ0��������
	public List<News> list1() {
		
		return companymapper.list1();
	}

	/*ģ��������ҳ*/
	public List<Recruit> queryRecname(String recname, int startPos, int pageSize) {
		
		return companymapper.queryRecname(recname, startPos, pageSize);
	}

	public int getCount(String recname) {
		
		return companymapper.getsearchCount(recname);
	}

	 /*�������û�����*/
	public List<Person> queryWaitPerson(String cusername, int startPos, int pageSize) {
		
		return companymapper.queryWaitPerson(cusername, startPos, pageSize);
	}

	public int getCountPerson(String cusername) {
		
		return companymapper.getCountPerson(cusername);
	}
	/* ɾ���������û�����*/
	public boolean deleteWaitPerson(int resumeid) {
		
		return companymapper.deleteWaitPerson(resumeid);
	}

	

	
   



}
