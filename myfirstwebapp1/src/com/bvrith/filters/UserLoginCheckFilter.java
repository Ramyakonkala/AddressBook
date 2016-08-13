package com.bvrith.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class UserLoginCheckFilter implements Filter {

    public void init(FilterConfig fConfig) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("UserLoginCheckUser init()");
    }
   
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        System.out.println("UserLoginCheckUser doProcess()");
        //typecasting to get to HttpServletRequest object
        HttpServletRequest hRequest = (HttpServletRequest)request;
        HttpServletResponse hResponse = (HttpServletResponse)response;
        // place your code here
        HttpSession hs = hRequest.getSession();
        String username =(String)hs.getAttribute("sname");
        //redirect
        if(username == null){
            hResponse.sendRedirect("loginpage.jsp?error=Not logged in!Login again");
        }

        // pass the request along the filter chain
        chain.doFilter(request, response);
    }
   
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("UserLoginCheckUser destroy()");
    }

   
   
   
}
