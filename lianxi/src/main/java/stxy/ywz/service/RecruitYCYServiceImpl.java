package stxy.ywz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import stxy.ywz.bean.Recruit;
import stxy.ywz.mapper.RecruitYCYMapper;
@Service
public class RecruitYCYServiceImpl implements RecruitYCYService {
	
	@Autowired
	private RecruitYCYMapper recruitYCYMapper;

	public void insert(Recruit recruit) {
		recruitYCYMapper.insert(recruit);

	}

	public List<Recruit> list() {
		
		return recruitYCYMapper.list();
	}

	public List<Recruit> blist(String cusername) {
		
		return recruitYCYMapper.blist(cusername);
	}

	public int bupdate(Recruit recruit) {
		
		return recruitYCYMapper.bupdate(recruit);
	}

	public Recruit listbyid(Integer recid) {
		
		return recruitYCYMapper.listbyid(recid);
	}

	public int bdelete(Integer recid) {
		
		return recruitYCYMapper.bdelete(recid);
	}

	public List<Recruit> adlist() {
		
		return recruitYCYMapper.adlist();
	}

	public int addelete(Integer recid) {
		
		return recruitYCYMapper.addelete(recid);
	}

	public int countsum() {
		
		return recruitYCYMapper.countsum();
	}

}
