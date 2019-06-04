package stxy.ywz.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import stxy.ywz.bean.Company;
import stxy.ywz.bean.News;
import stxy.ywz.bean.Person;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;

public interface CompanyService {
	/*��˾������ע��*/
	boolean companyreg(Company company);
	
	/*У���û���*/
    Company getCusername(String cusername);
    
    /*У�鹫˾��*/
    Company getCname(String cname);
    
	
    /*��˾�����˵�¼*/
    Company getCuserAndPwd(Company company);
    
    /*��˾�����˽��뵽��˾��ҳ*/
	List<Recruit> queryAllRecname(SeeRecord seeRecord);
	 int getCount();
	 
	//��ѯ״̬Ϊ0��������
	    public List<News> list1();
    
    /*�޸��˺���Ϣǰ��ѯ*/
    Company getName(String cusername);
    
   /* �޸��ʺ���Ϣ*/
    boolean updateCusername(Company company);
    
    /*ģ��������ҳ*/
	 List<Recruit> queryRecname(String recname,int startPos,int pageSize);
	 int getCount(String recname);
	 
	 /*�������û�����*/
	 List<Person> queryWaitPerson(@RequestParam("cusername")String cusername,int startPos,int pageSize);
	 int getCountPerson(@RequestParam("cusername")String cusername);
	 /* ɾ���������û�����*/
	 boolean deleteWaitPerson(int resumeid);
}
