package com.iFox.hh.dao;

import com.iFox.hh.entity.TeacherInfo;
import com.iFox.hh.utils.vo.Attendance;
import com.iFox.hh.utils.vo.HasCourse;
import com.iFox.hh.utils.vo.LeaveRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
public interface TeacherMapper {

    TeacherInfo getTeacher(@Param("account")String account, @Param("password") String password);

    List<HasCourse> callName(String teacher);

    void operate(Attendance attendance);

    List<LeaveRecord> getLeaveRecord(String teacher);

    void updateLeaveRecord(@Param("id") Long id,@Param("status") String status);

    Attendance isRecord(@Param("studentName") String studentName,@Param("courseName") String courseName);

    void updateAttendance(@Param("studentName") String studentName,@Param("courseName") String courseName, @Param("status") String status);
}
