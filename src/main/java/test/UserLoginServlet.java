package test;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
@SuppressWarnings("serial")
@WebServlet("/ulog")
public class UserLoginServlet extends HttpServlet
{
	protected void doPost(HttpServletRequest req,HttpServletResponse res)
	throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");
		BookBean ub=new LoginDAO().login(req);
		
		if(ub==null)
		{
			pw.print("invalid Login process <br>");
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
			rd.include(req, res);
		}
		else
		{
			HttpSession hs=req.getSession();
			hs.setAttribute("ubean", ub);
			pw.print("WElcome User:"+ub.getBname()+"<br>");
					
	        RequestDispatcher rd=req.getRequestDispatcher("input.html");
			rd.include(req, res);
		}	
	}
}
