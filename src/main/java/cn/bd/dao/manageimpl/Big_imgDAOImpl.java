package cn.bd.dao.manageimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.bd.manage.Big_img;
import cn.bd.util.JdbcUtil;

public class Big_imgDAOImpl {
	//根据ID修改信息
			public boolean rec(Big_img Big_img) {
				// TODO Auto-generated method stub
				String sql="UPDATE big_pic SET locate=? WHERE id=?";
				
				Connection conn=null;
				PreparedStatement stmt=null;
				ResultSet rs =null;
				try
				{	
					conn = JdbcUtil.getConnection();
					stmt = conn.prepareStatement(sql);
					
					stmt.setString(1,Big_img.getLocate());
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
			
			public List<Big_img> getOne() {
				Connection conn=null;
				PreparedStatement stmt=null;
				ResultSet rs =null;
				String sql = "select * from big_pic where id=1";
				
				try
				{
					List<Big_img> list= new ArrayList<Big_img>();
					conn = JdbcUtil.getConnection();
					stmt = conn.prepareStatement(sql);
					rs  = stmt.executeQuery();

					while(rs.next()){
						Big_img user = new Big_img();
						user.setId(rs.getInt("id"));
						user.setLocate(rs.getString("locate"));
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
			
			public List<Big_img> getAll() {
				Connection conn=null;
				PreparedStatement stmt=null;
				ResultSet rs =null;
				String sql = "select * from big_pic";
				
				try
				{
					List<Big_img> list= new ArrayList<Big_img>();
					conn = JdbcUtil.getConnection();
					stmt = conn.prepareStatement(sql);
					rs  = stmt.executeQuery();

					while(rs.next()){
						Big_img user = new Big_img();
						user.setId(rs.getInt("id"));
						user.setLocate(rs.getString("locate"));
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
			
			public String getOnep() {
				Connection conn=null;
				PreparedStatement stmt=null;
				ResultSet rs =null;
				String sql = "select * from big_pic where id=1";
				
				try
				{
					conn = JdbcUtil.getConnection();
					stmt = conn.prepareStatement(sql);
					rs  = stmt.executeQuery();
					String user= "";
					int i=0;
					while(rs.next()){
						i++;
						user=rs.getString("locate");
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
