package com.sjsrz.dao;
import com.sjsrz.bean.AttendanceEntity;
import java.sql.*;
public interface AttendanceEntityDAO {
public AttendanceEntity queryAttendanceEntityByAttendance(int attendance_id);
public AttendanceEntity[] queryAttendanceEntityByClass(int class_id);
public AttendanceEntity[] queryAttendanceEntityByRecord(String record_time);
}
