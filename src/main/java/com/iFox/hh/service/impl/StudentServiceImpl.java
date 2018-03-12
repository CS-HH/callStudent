package com.iFox.hh.service.impl;

import com.iFox.hh.dao.StudentMapper;
import com.iFox.hh.entity.StudentInfo;
import com.iFox.hh.service.StudentService;
import com.iFox.hh.utils.vo.Course;
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
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public StudentInfo getStudent(String number, String password) {
        return studentMapper.getStudent(number, password);
    }

    @Override
    public HasCourse isSelect(Long courseId,String studentName) {
        return studentMapper.isSelect(courseId,studentName);
    }

    @Override
    public Course getCourse(Long id) {
        return studentMapper.getCourse(id);
    }

    @Override
    public String getTeacherName(Integer teacherId) {
        return studentMapper.getTeacherName(teacherId);
    }

    @Override
    public void addHasCourse(HasCourse hasCourse) {
        studentMapper.addHasCourse(hasCourse);
    }

    @Override
    public List<HasCourse> queryHasCourse(String studentName) {
        return studentMapper.queryHasCourse(studentName);
    }

    @Override
    public void addLeave(LeaveRecord leaveRecord) {
        studentMapper.addLeave(leaveRecord);
    }

}
