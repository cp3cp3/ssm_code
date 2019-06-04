package stxy.ywz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stxy.ywz.bean.News;
import stxy.ywz.bean.Recruit;
import stxy.ywz.bean.SeeRecord;
import stxy.ywz.mapper.OtherMapper;

@Service
public class OtherServiceImpl implements OtherService {

	@Autowired
	private OtherMapper othermapper;
	/*�ҳ����п�����Ƹ��Ϣ*/
	public List<Recruit> queryAllRecname(SeeRecord seeRecord) {
		
		return othermapper.queryAllRecname(seeRecord);
	}

	public int getCount() {
		
		return othermapper.getCount();
	}

	/*ģ��������ҳ*/
	public List<Recruit> queryRecname(String recname,int startPos,int pageSize) {
		
		return othermapper.queryRecname(recname,startPos,pageSize);
	}

	public int getCount(String recname) {
		
		return othermapper.getsearchCount(recname);
	}

}
