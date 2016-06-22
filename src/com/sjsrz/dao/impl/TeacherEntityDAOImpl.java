package com.sjsrz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sjsrz.bean.StudentEntity;
import com.sjsrz.bean.TeacherEntity;
import com.sjsrz.dao.TeacherEntityDAO;
import com.sjsrz.util.DatabaseConnection;

public class TeacherEntityDAOImpl implements TeacherEntityDAO {

	public TeacherEntityDAOImpl() {
		// TODO 自动生成的构造函数存根
	}

	@Override

		public String login(int id, String pwd) {
			// TODO 自动生成的方法存根
			Connection conn=DatabaseConnection.getConnection();//获得连接
			String querySQL="SELECT * FROM teacherinfo WHERE teacher_id=? AND teacher_login_pwd=?";
			String teaName=null;
			try {
				PreparedStatement pstmt= (PreparedStatement) conn.prepareStatement(querySQL);//获得预处理对象
				pstmt.setInt(1,id);//设置第一个参数
				pstmt.setString(2,pwd);
				ResultSet rs=pstmt.executeQuery();//声明结果集，执行查询
				if(rs.next()){
					teaName=rs.getString("student_name");
				}
				DatabaseConnection.close(rs);
				DatabaseConnection.close(pstmt);
				DatabaseConnection.close(conn);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return teaName;

	}

	@Override
	public TeacherEntity queryTeacherEntityById(int teacher_id) {
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT teacherinfo.teacher_id,teacher_name,college_name"
				+"faculty_name,teahcer_email FROM teahcerinfo WHERE"
				+"teacher_id="+teacher_id;
		TeacherEntity teacher=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			rs.last();
				teacher=new TeacherEntity();
				teacher.setTeacher_id(rs.getInt("teacher_id"));
				teacher.setTeacher_name(rs.getString("teacher_name"));
				teacher.setCollege_name(rs.getString("college_name"));
				teacher.setFaculty_name(rs.getString("faculty_name"));
				teacher.setTeacher_email(rs.getString("teacher_email"));
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return teacher;
	}

	@Override
	public TeacherEntity[] queryTeacherEntityByName(String teacher_name) {
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT teacherinfo.teacher_id,teacher_name,college_name"
				+"faculty_name,teahcer_email FROM teahcerinfo WHERE"
				+"teacher_name="+teacher_name;
		TeacherEntity[] teacher=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			rs.last();
			teacher=new TeacherEntity[rs.getRow()];
			int i=0;
			rs.beforeFirst();
			while(rs.next()){
				teacher[i]=new TeacherEntity();
				teacher[i].setTeacher_id(rs.getInt("teacher_id"));
				teacher[i].setTeacher_name(rs.getString("teacher_name"));
				teacher[i].setCollege_name(rs.getString("college_name"));
				teacher[i].setFaculty_name(rs.getString("faculty_name"));
				teacher[i].setTeacher_email(rs.getString("teacher_email"));
				i++;
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return teacher;
	}

	@Override
	public TeacherEntity[] queryTeacherEntityByCollege(String college_name) {
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT teacherinfo.teacher_id,teacher_name,college_name"
				+"faculty_name,teahcer_email FROM teahcerinfo WHERE"
				+"college_name="+college_name;
		TeacherEntity[] teacher=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			rs.last();
			teacher=new TeacherEntity[rs.getRow()];
			int i=0;
			rs.beforeFirst();
			while(rs.next()){
				teacher[i]=new TeacherEntity();
				teacher[i].setTeacher_id(rs.getInt("teacher_id"));
				teacher[i].setTeacher_name(rs.getString("teacher_name"));
				teacher[i].setCollege_name(rs.getString("college_name"));
				teacher[i].setFaculty_name(rs.getString("faculty_name"));
				teacher[i].setTeacher_email(rs.getString("teacher_email"));
				i++;
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return teacher;
	}

	@Override
	public TeacherEntity[] queryTeacherEntityByFaculty(String faculty_name) {
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT teacherinfo.teacher_id,teacher_name,college_name"
				+"faculty_name,teahcer_email FROM teahcerinfo WHERE"
				+"faculty_name="+faculty_name;
		TeacherEntity[] teacher=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			rs.last();
			teacher=new TeacherEntity[rs.getRow()];
			int i=0;
			rs.beforeFirst();
			while(rs.next()){
				teacher[i]=new TeacherEntity();
				teacher[i].setTeacher_id(rs.getInt("teacher_id"));
				teacher[i].setTeacher_name(rs.getString("teacher_name"));
				teacher[i].setCollege_name(rs.getString("college_name"));
				teacher[i].setFaculty_name(rs.getString("faculty_name"));
				teacher[i].setTeacher_email(rs.getString("teacher_email"));
				i++;
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return teacher;
	}

	@Override
	public TeacherEntity[] queryTeacherEntityByClass(int class_id) {
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT teacherinfo.teacher_id,teacher_name,college_name"
				+"faculty_name,teahcer_email FROM teahcerinfo,classinfo WHERE"
				+"classinfo.class_id="+class_id+"AND classinfo.teacher_id=teacherinfo.id";
		TeacherEntity[] teacher=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			rs.last();
			teacher=new TeacherEntity[rs.getRow()];
			int i=0;
			rs.beforeFirst();
			while(rs.next()){
				teacher[i]=new TeacherEntity();
				teacher[i].setTeacher_id(rs.getInt("teacher_id"));
				teacher[i].setTeacher_name(rs.getString("teacher_name"));
				teacher[i].setCollege_name(rs.getString("college_name"));
				teacher[i].setFaculty_name(rs.getString("faculty_name"));
				teacher[i].setTeacher_email(rs.getString("teacher_email"));
				i++;
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return teacher;
	}

	@Override
	public int updateTeacherPwd(int id, String oldPwd, String newPwd) {
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT * FROM teacherinfo WHERE teacher_id="+id
				+"AND teacher_login_pwd="+"'"+oldPwd+"'";
		String updateSQL="UPDATE teacherinfo SET teacher_login_pwd="+"'"+
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

	@Override
	public int updateTeacherEmail(int id, String email) {
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT * FROM teacherinfo WHERE teacher_id="+id;
		String updateSQL="UPDATE teacherinfo SET teacher_email="+"'"+
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
