package com.sjsrz.dao.impl;


import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sjsrz.bean.StudentEntity;
import com.sjsrz.dao.StudentEntityDAO;
import com.sjsrz.util.DatabaseConnection;


public class StudentEntityDAOImpl implements StudentEntityDAO {

	public StudentEntityDAOImpl() {
		// TODO 自动生成的构造函数存根
	}

	public String login(int id, String pwd) {
		// TODO 自动生成的方法存根
		Connection conn=DatabaseConnection.getConnection();//获得连接
		String querySQL="SELECT * FROM studentinfo WHERE student_id=? AND student_login_pwd=?";
		String stuName=null;
		try {
			PreparedStatement pstmt= (PreparedStatement) conn.prepareStatement(querySQL);//获得预处理对象
			pstmt.setInt(1,id);//设置第一个参数
			pstmt.setString(2,pwd);
			ResultSet rs=pstmt.executeQuery();//声明结果集，执行查询
			if(rs.next()){
				stuName=rs.getString("student_name");
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(pstmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return stuName;
	}

	public StudentEntity queryStudentEntityById(int student_id) {
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT studentinfo.student_id,student_name,student_college"
				+"student_major,student_email FROM studentinfo WHERE"
				+"studeninfot.student_id="+student_id;
		StudentEntity student=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			rs.last();
				student=new StudentEntity();
				student.setStudent_id(rs.getInt("student_id"));
				student.setStudent_name(rs.getString("student_name"));
				student.setStudent_college(rs.getString("student_college"));
				student.setStudent_major(rs.getString("student_major"));
				student.setStudent_email(rs.getString("student_email"));
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return student;
	}
	public StudentEntity[] queryStudentEntityByName(String student_name) {
		// TODO 自动生成的方法存根
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT studentinfo.student_id,student_name,student_college"
				+"student_major,student_email FROM studentinfo WHERE"
				+"studentinfo.student_name="+student_name;
		StudentEntity[] student=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			rs.last();
			student=new StudentEntity[rs.getRow()];
			int i=0;
			rs.beforeFirst();
			while(rs.next()){
				student[i]=new StudentEntity();
				student[i].setStudent_id(rs.getInt("student_id"));
				student[i].setStudent_name(rs.getString("student_name"));
				student[i].setStudent_college(rs.getString("student_college"));
				student[i].setStudent_major(rs.getString("student_major"));
				student[i].setStudent_email(rs.getString("student_email"));
				i++;
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return student;
	}

	
	public StudentEntity[] queryStudentEntityByCollege(String student_college) {
		// TODO 自动生成的方法存根
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT studentinfo.student_id,student_name,student_college"
				+"student_major,student_email FROM studentinfo WHERE"
				+"studentinfo.student_college="+student_college;
		StudentEntity[] student=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			rs.last();
			student=new StudentEntity[rs.getRow()];
			int i=0;
			rs.beforeFirst();
			while(rs.next()){
				student[i]=new StudentEntity();
				student[i].setStudent_id(rs.getInt("student_id"));
				student[i].setStudent_name(rs.getString("student_name"));
				student[i].setStudent_college(rs.getString("student_college"));
				student[i].setStudent_major(rs.getString("student_major"));
				student[i].setStudent_email(rs.getString("student_email"));
				i++;
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return student;
	}


	public StudentEntity[] queryStudentEntityByMajor(String student_major) {
		// TODO 自动生成的方法存根
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT studentinfo.student_id,student_name,student_college"
				+"student_major,student_email FROM studentinfo WHERE"
				+"student_major="+student_major;
		StudentEntity[] student=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			rs.last();
			student=new StudentEntity[rs.getRow()];
			int i=0;
			rs.beforeFirst();
			while(rs.next()){
				student[i]=new StudentEntity();
				student[i].setStudent_id(rs.getInt("student_id"));
				student[i].setStudent_name(rs.getString("student_name"));
				student[i].setStudent_college(rs.getString("student_college"));
				student[i].setStudent_major(rs.getString("student_major"));
				student[i].setStudent_email(rs.getString("student_email"));
				i++;
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return student;
	}
	public StudentEntity[] queryStudentEntityByClass(int class_id) {
		// TODO 自动生成的方法存根
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT studentinfo.student_id,student_name,student_college"
				+"student_major,student_email FROM studentinfo"
				+"WHERE classstudent.class_id="+class_id+"AND classstudentinfo.student_id=studentinfo.stuent_id";
		StudentEntity[] student=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			rs.last();
			student=new StudentEntity[rs.getRow()];
			int i=0;
			rs.beforeFirst();
			while(rs.next()){
				student[i]=new StudentEntity();
				student[i].setStudent_id(rs.getInt("student_id"));
				student[i].setStudent_name(rs.getString("student_name"));
				student[i].setStudent_college(rs.getString("student_college"));
				student[i].setStudent_major(rs.getString("student_major"));
				student[i].setStudent_email(rs.getString("student_email"));
				i++;
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return student;
	}

	public int updateStudentPwd(int id, String oldPwd, String newPwd) {
		// TODO 自动生成的方法存根
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT * FROM studentinfo WHERE student_id="+id
				+"AND student_login_pwd="+"'"+oldPwd+"'";
		String updateSQL="UPDATE studentinfo SET student_login_pwd="+"'"+
				newPwd+"'";
		int returnVal=-1;
		Statement stmt;
		try {
			stmt = (Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery(querySQL);
			if(rs.next()){
				returnVal=stmt.executeUpdate(updateSQL);
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return returnVal;
	}


	public int updateStudentEmail(int id, String email) {
		// TODO 自动生成的方法存根
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT * FROM studentinfo WHERE student_id="+id;
		String updateSQL="UPDATE studentinfo SET student_email="+"'"+
				email+"'";
		int returnVal=-1;
		Statement stmt;
		try {
			stmt = (Statement) conn.createStatement();
			ResultSet rs=stmt.executeQuery(querySQL);
			if(rs.next()){
				returnVal=stmt.executeUpdate(updateSQL);
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return returnVal;
	}
	}
