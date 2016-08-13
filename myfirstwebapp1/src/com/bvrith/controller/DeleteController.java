package com.bvrith.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bvrit.userDAO.ContactDAO;

public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		int result;
		if(id != null){
			try {
				ContactDAO contact = new ContactDAO();
				result = contact.deleteContact(id);
				if(result >= 1){
					response.sendRedirect("listcontact.jsp?msg=Record Deleted");
				}
				else if(result != 1){
					response.sendRedirect("listcontact.jsp?msg=Unable to delete");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
	}

}
