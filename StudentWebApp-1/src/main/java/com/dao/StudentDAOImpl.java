package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.utility.DBUtility;

public class StudentDAOImpl implements StudentDAO {

	@Override
	public int addStudent(Student student) {
		int rows = 0;

		String sql = "insert into  student (id,name,marks)  values(?,?,?)";
		try (Connection con = DBUtility.getDBUtility().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setDouble(3, student.getMarks());
			rows = ps.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException("StudentAddException " + e);
		}

		return rows;
	}

	@Override
	public int deleteStudent(Student student) {
		int rows = 0;

		String sql = "delete from student where id=?";
		try (Connection con = DBUtility.getDBUtility().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(1, student.getId());
			rows = ps.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException("StudentDELETEException " + e);
		}

		return rows;
	}

	@Override
	public int updateStudent(Student student) {
		int rows = 0;

		String sql = "update student set name=? , marks=? where id=?";
		try (Connection con = DBUtility.getDBUtility().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ps.setInt(3, student.getId());
			ps.setString(1, student.getName());
			ps.setDouble(2, student.getMarks());
			rows = ps.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException("StudentUPDATEException " + e);
		}

		return rows;
	}

	@Override
	public Student getStudentByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudents() {

		List<Student> list = new ArrayList<Student>();
		String sql = "SELECT * FROM STUDENT";
		try (Connection con = DBUtility.getDBUtility().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql);) {
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Student student = new Student();
				student.setId(rs.getInt("id"));
				student.setName(rs.getString("name"));
				student.setMarks(rs.getDouble("marks"));
				list.add(student);
			}
		} catch (Exception e) {
			throw new RuntimeException("StudentReadException " + e);
		}

		return list;
	}

}
