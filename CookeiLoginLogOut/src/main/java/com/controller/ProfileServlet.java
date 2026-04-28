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
		System.out.println("(((((())))))");
		Cookie ck[] = request.getCookies();
		boolean flag = false;
		// ckid root ckid1 user
		
		
		if (ck != null) {
			
			System.out.println("CK IS NOT NULL");

			for (int i = 0; i < ck.length - 1; i++) {
				String ckid = ck[i].getName();
				String val = ck[i].getValue();
				String ckid1 = ck[i + 1].getName();
				String val1 = ck[i + 1].getValue();
				System.out.println(ckid +"  "+val);
				System.out.println(ckid1 +"  "+val1);
				if (val.equals("root") && val1.equals("user")) {
					out.print("<h1>"+val +" <h1> <hr>");
					out.print("<h1>"+val1 +" <h1>");
					flag = true;
					break;
				}

			}

		} else {
			out.print("<h1>  RE LOGIN !!! </h1>");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request, response);

		}
		
		if(flag) {
			out.print("<h1> WELCOME TO PROFILE </h1>");
		}
		
	}

}
