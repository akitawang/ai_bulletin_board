package cn.bd.manage;

public class Surrounding_info {
	public String content;
	public int id;
	public String time;
	public String manager;
	public String type;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Surrounding_info [content=" + content + ", id=" + id + ", time=" + time + ", manager=" + manager
				+ ", type=" + type + "]";
	}
	public Surrounding_info(String content, int id, String time, String manager, String type) {
		super();
		this.content = content;
		this.id = id;
		this.time = time;
		this.manager = manager;
		this.type = type;
	}
	public Surrounding_info() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
