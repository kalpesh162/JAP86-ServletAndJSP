package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;
import com.dao.BookDaoImpl;
import com.model.Book;

@WebServlet("/updateFormBookServlet")
public class UpdateBookFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;

	public UpdateBookFormServlet() {
		super();
	}

	@Override
	public void init() throws ServletException {
		bookDao = new BookDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int id = Integer.parseInt(request.getParameter("id"));

		// Book associated with that id
		Book book = bookDao.findBookById(id);

		// All info book will be show in here in Form

		out.print("<h2> BOOK UPDATE FORM </h2>");
		out.print("<form action='updateBook' method='get'> ");
		out.print("<label> ID </label> <br>");
		out.print("<input type='text' name='id' value='" + book.getId() + "' readonly > <br>");
		out.print("<label> TITLE </label> <br>");
		out.print("<input type='text' name='title' value='" + book.getTitle() + "' > <br>");
		out.print("<label> AUTHOR </label> <br>");
		out.print("<input type='text' name='author' value='" + book.getAuthor() + "' > <br>");
		out.print("<label> PRICE </label> <br>");
		out.print("<input type='text' name='price' value='" + book.getPrice() + "' > <br>");
		out.print("<label> Quantity </label> <br>");
		out.print("<input type='text' name='quantity' value='" + book.getQuantity() + "' > <br>");
		out.print("<input type='submit' value='UPDATE'> <br>");

		out.print("</form>");

	}

}
