package com.sjsrz.dao;

import com.sjsrz.bean.FacultyEntity;
import java.sql.*;
public interface FacultyEntityDAO {
public FacultyEntity queryFacultyEntityByName(String faculty_name);
public FacultyEntity[] queryFacultyEntityByAddress(String faculty_addtrss);
public FacultyEntity[] queryFacultyEntityByContact(String faculty_contact);
public FacultyEntity[] queryFacultyEntityByTel(String faculty_tel);
}
