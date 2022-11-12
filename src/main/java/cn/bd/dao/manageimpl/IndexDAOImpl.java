package cn.bd.dao.manageimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.bd.manage.Index;
import cn.bd.manage.IndexDAO;
import cn.bd.util.JdbcUtil;

public class IndexDAOImpl implements IndexDAO {

	public String[] getall() {
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		String sql = "select * from index_info";
		
		try
		{
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			rs  = stmt.executeQuery();
			String a[] = {"","","",""};
			int i = 0;
			while(rs.next()){
				i++;
				a[0] = rs.getString("onduty");
				a[1] = rs.getString("onduty_tel");
				a[2] = rs.getString("other_info");
				a[3] = rs.getString("other");
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

	public boolean rec(Index Index) {
		String sql="UPDATE index_info SET onduty=?,onduty_tel=?,other_info=?,other=? WHERE id=?";
		
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs =null;
		try
		{	
			conn = JdbcUtil.getConnection();
			stmt = conn.prepareStatement(sql);
			
			stmt.setString(1,Index.getOnduty());
			stmt.setString(2,Index.getOnduty_tel());
			stmt.setString(3,Index.getOther_info());
			stmt.setString(4,Index.getOther());
			stmt.setInt(5,1);
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


}
