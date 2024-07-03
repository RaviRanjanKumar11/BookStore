package test;
import java.io.*;
import java.util.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/view")
public class ViewEmployeeServlet extends HttpServlet
{
	public RetrieveDAO ob=null;
	public void init()throws ServletException
	{
		ob=new RetrieveDAO();
	}
	public void service(ServletRequest req,ServletResponse res)
	throws ServletException,IOException
	
	{		
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		ArrayList<BookBean> al=new RetrieveDAO2().retrieve();
		
		if(al.size()==0)
		{
			pw.print("Employee not Available <br>");		
		}
		else
		{
			Iterator<BookBean> sp=al.iterator();
			pw.print("===Bcode===<br>");
			while(sp.hasNext()) 
			{				
				BookBean eb=(BookBean)sp.next();		
				pw.print(eb.getBcode()+"<br>");
				
					/*
			      	"&nbsp"
					+"&nbsp&nbsp"+eb.getBname()+"&nbsp"+eb.getBauthor()+"&nbsp"+eb.getBprice()+"&nbsp"+eb.getBqty()+"<br>");*/
							
			}	
		}
	RequestDispatcher rd=req.getRequestDispatcher("input.html");
		rd.include(req, res);
	}
}
