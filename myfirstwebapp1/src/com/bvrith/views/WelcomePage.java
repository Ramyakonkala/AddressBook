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





public class WelcomePage extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	String phone;
	@Override
	public void init(ServletConfig config) throws ServletException {
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
			String msg = request.getParameter("msg");
			
			out.print("<div class = 'well-lg' style=background-color:F8F8F8>");
			
			out.print("<img src = ./images/bvritlogo.png width = 50px height = 50px><h1><font color = brown>Welcome " + name + "</font></h1><br>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("dept.html");
			dispatcher.include(request, response);
			
			out.print("<h1 align = center ><font color = red>GIVING WINGS TO WOMEN TECHNOCRATS!!! </font></h1>"
					+ "<p><font size = 4>&nbsp;&nbsp;&nbsp;&nbsp;BVRIT HYDERABAD College of Engineering for Women is established by Sri Vishnu Educational Society in the year 2012. It started with the noble mission of creating women technocrats  with an intake of 240 students.Since its inception it has grown in stature to an institution of considerable repute under JNTU affiliated Engineering colleges. It stands in the Top Three position in pass percentage. It is the vision of our Founder Chairman Sri.K.V.Vishnu Raju garu to enable young women to unchain barriers and reach greater heights. The Institute is duly approved by the All India Council for Technical Education and the Government of Telangana State and is affiliated to Jawaharlal Nehru Technological University, HYDERABAD.</font></p>"
					+ "<p><font size = 4>&nbsp;&nbsp;&nbsp;&nbsp;BVRIT HYDERABAD is the Second Engineering College for Women from Sri Vishnu Educational Society, the First being Shri Vishnu Engineering College for Women in Bhimavaram, West Godavari District. The purpose of establishing BVRIT HYDERABAD College of Engineering for Women is to provide an excellent technical platform for the girls in the region, so that they can hone their talent and skills to compete in the global scenario. It is the aim to identify and meet the special/diverse needs of each individual in the college community; physical, intellectual, social, emotional, aesthetic and spiritual.</p> <p>BVRIT HYDERABAD is located at Nizampet (near JNTU Hyderabad).The college is well connected with bus service at intra-city level. The aesthetic beauty and lush green surroundings charm the visitors at first sight. BVRIT HYDERABAD has the distinct advantage of good pedigree and proven excellence in providing quality engineering education.</font></p>"
					+ "<p><font size = 4>&nbsp;&nbsp;&nbsp;&nbsp;BVRITH warmly welcomes applicants and parents to join and share our vision of excellence in technical education!</font></p>");
			out.print("<div align=right class=page-footer><b>For more information dial: "+phone+"</b></div>");
			//out.print("<h3 align = right> Contact@"+phone +"</h3>");
			if(msg != null){
				out.print("<br><font color=blue>" +  msg + "</font color>");
			}
		}
}
