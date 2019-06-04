package stxy.ywz.bean;

public class Admin {
	
	private int id;
	private String ausername;//¹ÜÀíÔ±ÕËºÅ
	private String password;//ÃÜÂë
	private String email;//ÓÊÏä
	private int astate;//×´Ì¬
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAusername() {
		return ausername;
	}
	public void setAusername(String ausername) {
		this.ausername = ausername;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getAstate() {
		return astate;
	}
	public void setAstate(int astate) {
		this.astate = astate;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id + ", ausername=" + ausername + ", password=" + password + ", email=" + email
				+ ", astate=" + astate + "]";
	}
	public Admin(int id, String ausername, String password, String email, int astate) {
		super();
		this.id = id;
		this.ausername = ausername;
		this.password = password;
		this.email = email;
		this.astate = astate;
	}
	public Admin() {
		super();
	}
	
	
	
	

}
