package stxy.ywz.mapper;

import java.util.List;


import stxy.ywz.bean.Person;

public interface AdminLHBMapper {
	/*����Ա��ѯ����˸��˼�����Ϣ*/
	List<Person> findAllperson();
	
	/*����Աɾ�����˼���*/
	int updatePerson(int resumeid);

}
