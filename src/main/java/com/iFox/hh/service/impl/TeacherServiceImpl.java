package com.iFox.hh.service.impl;

import com.iFox.hh.dao.TeacherMapper;
import com.iFox.hh.entity.TeacherInfo;
import com.iFox.hh.service.TeacherService;
import com.iFox.hh.utils.vo.Attendance;
import com.iFox.hh.utils.vo.HasCourse;
import com.iFox.hh.utils.vo.LeaveRecord;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Resource
    private TeacherMapper teacherMapper;

    @Override
    public TeacherInfo getTeacher(String account, String password) {
        return teacherMapper.getTeacher(account, password);
    }

    @Override
    public List<HasCourse> callName(String teacher) {
        return teacherMapper.callName(teacher);
    }

    @Override
    public void operate(Attendance attendance) {
        teacherMapper.operate(attendance);
    }

    @Override
    public List<LeaveRecord> getLeaveRecord(String teacher) {
        return teacherMapper.getLeaveRecord(teacher);
    }

    @Override
    public void updateLeaveRecord(Long id,String status) {
        teacherMapper.updateLeaveRecord(id,status);
    }

    @Override
    public Attendance isRecord(String studentName, String courseName) {
        return teacherMapper.isRecord(studentName, courseName);
    }

    @Override
    public void updateAttendance(String studentName, String courseName, String status) {
        teacherMapper.updateAttendance(studentName, courseName, status);
    }
}
