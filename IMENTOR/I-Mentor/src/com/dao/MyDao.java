package com.dao;

import javax.servlet.http.HttpServlet;

import com.bean.MyBean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.InputStream;
import com.connection.DatabaseConnect;
import com.mysql.cj.protocol.Resultset;

public class MyDao {
	Connection con =DatabaseConnect.dbcon();
	PreparedStatement ps= null;
	int result;
	ResultSet rs=null;
	public int sinsert(MyBean b)
	{
		String sql="insert into studentrecord values(?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,b.getEsid());
			ps.setString(2,b.getEsname());
			ps.setString(3,b.getEsdept());
			ps.setString(4,b.getEscontact());
			ps.setString(5,b.getEsyop());
			ps.setString(6,b.getEsemail());
			
			result=ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

		return result;
	}
	public ResultSet sview(MyBean b)
	{

		String sql="select * from studentrecord where s_name = ?";
	try {
		ps=con.prepareStatement(sql);
		ps.setString(1,b.getEsname());
		rs=ps.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
	}
	public int sdelete(MyBean b)
	{
		String sql="delete from studentrecord where s_name=?";
		try { 
			ps=con.prepareStatement(sql);
			ps.setString(1,b.getEsname());
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int tinsert(MyBean b)
	{
		String sql="insert into teacherrecord values(?,?,?,?,?,?,?,?,?)";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,b.getEtid());
			ps.setString(2,b.getEtname());
			ps.setString(3,b.getEtdept());
			ps.setString(4,b.getEtsub());
			ps.setString(5,b.getEtcontact());
			ps.setString(6,b.getEtyoj());
			ps.setString(7,b.getEtemail());
			ps.setString(8,b.getEtuserid());
			ps.setString(9,b.getEtpass());
			result=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}
	public ResultSet tview(MyBean b)
	{

		String sql="select * from teacherrecord where t_name=?";
	try {
		ps=con.prepareStatement(sql);
		ps.setString(1,b.getEtname());
		rs=ps.executeQuery();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return rs;
	}
	public int tdelete(MyBean b)
	{
		String sql="delete from teacherrecord where t_name=?";
		try {
			ps=con.prepareStatement(sql);
			ps.setString(1,b.getEtname());
			result=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
		public ResultSet tlogin(MyBean b)
		{
			String sql="select * from teacherrecord where t_userid=? and t_pass=?";
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1,b.getEtuserid());
				ps.setString(2,b.getEtpass());
				rs=ps.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return rs;	
		
	}
		public int workshop(MyBean b)
		{
			String sql="select * from workshop values(?,?,?,?,?)";
			try {
				ps=con.prepareStatement(sql);
				ps.setString(1,b.getWa1());
				ps.setString(2,b.getWb1());
				ps.setString(3,b.getWc1());
				ps.setString(4,b.getWd1());
				ps.setString(5,b.getWl1());
				//ps.setString(6,b.getWe1());
				//ps.setString(7,b.getWf1());
				
				result=ps.executeUpdate();	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return result;
		}
		public ResultSet sv2()
		{
			String sql="select * from studentrecord ";
			try {
				ps=con.prepareStatement(sql);
				
				rs=ps.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return rs;	
		
	}
		public ResultSet lastperfat1(MyBean b)
		{
			String sql="select aperc from attendance where s_id=? order by s_id desc limit 1 ";
			try {
				ps=con.prepareStatement(sql);
				System.out.println(sql );
				System.out.println(b.getEsid() + " = bid");
				ps.setString(1,b.getEsid());
				System.out.println("from here");
				
				ResultSet rs=ps.executeQuery();
				System.out.println(rs);
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
	}
		public ResultSet lastperfat2(MyBean b)
		{
			String sql="select a_perc from assignment where s_id=? order by s_id desc limit 1 ";
			try {
				ps=con.prepareStatement(sql);
				System.out.println(sql );
				System.out.println(b.getEsid() + " = bid");
				ps.setString(1,b.getEsid());
				System.out.println("from here");
				ResultSet rs=ps.executeQuery();
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
	}
		public ResultSet lastperfat3(MyBean b)
		{
			String sql="select c_perc from classtest where s_id=? order by s_id desc limit 1 ";
			try {
				ps=con.prepareStatement(sql);
				System.out.println(sql );
				System.out.println(b.getEsid() + " = bid");
				ps.setString(1,b.getEsid());
				System.out.println("from here");
				ResultSet rs=ps.executeQuery();
				return rs;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		
	}	public ResultSet lastperfat4(MyBean b)
	{
		String sql="select w_percent from workshop where s_id=? order by s_id desc limit 1 ";
		try {
			ps=con.prepareStatement(sql);
			System.out.println(sql );
			System.out.println(b.getEsid() + " = bid");
			ps.setString(1,b.getEsid());
			System.out.println("from here");
			ResultSet rs=ps.executeQuery();
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
}

}
