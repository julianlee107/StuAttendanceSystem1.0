package com.sjsrz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import com.sjsrz.bean.AdminEntity;
import com.sjsrz.bean.AttendanceEntity;
import com.sjsrz.dao.AttendanceEntityDAO;
import com.sjsrz.util.DatabaseConnection;

public class AttendanceEntityDAOImpl implements AttendanceEntityDAO {

	public AttendanceEntityDAOImpl() {
		// TODO 自动生成的构造函数存根
		
	}

	@Override
	public AttendanceEntity queryAttendanceEntityByAttendance(int attendance_id) {
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT attendance_id,class_id,record_time FROM attendanceinfo WHERE"
				+"attendance_id="+attendance_id;
		AttendanceEntity attendance=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			rs.last();
			attendance=new AttendanceEntity();
			attendance.setAttendance_id(rs.getInt("attendance_id"));
			attendance.setClass_id(rs.getInt("class_id"));
			attendance.setRecord_time(rs.getString("record_time"));
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return attendance;
	}

	@Override
	public AttendanceEntity[] queryAttendanceEntityByClass(int class_id) {
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT attendance_id,class_id,record_time FROM attendanceinfo WHERE"
				+"class_id="+class_id;
		AttendanceEntity[] attendance=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			rs.last();
			attendance=new AttendanceEntity[rs.getRow()];
			int i=0;
			rs.beforeFirst();
			while(rs.next()){
			attendance[i]=new AttendanceEntity();
			attendance[i].setAttendance_id(rs.getInt("attendance_id"));
			attendance[i].setClass_id(rs.getInt("class_id"));
			attendance[i].setRecord_time(rs.getString("record_time"));
			i++;
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return attendance;
	}

	@Override
	public AttendanceEntity[] queryAttendanceEntityByRecord(String record_time) {
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT attendance_id,class_id,record_time FROM attendanceinfo WHERE"
				+"record_time="+record_time;
		AttendanceEntity[] attendance=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			rs.last();
			attendance=new AttendanceEntity[rs.getRow()];
			int i=0;
			rs.beforeFirst();
			while(rs.next()){
			attendance[i]=new AttendanceEntity();
			attendance[i].setAttendance_id(rs.getInt("attendance_id"));
			attendance[i].setClass_id(rs.getInt("class_id"));
			attendance[i].setRecord_time(rs.getString("record_time"));
			i++;
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return attendance;
	}

}
