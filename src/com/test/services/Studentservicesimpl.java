package com.test.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;

import com.test.databse.DBconnection;
import com.test.models.Student;

public class Studentservicesimpl implements Studentinterface
{
	Connection con = null;
	 public  Studentservicesimpl()
	 {
		
		con= DBconnection.getdbconnnection();
		 
		 
	}
	
	
	
	
	
	
	

	@Override
	public boolean addstudent(Student s) {
	
		
		String sql = "insert into student(username,Address,Faculty,phone) values(?,?,?,?)";
		
		
		
		try {
			
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, s.getUsername());
			pstm.setString(2, s.getAddress());
			pstm.setString(3, s.getFaculty());
			pstm.setString(4, s.getPhone());
			pstm.execute();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return false;
	}

	@Override
	public List<Student> getstudent() {
		List<Student> slist = new ArrayList<Student>();
		String sql ="select * from student";
		
	
		try {
			Statement	stm = con.createStatement();
			ResultSet rs =stm.executeQuery(sql);
			
			while(rs.next())
			{
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setUsername(rs.getString("username"));
				s.setAddress(rs.getString("Address"));
				s.setFaculty(rs.getString("Faculty"));
				s.setPhone(rs.getString("phone"));
				slist.add(s);
			}
			
			return slist;
			
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		return slist;
	}

	@Override
	public boolean deletestudent(int id) {
		
		String sql = "delete from student where id ='"+id+"' ";
		try
		{
Statement stm	=con.createStatement();
		stm.execute(sql);
		
		return true;
	
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return false;
}


	@Override
	public boolean updateStudent(Student s) {
		
		String sql = "update student set username=?,Address=?,Faculty=?,phone=? where id=?";
		
		try {
			PreparedStatement pstm = con.prepareStatement(sql);
			pstm.setString(1, s.getUsername());
			pstm.setString(2, s.getAddress());
			pstm.setString(3, s.getFaculty());
			pstm.setString(4, s.getPhone());
			pstm.setInt(5, s.getId());
			pstm.execute();
			return true;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return false;
	}

	@Override
	public Student getbyid(int id) {
		
		Student s = new Student();
		String sql ="select * from student where id = '"+id+"' ";
		
		
		try {
			Statement 	stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next())
				
			{
			
				s.setUsername(rs.getString("username"));
				s.setAddress(rs.getString("Address"));
				s.setFaculty(rs.getString("Faculty"));
				s.setPhone(rs.getString("phone"));
				
				
			}
			return s;
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
		return s;
	}
	
	
	
	
	
	
	

}
