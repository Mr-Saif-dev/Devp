package com.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String aname=request.getParameter("aname");
		String apwd=request.getParameter("apwd");
		out.println(aname);
		out.println(apwd);
		
		if(aname.equals("admin@gmail.com") && apwd.equals("admin123"))
		{
			
			response.sendRedirect("admin_function.html");
		}
		else
		{
			response.sendRedirect("admin.html");
		}

		
	}

}
