package stxy.ywz.bean;

public class Recruit {
	
	private int recid;//ID��
	private String recname;//ְҵ��
	private String type;//ְҵ����
	private String degree;//ѧ��
	private int experience;//����
	private int extent;//��н
	private String address;//��ַ
	private String cusername;//��˾������
	private int rstate;//״̬
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
