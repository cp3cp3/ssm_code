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
	
	
		/*����Աɾ�����˼���*/
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
		//����Ա��ѯ���˼���
	public List<Person> findAllperson() {
		return adminLHBMapper.findAllperson();
		
	}

}
