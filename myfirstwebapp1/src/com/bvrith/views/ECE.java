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


public class ECE extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String phone;
	String head;
	@Override
	public void init(ServletConfig config) throws ServletException {
		head = config.getInitParameter("ECEHead");
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
		out.print("<h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font color = brown>Welcome " + name + " to ECE</font></h1><br>");
		RequestDispatcher dispatcher = request.getRequestDispatcher("dept.html");
		dispatcher.include(request, response);
		out.print("<h1>Electronics and communication Engineering</h1>");
		out.print("<p><font size=4>Electronics and electrical engineering degree programs "
				+ "with communication concentrations are typically offered from the bachelor's to the doctoral "
				+ "level. These programs prepare students for careers as systems engineers, research engineers, controls engineers,"
				+ " communication engineers and electronic engineers, as well as researchers and university professors. The programs are "
				+ "rigorous with an emphasis in math and science. Students study topics such as wireless, digital, data and fiber optic communic"
				+ "ations. Students should look for programs accredited by ABET (www.abet.org). Engineers who offer their services directly to the "
				+ "public must be licensed by the state, which typically requires graduation from an ABET-accredited program. </font></p>");
		out.print("<h3><b><u>Subjects</u></b></h3>");
		out.print("<font size = 3><abbr title = EnvironmentalStudies>ES</abbr></font>" + "<br>");
		out.print("<font size = 3><abbr title = ElcectronicCircuitAnalysis>ECA</font></abbr>"+ "<br>");
		out.print("<font size = 3><abbr title = Signals&Systems>SS</abbr></font>" + "<br>");
		out.print("<h3> Head of department: "+ head + "</h3>" );
		out.print("<div align=right class=page-footer><b>For more information dial: "+phone+"</b></div>");
		
	}
	

}
