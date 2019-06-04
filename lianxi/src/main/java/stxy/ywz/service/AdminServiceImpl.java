package stxy.ywz.service;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stxy.ywz.bean.Admin;
import stxy.ywz.bean.Company;
import stxy.ywz.bean.SeeRecord;
import stxy.ywz.mapper.AdminMapper;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminMapper adminmapper;
	/*����Ա��¼��ѯ*/
	public Admin getNmaeAndPwd(Admin admin) {
		
		return adminmapper.findNameAndPwd(admin);
	}
	/*����Ա��ѯ����˹�˾�������˺���Ϣ*/
	public List<Company> queryAllCusername(SeeRecord seeRecord) {
		
		return adminmapper.queryAllCusername(seeRecord);
	}
	public int getCount() {
		
		return adminmapper.getCount();
	}
	
	
	/*����Ա�޸��˺�ǰ��ѯ������Ϣ*/
	public Admin getAcusername(String ausername) {
		
		return adminmapper.selectAusername(ausername);
	}
	public boolean updateAusername(Admin admin) {
		boolean flag=false;
		try {
			int i=adminmapper.updateAusername(admin);
			if(i>0) {
				flag=true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return flag; 
	
	}
	 /*��˹�˾��������Ϣ*/
	public int updateCusername(String cusername) {
		
		return adminmapper.updateCusername(cusername);
	}

	
	
	

}
