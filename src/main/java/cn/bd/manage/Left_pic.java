package cn.bd.manage;

public class Left_pic {
	public String pic1;
	public String pic2;
	public int id;
	
	public Left_pic() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Left_pic(String pic1, String pic2, int id) {
		super();
		this.pic1 = pic1;
		this.pic2 = pic2;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Left_pic [pic1=" + pic1 + ", pic2=" + pic2 + ", id=" + id + "]";
	}
	public String getPic1() {
		return pic1;
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	public String getPic2() {
		return pic2;
	}
	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
