package cn.bd.manage;

import java.util.List;

public interface InformationDAO {
	public List<Information> getall();
	public boolean rec(Information Urgent_info);
	public boolean del(int rank);
	public boolean add(Information Information);
}
