package com.iFox.hh.controller;

import com.iFox.hh.entity.TeacherInfo;
import com.iFox.hh.service.AdminService;
import com.iFox.hh.service.TeacherService;
import com.iFox.hh.utils.MD5Utils;
import com.iFox.hh.utils.vo.Attendance;
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

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
@Controller
@RequestMapping("/teacher")
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @Resource
    private AdminService adminService;

    @RequestMapping("/login")
    public ModelAndView login(String account, String password, HttpServletRequest request) {

        password = MD5Utils.md5Message(password);

        TeacherInfo teacher = teacherService.getTeacher(account, password);
        if (teacher != null) {
            ModelAndView modelAndView = new ModelAndView("teacher/teacher");
            modelAndView.addObject("teacher", teacher);
            HttpSession session = request.getSession();
            session.setAttribute("user", teacher.getName());
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

    @RequestMapping("callName")
    public ModelAndView callName(String teacher) {
        List<HasCourse> hasCourseList = teacherService.callName(teacher);
        String path = getAudio(teacher);
        ModelAndView modelAndView = new ModelAndView("teacher/callName");
        modelAndView.addObject("hasCourseList", hasCourseList);
        modelAndView.addObject("path", path);
        return modelAndView;
    }

    private String getAudio(String teacher){
        return adminService.getAudio(teacher);
    }

    @RequestMapping("operate")
    public @ResponseBody
    String operate(String status, String teacher, String courseName, String studentName) {
        switch (status) {
            case "1":
                status = "正常";
                break;
            case "2":
                status = "请假";
                break;
            default:
                status = "缺勤";
                break;
        }

        if (isRecord(studentName, courseName)) {
            teacherService.updateAttendance(studentName, courseName, status);
        } else {
            Attendance attendance = new Attendance();
            attendance.setStudentName(studentName);
            attendance.setCreate_time(new Date());
            attendance.setTeacher(teacher);
            attendance.setCourseName(courseName);
            attendance.setStatus(status);
            teacherService.operate(attendance);
        }

        return "200";
    }

    public boolean isRecord(String studentName,String courseName){
        Attendance attendance = teacherService.isRecord(studentName, courseName);
        return attendance != null;
    }


    @RequestMapping("agreeOrNo")
    public ModelAndView getLeaveRecord(String teacher) {
        ModelAndView modelAndView = new ModelAndView("teacher/agreeOff");
        List<LeaveRecord> leaveList = teacherService.getLeaveRecord(teacher);
        modelAndView.addObject("leaveList", leaveList);
        return modelAndView;
    }

    @RequestMapping("updateLeaveRecord")
    public @ResponseBody
    String updateLeaveRecord(String id,String status) {
        status = status.equals("1") ? "同意" : "不同意";
        teacherService.updateLeaveRecord(Long.parseLong(id),status);
        return "200";
    }
}
