package stxy.ywz.service;

import java.sql.ResultSet;
import java.util.List;

import stxy.ywz.bean.Admin;
import stxy.ywz.bean.Company;
import stxy.ywz.bean.SeeRecord;

public interface AdminService {
	/*����Ա��½��ѯ*/
	Admin getNmaeAndPwd(Admin admin);
	
	 /*����Ա�޸��˺���Ϣǰ��ѯ������Ϣ*/
	Admin getAcusername(String ausername);
	
	/*����Ա�ύ�޸ĵĸ�����Ϣ*/
	boolean updateAusername(Admin admin);
	
	
	/*����Ա��ѯ����˹�˾�������˺���Ϣ*/
	//List<Company> findAllcusername();
	 List<Company> queryAllCusername(SeeRecord seeRecord);
	 int getCount();
	 
	 /*��˹�˾��������Ϣ*/
	 int updateCusername(String cusername);
	

}
