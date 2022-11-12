package cn.bd.dao.manageimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import cn.bd.manage.Ad_pic;
import cn.bd.manage.Ad_picDAO;
import cn.bd.util.JdbcUtil;

public class Ad_picDAOImpl implements Ad_picDAO {

	public boolean rec(Ad_pic Ad_pic) {
		String sql="UPDATE ad_pic SET pic=? WHERE id=?";
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		try
		{	
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,Ad_pic.getPic());
			stmt.setInt(2,1);
			int rows  = stmt.executeUpdate();

		    if(rows>0)
		    	return true;
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);	
		}
		finally
		{
			JdbcUtil.release(rs, stmt, conn);
		}

		return false;
	}

	public List<Ad_pic> getall() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Ad_pic> getOne() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOnep() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		String sql = "select * from ad_pic where id=1";
		
		try
		{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs  = stmt.executeQuery();
			String user= "";
			int i=0;
			while(rs.next()){
				i++;
				user=rs.getString("pic");
				if(i == 1) {
					break;
				}
			}
			return user;		
		}
		catch(Exception e)
		{
			throw new RuntimeException(e);
		}
		finally
		{
			JdbcUtil.release(rs, stmt, conn);	
		}
	}

}
