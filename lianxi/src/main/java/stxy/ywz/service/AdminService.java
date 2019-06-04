package stxy.ywz.service;

import java.sql.ResultSet;
import java.util.List;

import stxy.ywz.bean.Admin;
import stxy.ywz.bean.Company;
import stxy.ywz.bean.SeeRecord;

public interface AdminService {
	/*管理员登陆查询*/
	Admin getNmaeAndPwd(Admin admin);
	
	 /*管理员修改账号信息前查询本人信息*/
	Admin getAcusername(String ausername);
	
	/*管理员提交修改的个人信息*/
	boolean updateAusername(Admin admin);
	
	
	/*管理员查询待审核公司代表人账号信息*/
	//List<Company> findAllcusername();
	 List<Company> queryAllCusername(SeeRecord seeRecord);
	 int getCount();
	 
	 /*审核公司代表人信息*/
	 int updateCusername(String cusername);
	

}
