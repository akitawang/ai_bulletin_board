package cn.bd.user;

public class Admin {
	public String username;
	public String userpass;
	public int userid;
	public int usertype;
	
	
	public Admin(String username, String userpass, int userid, int usertype) {
		super();
		this.username = username;
		this.userpass = userpass;
		this.userid = userid;
		this.usertype = usertype;
	}


	@Override
	public String toString() {
		return "Admin [username=" + username + ", userpass=" + userpass + ", userid=" + userid + ", usertype="
				+ usertype + "]";
	}


	public int getUsertype() {
		return usertype;
	}


	public void setUsertype(int usertype) {
		this.usertype = usertype;
	}


	public Admin() {
		super();
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getUserpass() {
		return userpass;
	}


	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}


	public int getUserid() {
		return userid;
	}


	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	
	
	
	

}
