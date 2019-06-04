package stxy.ywz.service;

import java.util.List;
import stxy.ywz.bean.Person;

public interface AdminLHBService {
	
	/*管理员删除个人简历*/
	boolean updatePerson(int resumeid);
	
	/*管理员查询个人简历信息*/
	List<Person> findAllperson();

}
