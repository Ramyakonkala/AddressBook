package com.bvrith.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bvrit.userDAO.UserDAO;
import com.bvrith.model.UserBean;


public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean result;
		String name = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		HttpSession hs = request.getSession();
		hs.setAttribute("sname", name);
		UserDAO ud;
		try {
			ud = new UserDAO();
			UserBean uBean = new UserBean(name,pwd);
			result = ud.validateUser(uBean);
			 if(result){
					response.sendRedirect("WelcomePage.view");
				}
				else{
					response.sendRedirect("loginpage.jsp?username=" + name);
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
