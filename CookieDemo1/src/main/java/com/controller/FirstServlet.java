package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FirstServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		
		out.print("<h1>"+name+"</h1> <br>");
		out.print("<h1>"+pass+"</h1> <br>");
		
		Cookie ck=new Cookie("ckid", pass);
		response.addCookie(ck);
		
		
		out.print("<hr>");
		out.print("<h1>");
		out.print("<a href='SecondServlet'> LINK </a>");
		out.print("</h1>");
		
		
		
		
		
	
	
	}

}
