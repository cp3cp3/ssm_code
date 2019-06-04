package stxy.ywz.mapper;

import java.util.List;

import stxy.ywz.bean.Person;

public interface CompanyLHBMapper {
	
	/*公司查询待审核个人简历信息*/
	List<Person> findGSperson(String cusername);
	
	/*公司删除个人简历*/
	int deletePerson(int resumeid);
	
	/*管理员录取个人简历*/
	int luquPerson(int resumeid);

}
