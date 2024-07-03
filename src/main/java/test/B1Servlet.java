package test;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/first")
public class B1Servlet extends HttpServlet
{
	 protected void doPost(HttpServletRequest req,HttpServletResponse res)throws
	 ServletException,IOException
	 {
	 PrintWriter pw = res.getWriter();
	 res.setContentType("text/html");
	 BookBean pb = new RetrieveDAO().retrieve(req);
	 if(pb==null) 
	 {
	  pw.println("Invalid pCode...<br>");
	 RequestDispatcher rd = req.getRequestDispatcher("input.html");
	 rd.include(req, res);
	}
	 else 
	 {
	 pw.println("<a href='second?bcode="+pb.getBcode()+"&Name="+pb.getBname()
	 +"&Price="+pb.getBauthor()
	+"&Price="+pb.getBprice()
	+"&qty="+pb.getBqty()+"'>ViewBDetails</a>");		
	}
	 }
}
