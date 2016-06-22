package com.sjsrz.dao;
import com.sjsrz.bean.TeacherEntity;

import java.sql.*;

public interface TeacherEntityDAO {
	public String login(int id,String pwd);
	public TeacherEntity queryTeacherEntityById(int teacher_id);
	public TeacherEntity[] queryTeacherEntityByName(String teacher_name);
	public TeacherEntity[] queryTeacherEntityByCollege(String college_name);
	public TeacherEntity[] queryTeacherEntityByFaculty(String faculty_name);
	public TeacherEntity[] queryTeacherEntityByClass(int class_id);
	public int updateTeacherPwd(int id,String oldPwd,String newPwd);
	public int updateTeacherEmail(int id,String email);
}
