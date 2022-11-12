package cn.bd.manage;

public class Big_img {
	public String locate;
	public int id;
	
	public Big_img() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Big_img(String locate, int id) {
		super();
		this.locate = locate;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Big_img [locate=" + locate + ", id=" + id + "]";
	}
	public String getLocate() {
		return locate;
	}
	public void setLocate(String locate) {
		this.locate = locate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
