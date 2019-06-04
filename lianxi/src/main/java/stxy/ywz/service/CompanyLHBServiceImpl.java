package stxy.ywz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stxy.ywz.bean.Person;
import stxy.ywz.mapper.CompanyLHBMapper;


@Service
public class CompanyLHBServiceImpl implements CompanyLHBService  {

	@Autowired
	private CompanyLHBMapper companyLHBMapper;
	
	//查询简历
	public List<Person> findGSperson(String cusername) {


		return companyLHBMapper.findGSperson(cusername);
	}

		//删除简历
	public int deletePerson(int resumeid) {
		return companyLHBMapper.deletePerson(resumeid);
	}

		//录取个人简历
	public boolean luquPerson(int resumeid) {
		boolean flag=false;
		try {
			int i=companyLHBMapper.luquPerson(resumeid);
			if(i>0){
				flag= true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag; 
	}
	
	
}
