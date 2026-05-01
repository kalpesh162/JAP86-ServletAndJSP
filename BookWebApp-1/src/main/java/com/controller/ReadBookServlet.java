package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.BookDao;
import com.dao.BookDaoImpl;
import com.model.Book;

@WebServlet("/readBook")
public class ReadBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;

	public ReadBookServlet() {
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

		List<Book> bookList = bookDao.findAllBooks();

		out.print("<table border='border: 1px solid #dddddd;'>");
		out.print("<tr>");
		out.print("<th> ID </th>");
		out.print("<th> NAME </th>");
		out.print("<th> AUTHOR </th>");
		out.print("<th> PRICE </th>");
		out.print("<th> QUANTITY </th>");
		out.print("<th> DELETE </th>");
		out.print("<th> UPDATE </th>");
		out.print("</tr>");
		for (Book book : bookList) {
			out.print("<tr>");
			out.print("<td>" + book.getId() + "</td>");
			out.print("<td>" + book.getTitle() + "</td>");
			out.print("<td>" + book.getAuthor() + "</td>");
			out.print("<td>" + book.getPrice() + "</td>");
			out.print("<td>" + book.getQuantity() + "</td>");
			out.print("<td>");
			out.print("<a href='deleteBook?id="+book.getId()+"'>"+" DELETE "+"</a>");
			out.print("</td>");
			out.print("<td>");
			out.print("<a href='deleteBook?id="+book.getId()+"'>"+" UPDATE "+"</a>");
			out.print("</td>");
			out.print("</tr>");
		}

		out.print("</table>");

	}

}
