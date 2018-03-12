package com.iFox.hh.dao;

import com.iFox.hh.entity.StudentInfo;
import com.iFox.hh.utils.vo.Course;
import com.iFox.hh.utils.vo.HasCourse;
import com.iFox.hh.utils.vo.LeaveRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
public interface StudentMapper {

    StudentInfo getStudent(@Param("number")String number, @Param("password") String password);

    HasCourse isSelect(@Param("id") Long id,@Param("studentName") String studentName);

    String getTeacherName(Integer id);

    Course getCourse(Long id);

    void addHasCourse(HasCourse hasCourse);

    List<HasCourse> queryHasCourse(String studentName);

    void addLeave(LeaveRecord leaveRecord);
}
