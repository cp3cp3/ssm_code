package stxy.ywz.mapper;

import java.util.List;

import stxy.ywz.bean.Admin;
import stxy.ywz.bean.Company;
import stxy.ywz.bean.SeeRecord;

public interface AdminMapper {

	/*����Ա��¼��ѯ*/
	Admin findNameAndPwd(Admin admin);
	
	/*����Ա�޸���Ϣǰ��ѯ������Ϣ*/
	Admin selectAusername(String ausername);
	
	/*����Ա�ύ�޸ĵĸ�����Ϣ*/
	int updateAusername(Admin admin);
	
	/*����Ա��ѯ����˹�˾�������˺���Ϣ*/
	 List<Company> queryAllCusername(SeeRecord seeRecord);
	 int getCount();
	 
	 /*��˹�˾��������Ϣ*/
	 int updateCusername(String cusername);
}
