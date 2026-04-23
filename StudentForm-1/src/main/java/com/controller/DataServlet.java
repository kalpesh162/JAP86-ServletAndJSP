package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// http://localhost:8080/StudentForm-1/show
// ?id=11 & uname=sachin &marls=77
public class DataServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
			resp.setContentType("text/html");
			
			// We can write into the wev page 
			PrintWriter pw=resp.getWriter();
			
			String id=req.getParameter("id");
			
			int id1=Integer.parseInt(id);
			String name=req.getParameter("uname");
			String marks=req.getParameter("marks");
			
			double marks1=Double.parseDouble(marks);
			
			
			pw.print("<html>");
			pw.print("<body>");
			pw.print("<h1>");pw.print(id1);pw.print("</h1>");
			pw.print("<h1>");pw.print(name);pw.print("</h1>");
			pw.print("<h1>");pw.print(marks1);pw.print("</h1>");
		
			pw.print("</body>");
			pw.print("</html>");
			
		
		
	}

}
