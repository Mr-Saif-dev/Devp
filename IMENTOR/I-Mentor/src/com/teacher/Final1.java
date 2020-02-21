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
 * Servlet implementation class Final1
 */
public class Final1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Final1() {
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
		System.out.println("value="+s_id);
		
		 MyBean b=new MyBean();
		 b.setEsid(s_id);
		
		MyDao d=new MyDao();
		ResultSet rs1=d.lastperfat1(b);
		System.out.println("this is a demo");
		try {
			System.out.println("after try");
			System.out.println(rs1);
			if(rs1!=null && rs1.next())
			{
				System.out.println("in rs1");
				ResultSet rs2=d.lastperfat2(b);
				if(rs2!=null && rs2.next())
				{
					ResultSet rs3=d.lastperfat3(b);
					if(rs3!=null && rs3.next())
					{	
						ResultSet rs4=d.lastperfat4(b);
						System.out.println(rs4);
							if(rs4!=null && rs4.next())
							{
								System.out.println("from if");
								
								String aperc1=rs1.getString(1);
								float  aperc2=Float.parseFloat(aperc1);
								
								String aperc3=rs2.getString(1);
								float  aperc4=Float.parseFloat(aperc3);
								String aperc5=rs3.getString(1);
								float  aperc6=Float.parseFloat(aperc5);
								String aperc7=rs4.getString(1);
								float  aperc8=Float.parseFloat(aperc7);
								float overallperf = ((aperc2+aperc4+aperc6+aperc8)/400)*100;
								//out.println(overallperf);
								request.setAttribute("overallperf", overallperf);
								out.println("<br>");
								if(overallperf>80)
								{
									//out.println("STUDENT'S PERFORMANCE IS OUTSTANDING");
									request.setAttribute("a", "STUDENT'S PERFORMANCE IS OUTSTANDING");
									out.println("<br>");
								}
								else
								if(overallperf>60 && overallperf<=80)
									{
										//out.println("STUDENT'S PERFORMANCE IS GOOD");
									request.setAttribute("a", "STUDENT'S PERFORMANCE IS GOOD");
										out.println("<br>");
									}
								else
								if(overallperf>40 && overallperf<=60)
									{
										//out.println("STUDENT'S PERFORMANCE IS AVERAGE");
									request.setAttribute("a", "STUDENT'S PERFORMANCE IS AVERAGE");
										out.println("<br>");
									}	
								else
								{
									//out.println("STUDENT'S PERFORMANCE IS POOR");
									request.setAttribute("a", "STUDENT'S PERFORMANCE IS POOR");
									out.println("<br>");
								}
								RequestDispatcher rd = request.getRequestDispatcher("Finally.jsp");
								rd.include(request, response);

							
						}  
						else
						{
							out.println("DATA NOT FULFILLED");
							RequestDispatcher rd = request.getRequestDispatcher("Functionality.jsp");
							rd.include(request, response);
						}
			
					}
				}
			}else
				System.out.println("rs is empty!");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
