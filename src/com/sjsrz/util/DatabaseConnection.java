package com.sjsrz.util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DatabaseConnection {
private static final String DBDRIVER= "com.mysql.jdbc.Driver"; 
private static final String DBURL="jdbc:mysql://localhost:3306/info";
private static final String DBUSER="root";
private static final String DBPASSWORD="rooy";
public static Connection getConnection(){
	Connection conn=null;
	
		try {
			Class.forName(DBDRIVER);
			conn=(Connection) DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return conn;	
}
public static void close(Connection conn){
	if(conn!=null){
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
public static void close(PreparedStatement pstmt){
	if(pstmt!=null){
		try {
			pstmt.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
public static void close(Statement stmt){
	if(stmt!=null){
		try {
			stmt.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
public static void close(ResultSet rs){
	if(rs!=null){
		try {
			rs.close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
	public DatabaseConnection() {
		// TODO 自动生成的构造函数存根
	}

}
