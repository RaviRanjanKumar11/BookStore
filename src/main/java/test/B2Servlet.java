package test;
import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
@SuppressWarnings("serial")
@WebServlet("/second")
public class B2Servlet extends HttpServlet
{
 protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,
 IOException
 {
	PrintWriter pw=res.getWriter(); 
	res.setContentType("text/html");	
	pw.print("====BookDetails====");
	
	pw.print("<br>user:="+req.getParameter("uname"));
	/*pw.print("<br>pass:="+req.getParameter("pword"));
 pw.print("<br>bcode:="+req.getParameter("bcode"));
 pw.print("<br>bname:="+req.getParameter("bname"));
 pw.print("<br>bauthor:="+req.getParameter("bauthor"));
 pw.print("<br>brice:="+req.getParameter("bprice"));
 pw.print("<br>bqty:="+req.getParameter("bqty")+"<br>");*/
 
 	 RequestDispatcher rd = req.getRequestDispatcher("code.html");
	 rd.include(req, res);
	 }
  }
