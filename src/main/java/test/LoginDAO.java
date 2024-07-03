package test;
import java.sql.*;
import javax.servlet.http.*;
public class LoginDAO 
{
	public BookBean ub=null;
	public BookBean login(HttpServletRequest req)
	{
		try
		{
			Connection con=Cont.getCon();
			PreparedStatement ps=con.prepareStatement("select * from bookuser where uname=? and pword=?");
			
			ps.setString(1, req.getParameter("uname"));
			ps.setString(2, req.getParameter("pword"));
			ResultSet rs=ps.executeQuery();
			
			if(rs.next())
			{
				ub=new BookBean();
				ub.setUname(rs.getString(1));
				ub.setPword(rs.getString(2));
				ub.setBcode(rs.getString(3));
				ub.setBname(rs.getString(4));
				ub.setBauthor(rs.getString(5));	
				ub.setBprice(rs.getInt(6));
				ub.setBqty(rs.getInt(7));
			}
		  }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ub;
	}
}
