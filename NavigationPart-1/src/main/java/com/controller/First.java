package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/First")
public class First extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public First() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String name="Raja";
		
		request.setAttribute("uname", name);
		
		out.print("<h1>  FIRST PAGE </h1>");

		out.print("<h1>"+name +"</h1>");
		out.print("<hr>");
		
		out.print("<h1>  <a href='Second'> LINK </a> </h1>");

		out.print("<form action='Second' method='get'>");

		out.print("<input type='submit' value='CLICK'>");
		out.print("</form>");
		
		out.print("<hr>");
		//Object request.getAttribute("uname")
		out.print("<h1>");
		out.print((String)request.getAttribute("uname"));
		out.print("<h1>");

		
		RequestDispatcher rd=request.getRequestDispatcher("/Second");
		//rd.forward(request, response);
		rd.include(request, response);
	}

}
