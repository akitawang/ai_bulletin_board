package cn.bd.manage;

import java.util.List;

public interface Urgent_infoDAO {
	public List<Urgent_info> getall();
	public boolean rec(Urgent_info Urgent_info);
	public boolean del(int rank);
	public boolean add(Urgent_info Urgent_info);
}
