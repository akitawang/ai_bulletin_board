package cn.bd.manage;

import java.util.List;

public interface Ad_picDAO {
	public boolean rec(Ad_pic Ad_pic);
	public List<Ad_pic> getall();
	public List<Ad_pic> getOne();
	public String getOnep();
}
