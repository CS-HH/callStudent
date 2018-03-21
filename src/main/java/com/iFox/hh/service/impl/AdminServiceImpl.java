package com.iFox.hh.service.impl;

import com.iFox.hh.dao.AdminMapper;
import com.iFox.hh.entity.AdminInfo;
import com.iFox.hh.entity.StudentInfo;
import com.iFox.hh.entity.TeacherInfo;
import com.iFox.hh.service.AdminService;
import com.iFox.hh.utils.vo.AudioRecord;
import com.iFox.hh.utils.vo.Course;
import com.iFox.hh.utils.vo.HasCourse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;

    public AdminInfo getAdmin(String account, String password) {
        return adminMapper.getAdmin(account, password);
    }

    @Transactional
    @Override
    public void addStudent(StudentInfo studentInfo) {
         adminMapper.addStudent(studentInfo);
    }

    @Transactional
    @Override
    public void addTeacher(TeacherInfo teacherInfo) {
         adminMapper.addTeacher(teacherInfo);
    }

    @Transactional
    @Override
    public void addCourse(Course course) {
        adminMapper.addCourse(course);
    }


    //查询
    @Override
    public List<TeacherInfo> queryTeacher() {
        return adminMapper.queryTeacher();
    }

    @Override
    public List<StudentInfo> queryStudent() {
        return adminMapper.queryStudent();
    }

    @Override
    public List<Course> queryCourse() {
       return adminMapper.queryCourse();
    }

    //删除
    @Transactional
    @Override
    public void deleteStudent(Integer studentId) {
        adminMapper.deleteStudent(studentId);
    }

    @Override
    public String getCourseName(Integer id) {
        return adminMapper.getCourseName(id);
    }

    @Override
    public void addAudio(AudioRecord audioRecord) {
        adminMapper.addAudio(audioRecord);
    }

    @Override
    public String getAudio(String teacher) {
        return adminMapper.getAudio(teacher);
    }

    @Override
    public List<HasCourse> queryHasCourse(String teacher) {
        return adminMapper.getTAndS(teacher);
    }

    @Transactional
    @Override
    public void deleteCourse(Integer courseId) {
        adminMapper.deleteCourse(courseId);
    }

    @Transactional
    @Override
    public void deleteTeacher(Integer teacherId) {
        adminMapper.deleteTeacher(teacherId);
    }

    //修改

    @Transactional
    @Override
    public void updateStudent(StudentInfo studentInfo) {
        adminMapper.updateStudent(studentInfo);
    }

    @Transactional
    @Override
    public void updateTeacher(TeacherInfo teacherInfo) {
        adminMapper.updateTeacher(teacherInfo);
    }

    @Transactional
    @Override
    public void updateCourse(Course course) {
        adminMapper.updateCourse(course);
    }
}
