package com.dao;

import java.util.List;

import com.model.Student;

public interface StudentDAO {

	int addStudent(Student student);

	int deleteStudent(Student student);

	int updateStudent(Student student);

	Student getStudentByID(int id);

	List<Student> getAllStudents();

}
