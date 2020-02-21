package com.teacher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.MyBean;
import com.dao.MyDao;

/**
 * Servlet implementation class Admintdelete
 */
public class Admintdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admintdelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		PrintWriter out=response.getWriter();
		response.setContentType("text/HTML");
		
		String etname=request.getParameter("tname");
		MyBean b=new MyBean();
		b.setEtname(etname);
		MyDao d=new MyDao();
		int result=d.tdelete(b);
		if(result!=0)
		{
			out.println("DELETE SUCCESS");
			RequestDispatcher rd = request.getRequestDispatcher("admin_function.html");
			rd.include(request, response);
			
		}
		else
		{
			out.println("NOT DELETED");
			RequestDispatcher rd = request.getRequestDispatcher("AdminTdelete.html");
			rd.include(request, response);
		}
		
	}

}
