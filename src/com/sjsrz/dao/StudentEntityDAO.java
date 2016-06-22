package com.sjsrz.dao;
import com.sjsrz.bean.StudentEntity;

import java.sql.*;
public interface StudentEntityDAO {
	public String login(int id,String pwd);
	public StudentEntity queryStudentEntityById(int student_id);
	public StudentEntity[] queryStudentEntityByName(String student_name);
	public StudentEntity[] queryStudentEntityByCollege(String student_college);
	public StudentEntity[] queryStudentEntityByMajor(String student_major);
	public StudentEntity[] queryStudentEntityByClass(int class_id);
	public int updateStudentPwd(int id,String oldPwd,String newPwd);
	public int updateStudentEmail(int id,String email);
}
