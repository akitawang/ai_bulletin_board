package cn.bd.manage;

public class Ad_pic {
	public String pic;
	public int id;
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "Ad_pic [pic=" + pic + ", id=" + id + "]";
	}
	public Ad_pic(String pic, int id) {
		super();
		this.pic = pic;
		this.id = id;
	}
	public Ad_pic() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
