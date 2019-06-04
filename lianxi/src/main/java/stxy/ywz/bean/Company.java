package stxy.ywz.bean;

public class Company {
	private String cusername;//公司代表人账号
	private String password;//密码
	private String cname;//公司名
	private String email;//邮箱
	private String address;//地址
	private int cstate;//状态
	public String getCusername() {
		return cusername;
	}
	public void setCusername(String cusername) {
		this.cusername = cusername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCstate() {
		return cstate;
	}
	public void setCstate(int cstate) {
		this.cstate = cstate;
	}
	@Override
	public String toString() {
		return "Company [cusername=" + cusername + ", password=" + password + ", cname=" + cname + ", email=" + email
				+ ", address=" + address + ", cstate=" + cstate + "]";
	}
	public Company(String cusername, String password, String cname, String email, String address, int cstate) {
		super();
		this.cusername = cusername;
		this.password = password;
		this.cname = cname;
		this.email = email;
		this.address = address;
		this.cstate = cstate;
	}
	public Company() {
		super();
	}
	
	
}
