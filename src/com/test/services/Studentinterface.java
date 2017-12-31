package com.test.services;

import java.util.List;

import com.test.models.Student;

public interface Studentinterface {
	
	public boolean addstudent(Student s);
	public List<Student> getstudent();
	public boolean deletestudent(int id);
	public boolean updateStudent(Student s);
	public Student getbyid(int id);

}
