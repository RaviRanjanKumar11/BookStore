package test;
import java.sql.*;

import javax.servlet.http.*;
public class RetrieveDAO 
{
	public BookBean pb=null;
	
	public BookBean retrieve(HttpServletRequest req)
	 {
		try {
			Connection con=Cont.getCon();
			PreparedStatement ps=con.prepareStatement("select * from bookuser where bcode=?");
					
			ps.setString(1,req.getParameter("bcode"));
			ResultSet rs=ps.executeQuery();
			if(rs.next())
			{
				
				BookBean eb=new BookBean();
				eb.setUname(rs.getString(1));
				eb.setPword(rs.getString(2));
				eb.setBcode(rs.getString(3));
				eb.setBname(rs.getString(3));
				eb.setBauthor(rs.getString(5));
				eb.setBprice(rs.getInt(6));
				eb.setBqty(rs.getInt(7));				
				//al.add(eb);
				
			}// end condition
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pb;
	}
}
