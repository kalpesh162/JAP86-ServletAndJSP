package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionIdListener;
import javax.websocket.Session;

@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SessionServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		Integer cnt = new Integer(1);
		// request is assocsiated with Session
		// if session is there already then give me
		// or else create session if not
		HttpSession session = request.getSession();

		out.print("<h1> TIME INTERRVALA " + session.getMaxInactiveInterval() + "   </h1>");
		out.print("<hr>");
		if (session.getAttribute("visitCnt") != null) {
			cnt = (Integer) session.getAttribute("visitCnt") + 1;
			session.setAttribute("visitCnt", cnt);

		} else {
			session.setAttribute("visitCnt", cnt);
		}

		cnt = (Integer) session.getAttribute("visitCnt");

		out.print("<h1>  VISIT COUNT " + cnt + " </h1> <br>");
		out.print("<hr>");

		session.setMaxInactiveInterval(60);

		out.print("<h1> TIME INTERRVALA " + session.getMaxInactiveInterval() + "   </h1>");

		out.print("<h1>  <a href='SessionServlet'>" + "REFRESH" + "</a> </h1>");

	}

}
