package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/SecondServlet")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SecondServlet() {
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");

		PrintWriter out=response.getWriter();
		
		
		
		// is that request associates with Session if yes -- getSession
		// if not return null
		HttpSession session=request.getSession(false);
		//request.getSession(true);
		out.print("<h1>   Session ID  "+session.getId()+"</h1> <hr>");
		out.print("<h1>   Session getCreationTime  "+session.getCreationTime()+"</h1> <hr>");
		
		//long time=session.getCreationTime();
		out.print("<h1>   Session getCreationTime  "+new Date(session.getCreationTime())+"</h1> <hr>");
		
		out.print("<h1>   Session getLastAccessTime  "+new Date(session.getLastAccessedTime())+"</h1> <hr>");
		
		out.print("<h1>   SessionInterval  "+session.getMaxInactiveInterval()+"</h1> <hr>");
		
		
		String name=(String )session.getAttribute("key");
		out.print("<hr>");
		out.print("<h1>"+name+"</h1>");
		out.print("<hr>");

	
	}

}
