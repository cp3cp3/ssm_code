package stxy.ywz.mapper;

import java.util.List;

import stxy.ywz.bean.Person;

public interface CompanyLHBMapper {
	
	/*��˾��ѯ����˸��˼�����Ϣ*/
	List<Person> findGSperson(String cusername);
	
	/*��˾ɾ�����˼���*/
	int deletePerson(int resumeid);
	
	/*����Ա¼ȡ���˼���*/
	int luquPerson(int resumeid);

}
