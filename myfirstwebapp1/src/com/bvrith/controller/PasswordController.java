package com.bvrith.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bvrit.userDAO.UserDAO;

public class PasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result;
		String name = request.getParameter("puser");
		String pwd = request.getParameter("pwd");
		String rpwd = request.getParameter("rpwd");
		UserDAO ud;
		if(name.equals("") || pwd.equals("") || rpwd.equals("")){
			response.sendRedirect("password.jsp?msg=please enter the field");
		}
		else{
		try {
			ud = new UserDAO();
			result = ud.updateUser(name, pwd,rpwd);
			if(result == 1){
				response.sendRedirect("loginpage.jsp?msg=password Sucessfully changed!!");
			}
			else{
				response.sendRedirect("password.jsp?msg=Invalid current password! enter again...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
