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
import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Teachersinsert
 */
public class Teachersinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teachersinsert() {
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
		
		String esid=request.getParameter("sid");
		String esname=request.getParameter("sname");
		String esdept=request.getParameter("sdept");
		String escontact=request.getParameter("scontact");
		String esyop=request.getParameter("syop");
		String esemail=request.getParameter("semail");
		
		MyBean b=new MyBean();
		b.setEsid(esid);
		b.setEsname(esname);
		b.setEsdept(esdept);
		b.setEscontact(escontact);
		b.setEsyop(esyop);
		b.setEsemail(esemail);
		
		MyDao d=new MyDao();
		int result=d.sinsert(b);
		if(result!=0)
		{
			out.println("INSERT SUCCESS");
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.include(request, response);
		}
		else
		{
			out.println("INSERT NOT SUCCESS");
			RequestDispatcher rd = request.getRequestDispatcher("TeacherSinsert.jsp");
			rd.include(request, response);

		}
	}
		
}

