package cn.bd.manage;

public class Information {
	public String contact;
	public String content;
	public int id;
	public String time;
	public String manager;
	
	public Information() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Information(String contact, String content, int id, String time, String manager) {
		super();
		this.contact = contact;
		this.content = content;
		this.id = id;
		this.time = time;
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "Information [contact=" + contact + ", content=" + content + ", id=" + id + ", time=" + time
				+ ", manager=" + manager + "]";
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	
	
	
}
