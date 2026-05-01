package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;
import com.dao.BookDaoImpl;
import com.model.Book;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;

	public AddBookServlet() {

	}

	@Override
	public void init() throws ServletException {
		bookDao = new BookDaoImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		Book book = new Book(title, author, price, quantity);

		int noOfRows = bookDao.addBook(book);

		if (noOfRows > 0) {
			// if record add then show All Books with recent add
			out.print("<h1> BOOK ADDED !!! </h1> </hr> </br>");
			request.getRequestDispatcher("/readBook").include(request, response);
		} else {
			out.print("<h1> BOOK FAILED TO ADDED !!! </h1> </hr> </br>");
			request.getRequestDispatcher("index.html").include(request, response);
		}

	}

}
