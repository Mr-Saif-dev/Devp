package com.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;

import com.bean.MyBean;
import com.dao.MyDao;


/**
 * Servlet implementation class TeacherLogin1
 */
public class TeacherLogin1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeacherLogin1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String etuserid = request.getParameter("etuserid");
		String etpass = request.getParameter("etpass");
		
		MyBean b = new MyBean();
		b.setEtuserid(etuserid);
		b.setEtpass(etpass);
		
		MyDao d = new MyDao();
		ResultSet rs = d.tlogin(b);
		
		try
		{
			if(rs.next())
			{
				{
				HttpSession session = request.getSession();
				session.setAttribute("etuserid", etuserid);
				RequestDispatcher rd = request.getRequestDispatcher("TeacherLogin2");
				rd.include(request, response);
				}
				
			}
			else
			{
				out.println("USER-NAME OR PASSWORD ERROR");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
			}
			
		}
		catch(SQLException  e)
		{
			e.printStackTrace();
		}
		
	}

}
