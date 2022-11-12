package cn.bd.dao.manageimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bd.manage.Surrounding_info;
import cn.bd.manage.Surrounding_infoDAO;
import cn.bd.util.JdbcUtil;

public class Surrounding_infoDAOImpl implements Surrounding_infoDAO {

	public List<Surrounding_info> getall() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		String sql = "select * from surrounding_info";
		try
		{
			List<Surrounding_info> list= new ArrayList<Surrounding_info>();
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			rs  = stmt.executeQuery();
			while(rs.next()){
				Surrounding_info info = new Surrounding_info();
				info.setContent(rs.getString("content"));
				info.setType(rs.getString("type"));
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

	public boolean rec(Surrounding_info Surrounding_info) {
		String sql="UPDATE surrounding_info SET content=?,time=?,manager=?,type=? WHERE id=?";
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;

		try
		{	
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,Surrounding_info.getContent());
			stmt.setString(2,Surrounding_info.getTime());
			stmt.setString(3,Surrounding_info.getManager());
			stmt.setString(4,Surrounding_info.getType());
			stmt.setInt(5,Surrounding_info.getId());
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
		String sql="delete from surrounding_info where id=?";

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

	public boolean add(Surrounding_info Surrounding_info) {
		String sql = "insert into surrounding_info(content,time,manager,type)values(?,?,?,?)";
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		
		try
		{conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,Surrounding_info.getContent());
			stmt.setString(2, Surrounding_info.getTime());
			stmt.setString(3, Surrounding_info.getManager());
			stmt.setString(4, Surrounding_info.getType());
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

}
