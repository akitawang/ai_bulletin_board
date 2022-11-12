package cn.bd.manage;

public class Urgent_info {
	public String title;
	public String content;
	public int id;
	public String time;
	public String manager;
	
	public Urgent_info() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Urgent_info(String title, String content, int id, String time, String manager) {
		super();
		this.title = title;
		this.content = content;
		this.id = id;
		this.time = time;
		this.manager = manager;
	}
	@Override
	public String toString() {
		return "Urgent_info [title=" + title + ", content=" + content + ", id=" + id + ", time=" + time + ", manager="
				+ manager + "]";
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
