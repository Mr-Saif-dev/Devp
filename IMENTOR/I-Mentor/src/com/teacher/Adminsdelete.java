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
 * Servlet implementation class Adminsdelete
 */
public class Adminsdelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Adminsdelete() {
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
		String esname=request.getParameter("sname");
		MyBean b=new MyBean();
		b.setEsname(esname);
		MyDao d=new MyDao();
		int result=d.sdelete(b);
		if(result!=0)
		{
			out.println("DELETE SUCCESS");
			RequestDispatcher rd = request.getRequestDispatcher("admin_function.html");
			rd.include(request, response);
			
		}
		else
		{
			out.println("NOT DELETED");
			RequestDispatcher rd = request.getRequestDispatcher("AdminSdelete.html");
			rd.include(request, response);
		}
	}
		
	}

