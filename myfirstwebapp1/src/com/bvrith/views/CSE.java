package com.bvrith.views;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CSE extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String phone;
	String head;
	@Override
	public void init(ServletConfig config) throws ServletException {
		head = config.getInitParameter("CSEHead");
		ServletContext ctx = config.getServletContext();
		phone = ctx.getInitParameter("phone");
		
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		HttpSession hs = request.getSession();
		String name = (String)hs.getAttribute("sname");
		
		PrintWriter out = response.getWriter();
		out.print("<div class = 'well-lg' style=background-color:F8F8F8>");
		out.print("<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color = brown>Welcome " + name + " to CSE</font></h1><br>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("dept.html");
		dispatcher.include(request, response);
		out.print("<h1>Computer Science and Engineering</h1>");
		out.print("<p><font size=4>Computer engineering is a discipline that integrates several fields of "
				+ "electrical engineering and computer science required to develop computer hardware and software."
				+ " Computer engineers usually have training in electronic engineering (or electrical engineering),"
				+ " software design, and hardware-software integration instead of only software engineering or electronic engineering. Computer engineers are involved in many hardware and software aspects of computing, from the design of individual microcontrollers, microprocessors, personal computers, and supercomputers, to circuit design. This field of engineering not only focuses on how computer systems "
				+ "themselves work, but also how they integrate into the larger picture</font></p>");
		out.print("<h3><b><u>Subjects</u></b></h3>");
		out.print("<font size = 3>Java</font>" + "<br>");
		out.print("<font size = 3>DataBase</font></abbr>"+ "<br>");
		out.print("<font size = 3>FLAT</font>" + "<br>");
		out.print("<h3> Head of department: "+ head + "</h3>" );
		out.print("<div align=right class=page-footer><b>For more information dial: "+phone+"</b></div>");
	}
	
}
