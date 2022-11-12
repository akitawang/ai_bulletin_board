package cn.bd.manage;

public class Index {
	public String onduty;
	public String onduty_tel;
	public int id;
	public String other_info;
	public String other;
	public String getOnduty() {
		return onduty;
	}
	public void setOnduty(String onduty) {
		this.onduty = onduty;
	}
	public String getOnduty_tel() {
		return onduty_tel;
	}
	public void setOnduty_tel(String onduty_tel) {
		this.onduty_tel = onduty_tel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOther_info() {
		return other_info;
	}
	public void setOther_info(String other_info) {
		this.other_info = other_info;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
	@Override
	public String toString() {
		return "Index [onduty=" + onduty + ", onduty_tel=" + onduty_tel + ", id=" + id + ", other_info=" + other_info
				+ ", other=" + other + "]";
	}
	public Index(String onduty, String onduty_tel, int id, String other_info, String other) {
		super();
		this.onduty = onduty;
		this.onduty_tel = onduty_tel;
		this.id = id;
		this.other_info = other_info;
		this.other = other;
	}
	public Index() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
