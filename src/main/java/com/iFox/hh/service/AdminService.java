package com.iFox.hh.service;


import com.iFox.hh.entity.AdminInfo;
import com.iFox.hh.entity.StudentInfo;
import com.iFox.hh.entity.TeacherInfo;
import com.iFox.hh.utils.vo.AudioRecord;
import com.iFox.hh.utils.vo.Course;
import com.iFox.hh.utils.vo.HasCourse;

import java.util.List;

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
public interface AdminService {

    AdminInfo getAdmin(String account, String password);

    void addStudent(StudentInfo studentInfo);

    void addTeacher(TeacherInfo teacherInfo);

    void addCourse(Course course);

    List<TeacherInfo> queryTeacher();

    List<StudentInfo> queryStudent();

    List<Course> queryCourse();

    void updateStudent(StudentInfo studentInfo);

    void updateTeacher(TeacherInfo teacherInfo);
    
    void updateCourse(Course course);

    void deleteCourse(Integer courseId);

    void deleteTeacher(Integer teacherId);

    void deleteStudent(Integer studentId);

    String getCourseName(Integer id);

    void addAudio(AudioRecord audioRecord);

    String getAudio(String teacher);

    List<HasCourse> queryHasCourse(String teacher);
}
