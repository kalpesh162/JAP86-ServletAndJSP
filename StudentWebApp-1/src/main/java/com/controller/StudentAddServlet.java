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

@WebServlet("/StudentAddServlet")
public class StudentAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentAddServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			// Values Are taking from form[Student Registratation]
			int id=Integer.parseInt(request.getParameter("id"));
			String name=request.getParameter("name");
			double marks=Double.parseDouble(request.getParameter("marks"));
					
			// Object  --> Student [Use Of Encapsulation]
			Student student=new Student(); student.setId(id); student.setName(name); student.setMarks(marks);
			
			// ADD ---> DB
			// addStudent()  StudentDAOImpl
			// StudentDAOImpl is a type of StudentDAO
			
			StudentDAO studentDAO=new StudentDAOImpl();
			// studentDAO  inside this has addStudent()
			
			int res=studentDAO.addStudent(student);
			
			if(res>0)
				out.print("<h1> "+" STUDENT ADD SUCCESS !!!  "+"</h1>");
			
			else
				out.print("<h1> "+" STUDENT FAILED TO ADD SUCCESS !!!  "+"</h1>");
		
			
			
	}

}
