package com.bvrith.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bvrit.userDAO.ContactDAO;
import com.bvrith.model.ContactBean;
//import com.bvrit.userDAO.UserDAO;
//import com.bvrith.model.UserBean;

public class CreateContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		HttpSession hs = request.getSession();
		String user = (String) hs.getAttribute("sname");
		if(id.equals("") || name.equals("")||email.equals("")||phone.equals("")){
			response.sendRedirect("CreateContact.jsp?msg=Please fill the form");
		}
		else{
		try{
			ContactDAO contact = new ContactDAO();
			ContactBean cBean = new ContactBean(id, name, email, phone,user);
			int result = contact.addContact(cBean);
			if(result == 1){
				response.sendRedirect("listcontact.jsp?msg=contact sucessfully added");
			}		
			else{
			response.sendRedirect("CreateContact.jsp?msg= These user details already exists!");
		}
		}
			catch(Exception e){
				
			}
		}
	}

}
