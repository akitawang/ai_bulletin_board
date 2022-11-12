package cn.bd.manage;

import java.util.List;

public interface Big_imgDAO {
	public boolean rec(Big_img Big_img);
	public List<Big_img> getall();
	public List<Big_img> getOne();
	public String getOnep();
}
