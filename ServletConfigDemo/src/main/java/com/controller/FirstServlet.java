package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.ResolverStyle;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public FirstServlet() {
		System.out.println("Constrcuctort FirstServlet");
		
	}

	// One time intialization
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Before init Called");
		super.init(config); // Genric Servlet init(ServletConfig)
		System.out.println("After init Called");
	}

	// service
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//String url="jdbc:mysql://localhost:3306/db";
		System.out.println("Seevice Called");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<h1>" + "Hello" + "</h1>");
		
		// Hey Server --> right now FirstServlet Object
		// Need to access initialization Paramter from web.xml
		// ServletConfig is an interface
		// 
		
		//ServletConfig config=this.getServletConfig();
		ServletConfig config=getServletConfig();
		
		out.print("<h1>"+config.getInitParameter("driver")+"</h1>");
		
		ServletContext context=getServletContext();
		out.print("<h1>"+context.getInitParameter("url")+"</h1> <hr>");
		
		
	}

	@Override
	public void destroy() {
		System.out.println("Destrou Called");

	}

}
