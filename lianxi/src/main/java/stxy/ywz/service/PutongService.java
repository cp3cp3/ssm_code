package stxy.ywz.service;

import java.util.List;

import stxy.ywz.bean.Company;
import stxy.ywz.bean.News;
import stxy.ywz.bean.Person;
import stxy.ywz.bean.Putong;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;

public interface PutongService {
	
	//��ͨ�û�ע����Ϣ
		 boolean insertpt(Putong putong);
		
		//��ͨ�û���¼
		public Putong loginpt(Putong putong);

		//У���û����Ƿ��Ѵ���
		Putong selectUserame(String username);
		
		//У�������Ƿ��Ѵ���
		Putong selectEmail(String Email);
		
		/*��ͨ�û����뵽��ͨ�û���ҳ*/
		List<Recruit> queryAllRecname(SeeRecord seeRecord);
		 int getCount();
		 
		
		/*�޸ĸ�����Ϣǰ��ѯ������Ϣ*/
		Putong selectUsername(Putong putong);
		
		/*�޸ĸ����˺���Ϣ*/
		boolean updateUsername(Putong putong);
		
		//��ѯ״̬Ϊ0��������
	    public List<News> list1();
	    
	    /*�ύ���˼���*/
		boolean insertGrjl(Person person);
		
		 /*ģ��������ҳ*/
		 List<Recruit> queryRecname(String recname,int startPos,int pageSize);
		 int getCount(String recname);
		 
		 /*����֪ͨ*/
		 List<Company> selectgrjl(String username);
}
