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
 * Servlet implementation class Attendance
 */
public class Attendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Attendance() {
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
		
		int alectureco=Integer.parseInt(request.getParameter("ll1"));
		int aattended=Integer.parseInt(request.getParameter("aa1"));
		int aquesans=Integer.parseInt(request.getParameter("bb1"));
		int afollowinst=Integer.parseInt(request.getParameter("cc1"));
		int amakenote=Integer.parseInt(request.getParameter("dd1"));
		int acototal;
		int acttotal;
		int acthtotal;
		double aperc;
		System.out.println(alectureco + " alec");
		if(alectureco>0 && alectureco<6)
		{
			 acototal=aattended+aquesans+afollowinst+amakenote;
			 double acoperc=(((double)acototal/100)*100);
			 acttotal=0;
			 acthtotal=0;
			double actperc=0.0;
			double acthperc=0.0;
		    aperc = (((acoperc+actperc+acthperc)/300)*100);
			String sql="insert into attendance values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				
				ps.setString(1,s_id);
				ps.setInt(2,alectureco);
				ps.setInt(3,aattended);
				ps.setInt(4,aquesans);
				ps.setInt(5,afollowinst);
				ps.setInt(6,amakenote);
				ps.setInt(7,acototal);
				ps.setDouble(8,acoperc);
				ps.setInt(9,acttotal);
				ps.setDouble(10,actperc);
				ps.setInt(11,acthtotal);
				ps.setDouble(12,acthperc);
				ps.setDouble(13,aperc);
				
				ps.executeUpdate();	
				
				request.setAttribute("s_id", s_id);
				request.setAttribute("alectureco", alectureco);
				request.setAttribute("aattended", aattended);
				request.setAttribute("aquesans", aquesans);
				request.setAttribute("afollowinst", afollowinst);
				request.setAttribute("amakenote", amakenote);
				request.setAttribute("acototal", acototal);
				request.setAttribute("acoperc", acoperc);
				request.setAttribute("acttotal", acttotal);
				request.setAttribute("actperc", actperc);
				request.setAttribute("acthtotal", acthtotal);
				request.setAttribute("acthperc", acthperc);
				request.setAttribute("aperc", aperc);
				System.out.print("i am " + aperc);
				RequestDispatcher rd = request.getRequestDispatcher("Attendance.jsp");
				rd.forward(request, response);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(" it is from cache");
			}
		}
	/*		else
			if(alectureco>5 && alectureco<11) */
			
			else
			if(alectureco>5 && alectureco<11){
				 acttotal=aattended+aquesans+afollowinst+amakenote;
				 System.out.println("acttotal = " + acttotal);
				double actperc=(((double)acttotal/100)*100);
				System.out.println("double actperc = "+ actperc);
				 acototal=0;
				 acthtotal=0;
				double acoperc=0.0;
				double acthperc=0.0;
				aperc = (((acoperc+actperc+acthperc)/300)*100);
				String sql="insert into attendance values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					
					ps.setString(1,s_id);
					ps.setInt(2,alectureco);
					ps.setInt(3,aattended);
					ps.setInt(4,aquesans);
					ps.setInt(5,afollowinst);
					ps.setInt(6,amakenote);
					ps.setInt(7,acototal);
					ps.setDouble(8,acoperc);
					ps.setInt(9,acttotal);
					ps.setDouble(10,actperc);
					ps.setInt(11,acthtotal);
					ps.setDouble(12,acthperc);
					ps.setDouble(13,aperc);
					
					ps.executeUpdate();	
					//after db
					request.setAttribute("s_id", s_id);
					request.setAttribute("alectureco", alectureco);
					request.setAttribute("aattended", aattended);
					request.setAttribute("aquesans", aquesans);
					request.setAttribute("afollowinst", afollowinst);
					request.setAttribute("amakenote", amakenote);
					request.setAttribute("acototal", acototal);
					request.setAttribute("acoperc", acoperc);
					request.setAttribute("acttotal", acttotal);
					request.setAttribute("actperc", actperc);
					request.setAttribute("acthtotal", acthtotal);
					request.setAttribute("acthperc", acthperc);
					request.setAttribute("aperc", aperc);
					//System.out.print("i am " + aperc);
					RequestDispatcher rd = request.getRequestDispatcher("Attendance.jsp");
					rd.forward(request, response);
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.out.println(" it is from cache");
				}
				
				
				
			}
		else
	{
		 acthtotal=aattended+aquesans+afollowinst+amakenote;
		double acthperc=(((double)acthtotal/100)*100);
		 acototal=0;
		 acttotal=0;
		double acoperc=0;
		double actperc=0;
		aperc =(((acoperc+actperc+acthperc)/300)*100);
		String sql="insert into attendance values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,s_id);
			ps.setInt(2,alectureco);
			ps.setInt(3,aattended);
			ps.setInt(4,aquesans);
			ps.setInt(5,afollowinst);
			ps.setInt(6,amakenote);
			ps.setInt(7,acototal);
			ps.setDouble(8,acoperc);
			ps.setInt(9,acttotal);
			ps.setDouble(10,actperc);
			ps.setInt(11,acthtotal);
			ps.setDouble(12,acthperc);
			ps.setDouble(13,aperc);
			
			ps.executeUpdate();	
			
			request.setAttribute("s_id", s_id);
			request.setAttribute("alectureco", alectureco);
			request.setAttribute("aattended", aattended);
			request.setAttribute("aquesans", aquesans);
			request.setAttribute("afollowinst", afollowinst);
			request.setAttribute("amakenote", amakenote);
			request.setAttribute("acototal", acototal);
			request.setAttribute("acoperc", acoperc);
			request.setAttribute("acttotal", acttotal);
			request.setAttribute("actperc", actperc);
			request.setAttribute("acthtotal", acthtotal);
			request.setAttribute("acthperc", acthperc);
			request.setAttribute("aperc", aperc);
			System.out.print("i am " + aperc);
			RequestDispatcher rd = request.getRequestDispatcher("Attendance.jsp");
			rd.forward(request, response);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" it is from cache");
		}
		
		
		
	}

	}
}
