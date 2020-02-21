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
 * Servlet implementation class Admintinsert
 */
public class Admintinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admintinsert() {
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
		
		String etid=request.getParameter("tid");
		String etname=request.getParameter("tname");
		String etdept=request.getParameter("tdept");
		String etsub=request.getParameter("tsubject");
		String etcontact=request.getParameter("tcontact");
		String etyoj=request.getParameter("tyoj");
		String etemail=request.getParameter("temail");
		String etuserid=request.getParameter("tuserid");
		String etpass=request.getParameter("tpass");
		MyBean b =new MyBean();
		b.setEtid(etid);
		b.setEtname(etname);
		b.setEtdept(etdept);
		b.setEtsub(etsub);
		b.setEtcontact(etcontact);
		b.setEtyoj(etyoj);
		b.setEtemail(etemail);
		b.setEtuserid(etuserid);
		b.setEtpass(etpass);
		
		MyDao d = new MyDao();
		int result = d.tinsert(b);
		if(result!=0)
		{
			out.println("i am called");
			out.println("INSERT SUCCESS");
			RequestDispatcher rd = request.getRequestDispatcher("admin_function.html");
			rd.include(request, response);
		}
		else
		{
			out.println("INSERT NOT SUCCESS");
			RequestDispatcher rd = request.getRequestDispatcher("AdminTinsert.html");
			rd.include(request, response);

		}
	}
		
	}

