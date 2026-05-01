package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.print("<h1>");
		out.print("<a href='index.html'> LOGIN </a>");
		out.print("<a href='ProfileServlet'> PROFILE </a>");
		out.print("<a href='LogoutServlet'> LOGOUT </a>");
		out.print("</h1>");
		out.print("<hr>");

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");

		if (name.equals("user") && pass.equals("root")) {

			out.print("<h1> WELCOME   " + name + "</h1> <br>");
			out.print("<h1>  YOUR PASSWORD " + pass + "</h1> <br>");

			// Create Session if login Success
			// How to create Session
			HttpSession session = request.getSession();

			// Add name to the session
			session.setAttribute("key", name);

		} else {
			out.print("<h1> INCORRECT CREDENTIALS </h1>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}

	}

}
