package stxy.ywz.bean;

public class Person {
	private int resumeid;
	private String cusername;//��˾������
	private String username;//��ͨ�û�
	private String uname;//��ͨ�û���ʵ����
	private String sex;//�Ա�
	private String skill;//��ְ��λ
	private int experience;//*������
	private String degree;//ѧ��
	private String appraise;//��������
	private String email;//����
	private int pstate;
	public int getResumeid() {
		return resumeid;
	}
	public void setResumeid(int resumeid) {
		this.resumeid = resumeid;
	}
	public String getCusername() {
		return cusername;
	}
	public void setCusername(String cusername) {
		this.cusername = cusername;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public int getExperience() {
		return experience;
	}
	public void setExperience(int experience) {
		this.experience = experience;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getAppraise() {
		return appraise;
	}
	public void setAppraise(String appraise) {
		this.appraise = appraise;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getPstate() {
		return pstate;
	}
	public void setPstate(int pstate) {
		this.pstate = pstate;
	}
	@Override
	public String toString() {
		return "Person [resumeid=" + resumeid + ", cusername=" + cusername + ", username=" + username + ", uname="
				+ uname + ", sex=" + sex + ", skill=" + skill + ", experience=" + experience + ", degree=" + degree
				+ ", appraise=" + appraise + ", email=" + email + ", pstate=" + pstate + "]";
	}
	public Person() {
		super();
	}
	public Person(int resumeid, String cusername, String username, String uname, String sex, String skill,
			int experience, String degree, String appraise, String email, int pstate) {
		super();
		this.resumeid = resumeid;
		this.cusername = cusername;
		this.username = username;
		this.uname = uname;
		this.sex = sex;
		this.skill = skill;
		this.experience = experience;
		this.degree = degree;
		this.appraise = appraise;
		this.email = email;
		this.pstate = pstate;
	}
	

}
