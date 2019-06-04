package stxy.ywz.mapper;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;

import stxy.ywz.bean.Company;
import stxy.ywz.bean.News;
import stxy.ywz.bean.Person;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;

public interface CompanyMapper {
	/*ע�ṫ˾��������Ϣ*/
	int insertCompany(Company company);
	
	/*У���û���*/
	Company selectCuserame(String cusuername);
	
	/*У�鹫˾��*/
	Company selectCname(String cname);
	
	/*��˾�����˵�¼*/
	Company findCuserAndPwd(Company company);
	
	/*��˾�����˽��뵽��˾��ҳ*/
	 List<Recruit> queryAllRecname(SeeRecord seeRecord);
	 int getCount();
	
	/*�޸��˺�ǰ��ѯ������Ϣ*/
	Company selectName(String cusername);
	
	/*�����޸Ĺ�˾�˺���Ϣ*/
	int updateCusername(Company company);
	
	//��ѯ״̬Ϊ0��������
    public List<News> list1();
    
    /*ģ��������ҳ*/
	 List<Recruit> queryRecname(@RequestParam("recname")String recname,int startPos,int pageSize);
	 int getsearchCount(@RequestParam("recname")String recname);

	 /*�������û�����*/
	 List<Person> queryWaitPerson(@RequestParam("cusername")String cusername,int startPos,int pageSize);
	 int getCountPerson(@RequestParam("cusername")String cusername);
	 
	/* ɾ���������û�����*/
	 boolean deleteWaitPerson(int resumeid);
}
