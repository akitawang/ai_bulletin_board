package cn.bd.dao.manageimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bd.manage.Left_pic;
import cn.bd.manage.Left_picDAO;
import cn.bd.util.JdbcUtil;

public class Left_picDAOImpl implements Left_picDAO {

	public boolean rec1(Left_pic Left_pic) {
			// TODO Auto-generated method stub
			String sql="UPDATE left_pic SET pic1=? WHERE id=?";
			
			Connection conn=null;
			PreparedStatement stmt=null;
			ResultSet rs =null;
			try
			{	
				conn = JdbcUtil.getConnection();
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1,Left_pic.getPic1());
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
	public boolean rec2(Left_pic Left_pic) {
		// TODO Auto-generated method stub
		String sql="UPDATE left_pic SET pic2=? WHERE id=?";
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		try
		{	
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,Left_pic.getPic2());
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
	
	
	public String[] getOne() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		String sql = "select * from left_pic where id=1";
		
		try
		{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs  = stmt.executeQuery();
			String a[] = {"",""};
			int i = 0;
			while(rs.next()){
				i++;
				a[0] = rs.getString("pic1");
				a[1] = rs.getString("pic2");
				if(i == 1) {
					break;
				}
			}
			return a;		
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
	
	public List<Left_pic> getAll() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		String sql = "select * from left_pic";
		
		try
		{
			List<Left_pic> list= new ArrayList<Left_pic>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs  = stmt.executeQuery();

			while(rs.next()){
				Left_pic user = new Left_pic();
				user.setId(rs.getInt("id"));
				user.setPic1(rs.getString("pic1"));
				user.setPic2(rs.getString("pic2"));
				list.add(user);
			}
			return list;		
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
	public List<Left_pic> getall() {
		// TODO Auto-generated method stub
		return null;
	}

}
