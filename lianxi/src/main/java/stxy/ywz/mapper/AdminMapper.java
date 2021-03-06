package stxy.ywz.mapper;

import java.util.List;

import stxy.ywz.bean.Admin;
import stxy.ywz.bean.Company;
import stxy.ywz.bean.SeeRecord;

public interface AdminMapper {

	/*管理员登录查询*/
	Admin findNameAndPwd(Admin admin);
	
	/*管理员修改信息前查询本人信息*/
	Admin selectAusername(String ausername);
	
	/*管理员提交修改的个人信息*/
	int updateAusername(Admin admin);
	
	/*管理员查询待审核公司代表人账号信息*/
	 List<Company> queryAllCusername(SeeRecord seeRecord);
	 int getCount();
	 
	 /*审核公司代表人信息*/
	 int updateCusername(String cusername);
}
