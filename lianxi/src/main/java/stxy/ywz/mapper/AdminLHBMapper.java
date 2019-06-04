package stxy.ywz.mapper;

import java.util.List;


import stxy.ywz.bean.Person;

public interface AdminLHBMapper {
	/*管理员查询待审核个人简历信息*/
	List<Person> findAllperson();
	
	/*管理员删除个人简历*/
	int updatePerson(int resumeid);

}
