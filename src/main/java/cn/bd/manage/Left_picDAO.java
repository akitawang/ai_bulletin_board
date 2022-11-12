package cn.bd.manage;

import java.util.List;

public interface Left_picDAO {
	public boolean rec1(Left_pic Left_pic);
	public boolean rec2(Left_pic Left_pic);
	public List<Left_pic> getall();
	public String[] getOne();
}
