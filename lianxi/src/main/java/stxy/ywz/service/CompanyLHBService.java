package stxy.ywz.service;

import java.util.List;

import stxy.ywz.bean.Person;

public interface CompanyLHBService {
	
	
	/*��˾��ѯ���˼�����Ϣ*/
	List<Person> findGSperson(String cusername);

	/*��˾ɾ�����˼���*/
	int deletePerson(int resumeid);
	
	/*��˾¼ȡ���˼���*/
	boolean luquPerson(int resumeid);
	
	
}
