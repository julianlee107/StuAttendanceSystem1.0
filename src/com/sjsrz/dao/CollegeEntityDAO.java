package com.sjsrz.dao;

import com.sjsrz.bean.CollegeEntity;
import java.sql.*;

public interface CollegeEntityDAO {
public CollegeEntity queryCollegeEntityByName(String college_name);
public CollegeEntity[] queryCollegeEntityByAddredd(String college_address);
public CollegeEntity[] queryCollegeEntityByContact(String college_contact);
public CollegeEntity[] queryCollegeEntityByTel(String college_tel);
}
