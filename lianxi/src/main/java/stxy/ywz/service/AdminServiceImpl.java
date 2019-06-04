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
	/*管理员登录查询*/
	public Admin getNmaeAndPwd(Admin admin) {
		
		return adminmapper.findNameAndPwd(admin);
	}
	/*管理员查询待审核公司代表人账号信息*/
	public List<Company> queryAllCusername(SeeRecord seeRecord) {
		
		return adminmapper.queryAllCusername(seeRecord);
	}
	public int getCount() {
		
		return adminmapper.getCount();
	}
	
	
	/*管理员修改账号前查询本人信息*/
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
	 /*审核公司代表人信息*/
	public int updateCusername(String cusername) {
		
		return adminmapper.updateCusername(cusername);
	}

	
	
	

}
