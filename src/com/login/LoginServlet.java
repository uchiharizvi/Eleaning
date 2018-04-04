package com.login;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String un=request.getParameter("EmailId");
		String pw=request.getParameter("PassWord");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		 // loads driver
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?" + "user=root");
		PreparedStatement ps = con.prepareStatement("select email_address,set_password from sign_up where email_address=? and set_password=?");
		ps.setString(1, un);
		ps.setString(2, pw);
 
		ResultSet rs = ps.executeQuery();
 
		while (rs.next()) {
			response.sendRedirect("profileindex.html");
			return;
		}
		response.sendRedirect("error.html");
		return;
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}