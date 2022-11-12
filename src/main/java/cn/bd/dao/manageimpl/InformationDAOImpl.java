package cn.bd.dao.manageimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bd.manage.Information;
import cn.bd.manage.InformationDAO;
import cn.bd.util.JdbcUtil;

public class InformationDAOImpl implements InformationDAO {

	public List<Information> getall() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		String sql = "select * from information";
		try
		{
			List<Information> list= new ArrayList<Information>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			rs  = stmt.executeQuery();
			while(rs.next()){
				
				Information info = new Information();
				info.setContact(rs.getString("contact"));
				info.setContent(rs.getString("content"));
				info.setTime(rs.getString("time"));
				info.setId(rs.getInt("id"));
				info.setManager(rs.getString("manager"));
				list.add(info);				
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

	public boolean rec(Information Urgent_info) {
		String sql="UPDATE information SET contact=?,content=?,time=?,manager=? WHERE id=?";
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		//System.out.println(sql);
		try
		{	
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,Urgent_info.getContact());
			stmt.setString(2,Urgent_info.getContent());
			stmt.setString(3,Urgent_info.getTime());
			stmt.setString(4,Urgent_info.getManager());
			stmt.setInt(5,Urgent_info.getId());
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

	public boolean del(int rank) {
		// TODO Auto-generated method stub
		String sql="delete from information where id=?";

		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;

		try
		{	
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);				
			stmt.setInt(1,rank);
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
	//增加
		public boolean add(Information Information) {
			String sql = "insert into information(content,contact,time,manager)values(?,?,?,?)";
			Connection conn=null;
			PreparedStatement stmt=null;
			ResultSet rs =null;
			
			try
			{conn = JdbcUtil.getConnection();
				stmt = conn.prepareStatement(sql);
				stmt.setString(1,Information.getContent());
				stmt.setString(2, Information.getContact());
				stmt.setString(3, Information.getTime());
				stmt.setString(4, Information.getManager());
				int rows  = stmt.executeUpdate();
			    if(rows>0)return true;
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
		
		
		//找到倒序的前六项
		public List<Information> getOne() {
			Connection conn=null;
			PreparedStatement stmt=null;
			ResultSet rs =null;
			String sql = "SELECT * FROM information ORDER BY id DESC";
			
			//System.out.println(sql);
			try
			{
				List<Information> list= new ArrayList<Information>();
				conn = JdbcUtil.getConnection();
				stmt = conn.prepareStatement(sql);
				rs  = stmt.executeQuery();
				int time = 0;

				while(rs.next()){
					time++;
					Information user = new Information();
					user.setId(rs.getInt("id"));
					user.setContent(rs.getString("content"));
					user.setContact(rs.getString("contact"));
					user.setManager(rs.getString("manager"));
					user.setTime(rs.getString("time"));
					list.add(user);
					if(time == 10) {
						break;
					}
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
}
