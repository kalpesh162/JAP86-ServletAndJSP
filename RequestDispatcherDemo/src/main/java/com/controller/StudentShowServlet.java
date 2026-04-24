package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;

@WebServlet("/StudentShowServlet")
public class StudentShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentShowServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Student student = (Student) request.getAttribute("stud");

		out.print("<h1 style=color:blue>");
		out.print("ID  :" + student.getId());
		out.print("Name  :" + student.getName());
		out.print("Marks  :" + student.getMarks());
		out.print("</h1>");

	}

}
