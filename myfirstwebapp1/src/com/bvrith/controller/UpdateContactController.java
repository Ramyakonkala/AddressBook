package com.bvrith.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bvrit.userDAO.ContactDAO;
//import com.bvrit.userDAO.UserDAO;
import com.bvrith.model.ContactBean;

public class UpdateContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int result;
		HttpSession hs = request.getSession();
		String user = (String) hs.getAttribute("sname");
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		System.out.println(" ** id ** ="+id);
		ContactDAO contact;
		if(name.equals("") || email.equals("") || phone.equals("")){
			response.sendRedirect("updateContact.jsp?msg=please enter the field");
		}
		else{
		try {
			contact = new ContactDAO();
			ContactBean cBean = new ContactBean(id, name, email, phone,user);
			result = contact.updateContact(cBean);			
			if(result == 1){
				response.sendRedirect("listcontact.jsp?msg=Contact Sucessfully changed!!");
			}
			else{
				response.sendRedirect("updateContact.jsp?msg=failed to update!! Try again...");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
