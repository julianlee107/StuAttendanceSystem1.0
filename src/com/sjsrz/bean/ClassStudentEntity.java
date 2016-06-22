package com.sjsrz.bean;
/*
 * 存储课程中学生的信息
 * 课程中学生的学号和学生的ID、课程ID
 */
public class ClassStudentEntity {
int classStu_id;
int class_id;
int student_id;
public int getClassStu_id() {
	return classStu_id;
}
public void setClassStu_id(int classStu_id) {
	this.classStu_id = classStu_id;
}
public int getClass_id() {
	return class_id;
}
public void setClass_id(int class_id) {
	this.class_id = class_id;
}
public int getStudent_id() {
	return student_id;
}
public void setStudent_id(int student_id) {
	this.student_id = student_id;
}

}
