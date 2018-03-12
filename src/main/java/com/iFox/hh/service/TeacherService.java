package com.iFox.hh.service;

import com.iFox.hh.entity.AdminInfo;
import com.iFox.hh.entity.TeacherInfo;
import com.iFox.hh.utils.vo.Attendance;
import com.iFox.hh.utils.vo.HasCourse;
import com.iFox.hh.utils.vo.LeaveRecord;

import java.util.List;

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
public interface TeacherService {

    TeacherInfo getTeacher(String account, String password);

    List<HasCourse> callName(String teacher);

    void operate(Attendance attendance);

    List<LeaveRecord> getLeaveRecord(String teacher);

    void updateLeaveRecord(Long id,String status);

    Attendance isRecord(String studentName, String courseName);

    void updateAttendance(String studentName, String courseName, String status);
}
