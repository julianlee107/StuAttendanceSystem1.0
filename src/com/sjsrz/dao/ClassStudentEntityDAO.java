package com.sjsrz.dao;
import com.sjsrz.bean.ClassStudentEntity;
import java.sql.*;

public interface ClassStudentEntityDAO {
	public ClassStudentEntity queryClassStudentEntityById(int classStu_id);
	public ClassStudentEntity[] queryClassStudentEntityByClass(int class_id);
	public ClassStudentEntity[] queryClassStudentEntityByStudent(int student_id);
}
