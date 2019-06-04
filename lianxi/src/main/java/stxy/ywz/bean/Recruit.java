package stxy.ywz.bean;

public class Recruit {
	
	private int recid;//ID号
	private String recname;//职业名
	private String type;//职业类型
	private String degree;//学历
	private int experience;//经验
	private int extent;//月薪
	private String address;//地址
	private String cusername;//公司代表人
	private int rstate;//状态
	public int getRecid() {
		return recid;
	}
	public void setRecid(int recid) {
		this.recid = recid;
	}
	public String getRecname() {
		return recname;
	}
	public void setRecname(String recname) {
		this.recname = recname;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public int getExtent() {
		return extent;
	}
	public void setExtent(int extent) {
		this.extent = extent;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCusername() {
		return cusername;
	}
	public void setCusername(String cusername) {
		this.cusername = cusername;
	}
	public int getRstate() {
		return rstate;
	}
	public void setRstate(int rstate) {
		this.rstate = rstate;
	}
	@Override
	public String toString() {
		return "Recruit [recid=" + recid + ", recname=" + recname + ", type=" + type + ", degree=" + degree
				+ ", experience=" + experience + ", extent=" + extent + ", address=" + address + ", cusername="
				+ cusername + ", rstate=" + rstate + "]";
	}
	public Recruit(int recid, String recname, String type, String degree, int experience, int extent, String address,
			String cusername, int rstate) {
		super();
		this.recid = recid;
		this.recname = recname;
		this.type = type;
		this.degree = degree;
		this.experience = experience;
		this.extent = extent;
		this.address = address;
		this.cusername = cusername;
		this.rstate = rstate;
	}
	public Recruit() {
		super();
	}
	

}
