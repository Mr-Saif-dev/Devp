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
 * Servlet implementation class Assignment
 */
public class Assignment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Assignment() {
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
		int  aassignmentno=Integer.parseInt(request.getParameter("o1"));
		int asubmitted=Integer.parseInt(request.getParameter("p1"));
		int amarksgiven=Integer.parseInt(request.getParameter("q1"));
		int atotal=asubmitted+amarksgiven;
		System.out.println("atot = "+ atotal);
		double aperc= (((double)atotal)/45) * 100;
		
		String sql="insert into assignment values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,s_id);
			ps.setInt(2,aassignmentno);
			ps.setInt(3,asubmitted);
			ps.setInt(4,amarksgiven);
			ps.setInt(5,atotal);
			ps.setDouble(6,aperc);
			ps.executeUpdate();	
			
			request.setAttribute("s_id", s_id);
			request.setAttribute("aassignmentno", aassignmentno);
			request.setAttribute("asubmitted", asubmitted);
			request.setAttribute("amarksgiven", amarksgiven);
			request.setAttribute("atotal", atotal);
			request.setAttribute("aperc", aperc);
			System.out.print("i am " + aperc);
			RequestDispatcher rd = request.getRequestDispatcher("Assignment.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(" it is from cache");
		}
		
		
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

}
