package cn.bd.user;

public interface AdminDAO {
	public Admin getOneUser(String username);
	public boolean pass_rec(String username,String userpass);

}
