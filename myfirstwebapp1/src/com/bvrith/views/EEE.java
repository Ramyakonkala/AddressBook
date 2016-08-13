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


public class EEE extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String phone;
	String head;
	@Override
	public void init(ServletConfig config) throws ServletException {
		head = config.getInitParameter("EEEHead");
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
		out.print("<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color = brown>Welcome " + name + " to EEE</font></h1><br>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("dept.html");
		dispatcher.include(request, response);
		out.print("<h1>Electrical and Electronic Engineering</h1>");
		out.print("<p><font size=4>Electrical engineering is a field of engineering that generally deals with the study and application of electricity, electronics, and "
				+ "electromagnetism. This field first became an identifiable occupation in the latter half of the 19th century after commercialization of the electric telegraph, the telephone, and electric power distribution and use. Subsequently, broadcasting and recording media made electronics part of daily life. The invention of the transistor, and later the integrated circuit, brought down the cost of electronics to the point where they can be used in almost any household object</font></p>");
		out.print("<p><font size=4>Electrical engineering has now subdivided into a wide range of subfields including electronics, digital computers, power engineering, telecommunications, control systems, radio-frequency engineering, signal processing, instrumentation, and microelectronics. The subject of electronic engineering is often treated as its own subfield but it intersects with all the other "
				+ "subfields, including the power electronics of power engineering.</font></p>");
		out.print("<h3><b><u>Subjects</u></b></h3>");
		out.print("<font size = 3>Electrical Machines</font>" + "<br>");
		out.print("<font size = 3>Control Systems</font></abbr>"+ "<br>");
		out.print("<font size = 3>Power Systems</font>" + "<br>");
		out.print("<h3> Head of department: "+ head + "</h3>" );
		out.print("<div align=right class=page-footer><b>For more information dial: "+phone+"</b></div>");
	}
	
}
