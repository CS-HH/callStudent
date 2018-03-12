package com.iFox.hh.service;

import com.iFox.hh.entity.AdminInfo;
import com.iFox.hh.entity.StudentInfo;
import com.iFox.hh.utils.vo.Course;
import com.iFox.hh.utils.vo.HasCourse;
import com.iFox.hh.utils.vo.LeaveRecord;

import java.util.List;

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
public interface StudentService {

    StudentInfo getStudent(String number, String password);

    HasCourse isSelect(Long courseId,String studentName);

    Course getCourse(Long id);

    String getTeacherName(Integer teacherId);

    void addHasCourse(HasCourse hasCourse);

    List<HasCourse> queryHasCourse(String student);

    void addLeave(LeaveRecord leaveRecord);
}
