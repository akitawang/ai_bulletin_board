package cn.bd.dao.manageimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bd.manage.Urgent_info;
import cn.bd.util.JdbcUtil;

public class Urgent_infoDAOImpl {
	//增加
	public boolean add(Urgent_info Urgent_info) {
		String sql = "insert into urgent_info(title,content,time,manager)values(?,?,?,?)";
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		try
		{conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,Urgent_info.getTitle());
			stmt.setString(2, Urgent_info.getContent());
			stmt.setString(3, Urgent_info.getTime());
			stmt.setString(4, Urgent_info.getManager());
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
	//获取所有紧急信息
	public List<Urgent_info> getall() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		String sql = "select * from urgent_info";
		
		try
		{
			List<Urgent_info> list= new ArrayList<Urgent_info>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			rs  = stmt.executeQuery();
			while(rs.next()){
				
				Urgent_info info = new Urgent_info();
				info.setTitle(rs.getString("title"));
				info.setContent(rs.getString("content"));
				info.setTime(rs.getString("time"));
				info.setId(rs.getInt("id"));
				info.setManager(rs.getString("manager"));
				list.add(info);
				//return user;
				//(rs.getString("birthday"));					
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
		
		//根据ID修改信息
		public boolean rec(Urgent_info Urgent_info) {
			// TODO Auto-generated method stub
			String sql="UPDATE urgent_info SET title=?,content=?,time=?,manager=? WHERE id=?";
			
			Connection conn=null;
			PreparedStatement stmt=null;
			ResultSet rs =null;
			
			//System.out.println(sql);
			try
			{	
				conn = JdbcUtil.getConnection();
				stmt = conn.prepareStatement(sql);
				
				stmt.setString(1,Urgent_info.getTitle());
				stmt.setString(2,Urgent_info.getContent());
				stmt.setString(3,Urgent_info.getTime());
				stmt.setInt(5,Urgent_info.getId());
				stmt.setString(4, Urgent_info.getManager());
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
	
		//删除
		public boolean del(int rank) {
			// TODO Auto-generated method stub
			String sql="delete from urgent_info where id=?";

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
		
		//找到倒序的前四项
		public List<Urgent_info> getOne() {
			Connection conn=null;
			PreparedStatement stmt=null;
			ResultSet rs =null;
			String sql = "SELECT * FROM urgent_info ORDER BY id DESC";
			
			try
			{
				List<Urgent_info> list= new ArrayList<Urgent_info>();
				conn = JdbcUtil.getConnection();
				stmt = conn.prepareStatement(sql);
				rs  = stmt.executeQuery();
				int time = 0;

				while(rs.next()){
					time++;
					Urgent_info user = new Urgent_info();
					user.setId(rs.getInt("id"));
					user.setContent(rs.getString("content"));
					user.setTitle(rs.getString("title"));;
					user.setManager(rs.getString("manager"));
					user.setTime(rs.getString("time"));
					list.add(user);
					if(time == 4) {
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
