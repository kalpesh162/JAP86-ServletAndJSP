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

@WebServlet("/updateBook")
public class UpdateBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;

	public UpdateBookServlet() {
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
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		float price = Float.parseFloat(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));

		Book book = new Book(title, author, price, quantity);
		book.setId(id);

		int noOfRows = bookDao.updateBook(book);

		if (noOfRows > 0) {
			// record Update
			out.print("<h1> BOOK UPDATE !!! </h1> </hr> </br>");
			// request.getRequestDispatcher("/readBook").include(request, response);
			response.sendRedirect("/BookWebApp-1/readBook");
		} else {
			out.print("<h1> BOOK FAILED TO UPADTE !!! </h1> </hr> </br>");
			request.getRequestDispatcher("index.html").include(request, response);
		}

	}

}
