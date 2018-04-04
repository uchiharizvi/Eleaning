package com.userinfo;
import java.io.*;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class Userinfo extends HttpServlet {
	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String a = request.getParameter("name");
		String b = request.getParameter("date");
		String c = request.getParameter("category4");
		String d = request.getParameter("email");
		String e = request.getParameter("phone");
		String f = request.getParameter("category3");
		String g = request.getParameter("category1");
		String h = request.getParameter("address");
		String m = request.getParameter("street");
		String j = request.getParameter("city");
		String k = request.getParameter("zip");
		

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?" + "user=root");
			
			PreparedStatement ps = con.prepareStatement("insert into user_info (iduser_info,name,dob,gender,email_address,contact_no,course_name,course_time,address,street,city,zip_code) values(NULL,?,STR_TO_DATE( ?, '%m/%d/%Y'),?,?,?,?,?,?,?,?,?)");

			ps.setString(1, a);
			ps.setString(2, b);
			ps.setString(3, c);
			ps.setString(4, d);
			ps.setString(5, e);
			ps.setString(6, f);
			ps.setString(7, g);
			ps.setString(8, h);
			ps.setString(9, m);
			ps.setString(10, j);
			ps.setString(11, k);
			

			int i = ps.executeUpdate();
			if (i > 0)
				out.print("Information Updated...");

		} catch (Exception e2) {
			System.out.println(e2);
		}

		out.close();
	}

}
