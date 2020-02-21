package com.teacher;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.connection.DatabaseConnect;
import com.bean.MyBean;
import com.dao.MyDao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Blob;
import java.io.InputStream;

/**
 * Servlet implementation class Workshop
 */
public class Workshop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Workshop() {
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
		Connection con=DatabaseConnect.dbcon();
		String s_id=request.getParameter("sid");
		int  wworkshopno=Integer.parseInt(request.getParameter("l1"));
		int wattended=Integer.parseInt(request.getParameter("a1"));
		int wmakingnotes=Integer.parseInt(request.getParameter("b1"));
		int wreport=Integer.parseInt(request.getParameter("c1"));
		int wmodel=Integer.parseInt(request.getParameter("d1"));
		int wtotal=wattended+wmakingnotes+wreport+ wmodel;
		double wperc=(((double)wtotal/40)*100);
	
		
		
	
		
		String sql="insert into workshop values(?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,s_id);
			ps.setInt(2,wworkshopno);
			ps.setInt(3,wattended);
			ps.setInt(4,wmakingnotes);
			ps.setInt(5,wreport);
			ps.setInt(6,wmodel);
			ps.setInt(7,wtotal);
			ps.setDouble(8,wperc);
			ps.executeUpdate();	
			
			request.setAttribute("s_id", s_id);
			request.setAttribute("wworkshopno", wworkshopno);
			request.setAttribute("wattended", wattended);
			request.setAttribute("wmakingnotes", wmakingnotes);
			request.setAttribute("wreport", wreport);
			request.setAttribute("wmodel", wmodel);
			request.setAttribute("wtotal", wtotal);
			request.setAttribute("wperc", wperc);
			System.out.print("i am " + wperc);
			RequestDispatcher rd = request.getRequestDispatcher("Workshop.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" it is from cache");
		}
		
		//
		
		/*MyDao d = new MyDao();
		int result2 = d.workshop();
		if(result!=0)
		{
			out.println("RECORD ADDED ");
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		else
		{
			out.println("RECORD NOT ADDED");
			RequestDispatcher rd = request.getRequestDispatcher("Workshop.html");
			rd.include(request, response);

		}*/
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
