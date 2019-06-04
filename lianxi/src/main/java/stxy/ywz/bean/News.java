package stxy.ywz.bean;

public class News {
	private int nid;
	private String ausername;
	private String title;
	private String content;
	private String time;
	private int nstate;
	
	public int getNid() {
		return nid;
	}
	public void setNid(int nid) {
		this.nid = nid;
	}
	public String getAusername() {
		return ausername;
	}
	public void setAusername(String ausername) {
		this.ausername = ausername;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getNstate() {
		return nstate;
	}
	public void setNstate(int nstate) {
		this.nstate = nstate;
	}
	@Override
	public String toString() {
		return "News [nid=" + nid + ", ausername=" + ausername + ", title=" + title + ", content=" + content + ", time="
				+ time + ", nstate=" + nstate + "]";
	}

}
