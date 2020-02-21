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
 * Servlet implementation class ClassTest
 */
public class ClassTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassTest() {
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
		int  cclasstestno=Integer.parseInt(request.getParameter("m1"));
		int cgroupa=Integer.parseInt(request.getParameter("x1"));
		int cgroupb=Integer.parseInt(request.getParameter("y1"));
		int cgroupc=Integer.parseInt(request.getParameter("z1"));
		int ctotal=cgroupa+cgroupb+cgroupc;
		double cperc=(((double)ctotal/45)*100);
		
		String sql="insert into classtest values(?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			
			ps.setString(1,s_id);
			ps.setInt(2,cclasstestno);
			ps.setInt(3,cgroupa);
			ps.setInt(4,cgroupb);
			ps.setInt(5,cgroupc);
			ps.setInt(6,ctotal);
			ps.setDouble(7,cperc);
			ps.executeUpdate();	
			
			request.setAttribute("s_id", s_id);
			request.setAttribute("cclasstestno", cclasstestno);
			request.setAttribute("cgroupa", cgroupa);
			request.setAttribute("cgroupb", cgroupb);
			request.setAttribute("cgroupc", cgroupc);
			request.setAttribute("ctotal", ctotal);
			request.setAttribute("cperc", cperc);
			System.out.print("i am " + cperc);
			RequestDispatcher rd = request.getRequestDispatcher("ClassTest.jsp");
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
