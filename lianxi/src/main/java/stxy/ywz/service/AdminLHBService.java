package stxy.ywz.service;

import java.util.List;
import stxy.ywz.bean.Person;

public interface AdminLHBService {
	
	/*����Աɾ�����˼���*/
	boolean updatePerson(int resumeid);
	
	/*����Ա��ѯ���˼�����Ϣ*/
	List<Person> findAllperson();

}
