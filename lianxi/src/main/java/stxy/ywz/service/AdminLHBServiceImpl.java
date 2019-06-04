package stxy.ywz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stxy.ywz.bean.Person;
import stxy.ywz.mapper.AdminLHBMapper;

@Service
public class AdminLHBServiceImpl implements AdminLHBService {
	@Autowired
	private AdminLHBMapper adminLHBMapper;
	
	
		/*管理员删除个人简历*/
	public boolean updatePerson(int resumeid) {
		boolean flag=false;
		try {
			int i=adminLHBMapper.updatePerson(resumeid);
			if(i>0){
				flag= true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag; 


	}
		//管理员查询个人简历
	public List<Person> findAllperson() {
		return adminLHBMapper.findAllperson();
		
	}

}
