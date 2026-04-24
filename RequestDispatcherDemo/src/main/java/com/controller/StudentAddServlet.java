package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentAddServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			double marks=Double.parseDouble(request.getParameter("marks"));
			
			Student student=new Student(id, name, marks);
			
			request.setAttribute("stud",student);
			
			request.getRequestDispatcher("/StudentShowServlet").forward(request, response);
					

	
	}

}
