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

@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProfileServlet() {
		super();
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

		// First Check if session is there already or not
		// if there is no session here we dont want to create new one

		HttpSession session = request.getSession(false);
		if (session != null) {
			String name=(String)session.getAttribute("key");
			out.print("<h1> WELCOME  TO PROFILE  " + name + "</h1> <br>");

		} else {

			out.print("<h1>  RE LOGIN !!!  SESSION EXPIRES  !!! </h1>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);

		}

	}

}
