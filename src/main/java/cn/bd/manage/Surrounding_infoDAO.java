package cn.bd.manage;

import java.util.List;

public interface Surrounding_infoDAO {
	public List<Surrounding_info> getall();
	public boolean rec(Surrounding_info Surrounding_info);
	public boolean del(int rank);
	public boolean add(Surrounding_info Surrounding_info);
}
