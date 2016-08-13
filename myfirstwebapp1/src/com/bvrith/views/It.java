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

public class It extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	String phone;
	String head;
	@Override
	public void init(ServletConfig config) throws ServletException {
		head = config.getInitParameter("ITHead");
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
		out.print("<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color = brown>Welcome " + name + " to IT</font></h1><br>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("dept.html");
		dispatcher.include(request, response);
		out.print("<h1>Information Technology</h1>");
		out.print("<p><font size=4>Information technology (IT) is the application of computers and telecommunications equipment to store, retrieve, transmit and manipulate data,often in the context of a business or other enterprise.The term is commonly used as a synonym for computers and computer networks, but it also encompasses other information distribution technologies such as television and telephones. Several industries are associated with information technology, including computer hardware, software, electronics, semiconductors, internet, telecom equipment, e-commerce and computer services.Humans have been storing, retrieving, manipulating and communicating information since the Sumerians in Mesopotamia developed writing in about 3000 BC, but the term information technology in its modern sense first appeared in a 1958 article published in the Harvard Business Review; authors Harold J. Leavitt and ThomasL. Whisler commented that the new technology does not yet have a single established name. We shall call it information technology (IT).Tiir definition consists of three categories: techniques for processing, the application of statistical and mathematical methods to decision-making, and the simulation of higher-order thinking through computer programs</font></p>");
		out.print("<h3><b><u>Subjects</u></b></h3>");
		out.print("<font size = 3>Data Analysis</font>" + "<br>");
		out.print("<font size = 3>Environmental studies</font></abbr>"+ "<br>");
		out.print("<font size = 3>Java</font>" + "<br>");
		out.print("<h3> Head of department: "+ head + "</h3>" );
		out.print("<div align=right class=page-footer><b>For more information dial: "+phone+"</b></div>");	}
	
}
