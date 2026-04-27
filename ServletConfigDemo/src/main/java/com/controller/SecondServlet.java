package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public SecondServlet() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<h1>" + "Hello" + "</h1>");

		// Hey Server --> right now FirstServlet Object
		// Need to access initialization Paramter from web.xml
		// ServletConfig is an interface
		//

		// ServletConfig config=this.getServletConfig();
		ServletConfig config = getServletConfig();

		out.print("<h1>" + config.getInitParameter("driver") + "</h1> <hr>");

		

		ServletContext context=getServletContext();
		out.print("<h1>"+context.getInitParameter("url")+"</h1>");
		
	}

}
