package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.StudentDAO;
import com.dao.StudentDAOImpl;
import com.model.Student;

@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));

		Student student = new Student();
		student.setId(id);

		StudentDAO studentDAO = new StudentDAOImpl();
		int res = studentDAO.deleteStudent(student);

		if (res > 0)
			out.print("<h1> " + " STUDENT DELETE SUCCESS !!!  " + "</h1>");

		else
			out.print("<h1> " + " STUDENT FAILED TO DELETE SUCCESS !!!  " + "</h1>");

	}

}
