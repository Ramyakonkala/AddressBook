package com.bvrith.controller;

import java.io.IOException;

import java.sql.SQLException;

//import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import com.bvrit.userDAO.UserDAO;
import com.bvrith.model.UserBean;


public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result;
		String name = request.getParameter("suser");
		String pwd = request.getParameter("spwd");
		
		if(name.equals("") || pwd.equals("")){
			response.sendRedirect("signup.jsp?msg=pleasefill the form");
		}
		else{
		try {
			UserDAO ud = new UserDAO();
			UserBean uBean = new UserBean(name,pwd);
			result = ud.createUser(uBean);

			if(result == 1){
				response.sendRedirect("loginpage.jsp?msg=Sucessfully registered!!");
			}
			else if(result != 1){
				response.sendRedirect("signup.jsp?msg="+name +" already exists! signup with different name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		}
	}

}
