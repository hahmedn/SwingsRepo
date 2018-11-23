package com.cg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.database.DatabaseConnection;
import com.cg.entity.Student;

public class StudentDaoImpl implements IStudentDao{

	Connection connection = DatabaseConnection.getConnection();
	PreparedStatement ps = null;

	public int insertStudent(Student st) {

		    try {
		    	String sql = "INSERT INTO student_master(id, name, rollno) VALUES (studentid_sequence.NEXTVAL, ?, ?)";
		    	String sqlSeq = "SELECT studentid_sequence.CURRVAL FROM DUAL";

		        ps = connection.prepareStatement(sql);
		        ps.setString(1, st.getName());
		        ps.setInt(2, st.getRollno());

		        int i = ps.executeUpdate();

		        ps = connection.prepareStatement(sqlSeq);
		    	ResultSet resultSet = ps.executeQuery();
		    	if(resultSet.next()) {
		    		   resultSet.getInt(1);

		      if(i > 0) {
		    		   return 1;
		    	  }
		    	  else
		    		  return 0;
		      }
		    } catch (SQLException ex) {
		        System.out.println(ex.getMessage());
		    }catch (Exception e) {
				System.out.println(e.getMessage());
			}
		    return 0;
	}

	public boolean updateStudent(Student st) {

		try {
			String sql = "UPDATE student_master SET name=?, rollno=? WHERE id=?";

			ps = connection.prepareStatement(sql);
			ps.setString(1, st.getName());
			ps.setInt(2, st.getRollno());
			ps.setInt(3, st.getId());

			int rowsUpdated = ps.executeUpdate();
			if (rowsUpdated > 0) {
			    return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		 return false;
	}

	public int deleteStudent(Student st) {

		String sql="DELETE FROM student_master WHERE id = ?";

		try {
			 ps = connection.prepareStatement(sql);

			ps.setInt(1, st.getId());

			int rs=ps.executeUpdate();

			if(rs > 0)
				return 1;
		} catch (SQLException e) {
			System.out.println("Query syntax wrong "+e.getMessage());
		}
		return 0;
	}

	public List<Student> getStudentDetail() {

		ArrayList<Student> li =new ArrayList<Student>();

		Connection con=DatabaseConnection.getConnection();
		String sql="SELECT * FROM student_master";

	try {
		 ps=con.prepareStatement(sql);

		ResultSet rs=ps.executeQuery();

		while(rs.next())
		{
			Student stu = new Student();
			stu.setId(rs.getInt(1));
			stu.setName(rs.getString(2));
			stu.setRollno(rs.getInt(3));

			li.add(stu);
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
			return li;
		}

	public Student getStudentById(int id) {

		Student st = new Student();
	try {
		  Connection con=DatabaseConnection.getConnection();

		 String sql="SELECT * FROM student_master WHERE id = ?";
		 ps=con.prepareStatement(sql);

		 ps.setInt(1, id);

		ResultSet rs=ps.executeQuery();

		while(rs.next())
		{
			st.setId(rs.getInt(1));
			st.setName(rs.getString(2));
			st.setRollno(rs.getInt(3));
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return st;

		}

}
