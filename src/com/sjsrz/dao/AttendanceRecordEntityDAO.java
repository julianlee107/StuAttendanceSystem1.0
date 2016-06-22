package com.sjsrz.dao;
import com.sjsrz.bean.AttendanceRecordEntity;
import java.sql.*;
public interface AttendanceRecordEntityDAO {
public AttendanceRecordEntity queryAttendanceRecordEntityById(int attendanceRecord_id);
public AttendanceRecordEntity[] queryAttendanceRecordEntityByAttendance(int attendance_id);
public AttendanceRecordEntity[] queryAttendanceRecordEntityByStudent(int student_id);
public AttendanceRecordEntity[] queryAttendanceRecordEntityStatus(String status);
}
