/**
 * 
 */
package com.sjsrz.dao;

import com.sjsrz.bean.AdminEntity;
import java.sql.*;
/**
 *
 */
public interface AdminEntityDAO {
	public String login(int id,String pwd);
	public AdminEntity queryAdminEntityById(int id);
	public AdminEntity[] queryAdminEntityByName(String name);
	public int updateAdminPwd(int id,String oldPwd,String newPwd);
	public int updateAdminEmail(int id,String email);
}
