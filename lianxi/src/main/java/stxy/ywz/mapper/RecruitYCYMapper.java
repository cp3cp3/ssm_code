package stxy.ywz.mapper;


import java.util.List;


import stxy.ywz.bean.Recruit;

public interface RecruitYCYMapper {
	
	public void insert(Recruit recruit);
	public List<Recruit> list();
	public List<Recruit> adlist();
	public List<Recruit> blist(String cusername);
	public int bupdate(Recruit recruit);
	public Recruit listbyid(Integer recid);
	public int bdelete(Integer recid);
	public int addelete(Integer recid);
	public int countsum();
	public List<Recruit> pagelist();
	
}
