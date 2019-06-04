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
	
	//��ͨ�û�ע����Ϣ
	 int insertpt(Putong putong);
	
	//��ͨ�û���¼
	public Putong loginpt(Putong putong);
	
	
	//У���û����Ƿ��Ѵ���
	Putong selectUserame(String username);
	
	//У�������Ƿ��Ѵ���
	Putong selectEmail(String Email);
	
	/*��ͨ�û����뵽��ͨ�û���ҳ*/
	 List<Recruit> queryAllRecname(SeeRecord seeRecord);
	 int getCount();
	 
	//��ѯ״̬Ϊ0��������
	    public List<News> list1();
	
	/*�޸ĸ�����Ϣǰ��ѯ������Ϣ*/
	Putong selectUsername(Putong putong);
	
	/*�޸ĸ����˺���Ϣ*/
	int updateUsername(Putong putong);
	
	/*�ύ���˼���*/
	int insertGrjl(Person person);
	
	 /*ģ��������ҳ*/
	 List<Recruit> queryRecname(@RequestParam("recname")String recname,int startPos,int pageSize);
	 int getsearchCount(@RequestParam("recname")String recname);
	 
	 /*����֪ͨ*/
	 List<Company> selectgrjl(String username);

}
