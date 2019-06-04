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
	
	//��ѯ����
	public List<Person> findGSperson(String cusername) {


		return companyLHBMapper.findGSperson(cusername);
	}

		//ɾ������
	public int deletePerson(int resumeid) {
		return companyLHBMapper.deletePerson(resumeid);
	}

		//¼ȡ���˼���
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
