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

//http://localhost:BookWebApp1/deleteServlet?id=4
@WebServlet("/deleteBook")
public class DeleteBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private BookDao bookDao;

	public DeleteBookServlet() {
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

		int noOfRows = bookDao.deleteBookById(id);

		if (noOfRows > 0) {
			// if record add then show All Books with recent add
			out.print("<h1> BOOK DELETED !!! </h1> </hr> </br>");
			// request.getRequestDispatcher("/readBook").include(request, response);
			response.sendRedirect("/BookWebApp-1/readBook");
		} else {
			out.print("<h1> BOOK FAILED TO DELETE !!! </h1> </hr> </br>");
		}
	}

}
