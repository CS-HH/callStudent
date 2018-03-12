package com.iFox.hh.dao;

import com.iFox.hh.entity.AdminInfo;
import com.iFox.hh.entity.StudentInfo;
import com.iFox.hh.entity.TeacherInfo;
import com.iFox.hh.utils.vo.AudioRecord;
import com.iFox.hh.utils.vo.Course;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
public interface AdminMapper {

    AdminInfo getAdmin(@Param("account") String account, @Param("password") String password);

    void addStudent(StudentInfo studentInfo);

    void addTeacher(TeacherInfo teacherInfo);

    void addCourse(Course course);

    List<TeacherInfo> queryTeacher();

    String queryTeacherName(Integer id);

    List<Course> queryCourse();

    List<StudentInfo> queryStudent();

    void deleteStudent(Integer id);

    void deleteCourse(Integer id);

    void deleteTeacher(Integer id);

    void updateStudent(StudentInfo studentInfo);

    void updateCourse(Course course);

    void updateTeacher(TeacherInfo teacherInfo);

    String getCourseName(Integer id);

    void addAudio(AudioRecord audioRecord);

    String getAudio(String teacher);
}
