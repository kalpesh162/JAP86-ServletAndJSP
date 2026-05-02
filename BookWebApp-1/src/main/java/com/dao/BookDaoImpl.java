package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.exception.BookDAOException;
import com.model.Book;
import com.utility.DBUtility;

public class BookDaoImpl implements BookDao {

	@Override
	public int addBook(Book book) {
		// step 1 : find Connection [database]
		// step 2 : write Query
		int rows = 0;
		String sql = "insert into books (title,author,price,qty) values (?,?,?,?)";
		try (Connection con = DBUtility.getDBUtility().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setFloat(3, book.getPrice());
			ps.setInt(4, book.getQuantity());
			rows = ps.executeUpdate();

		} catch (Exception e) {
			// throw e;
			throw new BookDAOException("Error adding book" + e);
		}

		return rows;
	}

	@Override
	public int updateBook(Book book) {
		int rows = 0;
		String sql = "update books set title=?, author=?, price=?, qty=? where id=?";
		try (Connection con = DBUtility.getDBUtility().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, book.getTitle());
			ps.setString(2, book.getAuthor());
			ps.setFloat(3, book.getPrice());
			ps.setInt(4, book.getQuantity());
			ps.setInt(5, book.getId());
			rows = ps.executeUpdate();

		} catch (Exception e) {
			// throw e;
			throw new BookDAOException("Error Updating  Book " + book);
		}

		return rows;
	}

	@Override
	public int deleteBookById(int id) {
		int rows = 0;
		String sql = "delete from books where id=?";
		try (Connection con = DBUtility.getDBUtility().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			rows = ps.executeUpdate();

		} catch (Exception e) {
			// throw e;
			throw new BookDAOException("Error DELETING  Book WITH ID  " + id);
		}

		return rows;
	}

	@Override
	public Book findBookById(int id) {
		Book book = null;
		String sql = "SELECT * FROM BOOKS WHERE id=?";
		try (Connection con = DBUtility.getDBUtility().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getFloat("price"));
				book.setQuantity(rs.getInt("qty"));
				break;
			}

		} catch (Exception e) {
			// throw e;
			throw new BookDAOException("Error finding  Book With" + id);
		}

		return book;
	}

	@Override
	public List<Book> findAllBooks() {
		List<Book> list = new ArrayList<Book>();
		String sql = "SELECT * FROM BOOKS";
		try (Connection con = DBUtility.getDBUtility().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));
				book.setPrice(rs.getFloat("price"));
				book.setQuantity(rs.getInt("qty"));
				list.add(book);
			}

		} catch (Exception e) {
			// throw e;
			throw new BookDAOException("Error Reading  All Book ");
		}

		return list;
	}

}
