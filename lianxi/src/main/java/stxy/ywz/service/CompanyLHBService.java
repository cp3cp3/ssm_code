package stxy.ywz.service;

import java.util.List;

import stxy.ywz.bean.Person;

public interface CompanyLHBService {
	
	
	/*公司查询个人简历信息*/
	List<Person> findGSperson(String cusername);

	/*公司删除个人简历*/
	int deletePerson(int resumeid);
	
	/*公司录取个人简历*/
	boolean luquPerson(int resumeid);
	
	
}
