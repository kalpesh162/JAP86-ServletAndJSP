package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.CookieHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogoutServlet() {
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

		Cookie ck1 = new Cookie("ckid", "");
		Cookie ck2 = new Cookie("ckid1", "");

		ck1.setMaxAge(0);
		ck2.setMaxAge(0);

		response.addCookie(ck1);
		response.addCookie(ck2);
		
		out.print("<h1> LOGOUT SUCCESS </h1>");

	}

}
