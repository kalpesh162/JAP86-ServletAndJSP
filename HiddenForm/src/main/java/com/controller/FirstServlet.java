package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FirstServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		
		out.print("<h1>"+name+" </h1> <br>");
		
		// /SecondServlet
		
		// HiddenFormField
		
		out.print("<form action='SecondServlet' method='get'>");
		out.print("<input type='hidden' name='name' value='"+ name +"'>");
		out.print("<input type='submit' value='NEXT'>");
		out.print("</form>");
		
		// URL Rewrting
		
		out.print("<hr>");
		out.print("<h1>");
		out.print("<a href='SecondServlet?name="+name+"'>  LINK </a>");
		out.print("</h1>");
	
	
	}

}
