package com.sjsrz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.sjsrz.bean.AdminEntity;
import com.sjsrz.bean.StudentEntity;
import com.sjsrz.dao.AdminEntityDAO;
import com.sjsrz.util.DatabaseConnection;

public class AdminEntityDAOImpl implements AdminEntityDAO {

	public AdminEntityDAOImpl() {
		// TODO �Զ����ɵĹ��캯�����
	}

	@Override
	public String login(int id, String pwd) {
		Connection conn=DatabaseConnection.getConnection();//�������
		String querySQL="SELECT * FROM admininfo WHERE admin_id=? AND admin_login_pwd=?";
		String admName=null;
		try {
			PreparedStatement pstmt= (PreparedStatement) conn.prepareStatement(querySQL);//���Ԥ�������
			pstmt.setInt(1,id);//���õ�һ������
			pstmt.setString(2,pwd);
			ResultSet rs=pstmt.executeQuery();//�����������ִ�в�ѯ
			if(rs.next()){
				admName=rs.getString("admin_name");
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(pstmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return admName;
	}

	@Override
	public AdminEntity queryAdminEntityById(int id) {
		// TODO �Զ����ɵķ������
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT admin_id,admin_name_admin_email FROM admininfo WHERE"
				+"admin_id="+id;
		AdminEntity admin=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			rs.last();
			admin=new AdminEntity();
			admin.setAdmin_id(rs.getInt("admin_id"));
			admin.setAdmin_name(rs.getString("student_name"));
			admin.setAdmin_email(rs.getString("admin_email"));
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return admin;
	}

	@Override
	public AdminEntity[] queryAdminEntityByName(String name) {
		// TODO �Զ����ɵķ������
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT admin_id,admin_name_admin_email FROM admininfo WHERE"
				+"admin_name="+name;
		AdminEntity[] admin=null;
		try {
			Statement stmt=(Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs=stmt.executeQuery(querySQL);
			
			rs.last();
			admin=new AdminEntity[rs.getRow()];
			int i=0;
			rs.beforeFirst();
			while(rs.next()){
			admin[i]=new AdminEntity();
			admin[i].setAdmin_id(rs.getInt("admin_id"));
			admin[i].setAdmin_name(rs.getString("student_name"));
			admin[i].setAdmin_email(rs.getString("admin_email"));
			i++;
			}
			DatabaseConnection.close(rs);
			DatabaseConnection.close(stmt);
			DatabaseConnection.close(conn);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return admin;
	}

	@Override
	public int updateAdminPwd(int id, String oldPwd, String newPwd) {
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT * FROM admininfo WHERE admin_id="+id
				+"AND admin_login_pwd="+"'"+oldPwd+"'";
		String updateSQL="UPDATE admininfo SET admin_login_pwd="+"'"+
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return returnVal;
	}

	@Override
	public int updateAdminEmail(int id, String email) {
		Connection conn=DatabaseConnection.getConnection();
		String querySQL="SELECT * FROM admininfo WHERE admin_id="+id;
		String updateSQL="UPDATE admininfo SET admin_email="+"'"+
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return returnVal;
	}

}
