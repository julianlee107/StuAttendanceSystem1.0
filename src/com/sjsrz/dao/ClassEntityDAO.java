package com.sjsrz.dao;
import com.sjsrz.bean.ClassEntity;
public interface ClassEntityDAO {
public ClassEntity queryClassEntityById(int class_id);
public ClassEntity[] queryClassEntityByCourse(int course_id);
public ClassEntity[] queryClassEntityByName(String course_name);
public ClassEntity[] queryClassEntityByStart(int class_start_week);
public ClassEntity[] queryClassEntityByEnd(int class_end_week);
public ClassEntity[] queryClassEntityByTime(String class_time);
public ClassEntity[] queryClassEntityByTeacher(int teacher_id);
}
