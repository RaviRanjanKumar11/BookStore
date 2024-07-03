package test;
import java.sql.*;

import java.util.*;
public class RetrieveDAO2 
{
	public ArrayList<BookBean> al=new ArrayList<BookBean>();
	
	public ArrayList<BookBean>retrieve()
	{
		try {
			Connection con=Cont.getCon();
			PreparedStatement ps=con.prepareStatement("select * from bookuser");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				BookBean eb=new BookBean();
				eb.setUname(rs.getString(1));
				eb.setPword(rs.getString(2));
				eb.setBcode(rs.getString(3));
				eb.setBname(rs.getString(3));
				eb.setBauthor(rs.getString(5));
				eb.setBprice(rs.getInt(6));
				eb.setBqty(rs.getInt(7));				
				al.add(eb);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return al;
	}
}
