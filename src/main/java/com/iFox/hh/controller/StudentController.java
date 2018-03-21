package com.iFox.hh.controller;

import com.iFox.hh.entity.StudentInfo;
import com.iFox.hh.service.AdminService;
import com.iFox.hh.service.StudentService;
import com.iFox.hh.utils.MD5Utils;
import com.iFox.hh.utils.vo.Attendance;
import com.iFox.hh.utils.vo.Course;
import com.iFox.hh.utils.vo.HasCourse;
import com.iFox.hh.utils.vo.LeaveRecord;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    @Resource
    private StudentService studentService;

    @Resource
    private AdminService adminService;

    @RequestMapping("/login")
    public ModelAndView login(String account, String password, HttpServletRequest request) {

        System.out.println(account);
        password = MD5Utils.md5Message(password);
        StudentInfo student = studentService.getStudent(account, password);
        if (student != null) {
            ModelAndView modelAndView = new ModelAndView("student/student");
            modelAndView.addObject("student", student);
            HttpSession session = request.getSession();
            session.setAttribute("user", student.getName());
            return modelAndView;
        } else {

            ModelAndView modelAndView = new ModelAndView("../../index");
            modelAndView.getModel().put("msg", "登录失败，请确认用户名和密码");
            return modelAndView;
        }
    }
    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "../../index";
    }

    @RequestMapping("queryCourse")
    public ModelAndView queryCourse(String student) {
        List<HasCourse> hasCourseList = studentService.queryHasCourse(student);
        List<Course> courseList = adminService.queryCourse();
        for (HasCourse hasCourse:hasCourseList) {
            for (Course course:courseList) {
                if (Objects.equals(course.getId(), hasCourse.getCourseId())) {
                    course.setStatus("yixuan");
                    System.out.println(course.getStatus());
                }else {
                    course.setStatus("weixuan");
                    System.out.println(course.getStatus());
                }
            }
        }
        ModelAndView modelAndView = new ModelAndView("student/selectCourse");
        modelAndView.addObject("courseList", courseList);
        return modelAndView;
    }

    @RequestMapping("queryHasCourse")
    public ModelAndView queryHasCourse(String student) {
        List<HasCourse> hasCourseList = studentService.queryHasCourse(student);
        ModelAndView modelAndView = new ModelAndView("student/course_list");
        modelAndView.addObject("hasCourseList", hasCourseList);
        return modelAndView;
    }

    @RequestMapping("/selectCourse")
    public @ResponseBody
    String selectCourse(String id,String studentName) {
        Long courseId = Long.parseLong(id);
        if (isSelect(courseId,studentName)) {
            return "300";
        } else {
            Course course = getCourse(courseId);
            String name = getTeacherName(course.getTeacherId());
            System.out.println(name);

            HasCourse hasCourse = new HasCourse();
            hasCourse.setName(course.getName());
            hasCourse.setTake_time(course.getTake_time());
            hasCourse.setTeacher(name);
            hasCourse.setCreate_time(new Date());
            hasCourse.setCourseId(courseId);
            hasCourse.setStudentName(studentName);
            //判断数据添加是否成功
            studentService.addHasCourse(hasCourse);
            return "200";
        }
    }

    @RequestMapping("leave")
    public String addLeave(LeaveRecord leaveRecord) {
        Course course = getCourseByTI(getTeacherId(leaveRecord.getTeacher()));
        leaveRecord.setCreate_time(new Date());
        leaveRecord.setCourseName(course.getName());
        leaveRecord.setTake_time(course.getTake_time());
        studentService.addLeave(leaveRecord);
        Long id = leaveRecord.getId();
        //id来判断是否发送请假请求
        return "redirect:/student/queryHasCourse";

    }

    @RequestMapping("queryOnCourse")
    public ModelAndView attendance(String studentName){
        System.out.println(studentName);
        ModelAndView modelAndView = new ModelAndView("student/onCourse");
        List<Attendance> attendanceList = studentService.attendance(studentName);
        System.out.println(attendanceList.get(0));
        modelAndView.addObject("attendanceList", attendanceList);
        return modelAndView;
    }

    private Long getTeacherId(String teacher) {
       return studentService.getTeacherId(teacher);
    }

    private Course getCourseByTI(Long teacherId) {
        return studentService.getCourseByTI(teacherId);
    }

    private Course getCourse(Long courseId) {
        return studentService.getCourse(courseId);
    }

    private boolean isSelect(Long courseId,String studentName) {
        HasCourse hasCourse = studentService.isSelect(courseId,studentName);
        return hasCourse!=null ;
    }

    private String getTeacherName(Integer teacherId) {
         return studentService.getTeacherName(teacherId);
    }
}
