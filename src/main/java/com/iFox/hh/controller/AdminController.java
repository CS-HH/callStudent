package com.iFox.hh.controller;

import com.google.gson.Gson;
import com.iFox.hh.entity.AdminInfo;
import com.iFox.hh.entity.StudentInfo;
import com.iFox.hh.entity.TeacherInfo;
import com.iFox.hh.service.AdminService;
import com.iFox.hh.service.StudentService;
import com.iFox.hh.utils.MD5Utils;
import com.iFox.hh.utils.vo.AudioRecord;
import com.iFox.hh.utils.vo.Course;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private AdminService adminService;

    @Resource
    private StudentService studentService;

    @RequestMapping("/login")
    public ModelAndView login(String account, String password, HttpServletRequest request) {

        password = MD5Utils.md5Message(password);
        AdminInfo admin = adminService.getAdmin(account, password);
        if (admin != null) {
            ModelAndView modelAndView = new ModelAndView("admin/admin");
            modelAndView.addObject("admin", admin);
            HttpSession session = request.getSession();
            session.setAttribute("user", admin.getAccount());
            return modelAndView;
        } else {

            ModelAndView modelAndView = new ModelAndView("../../index");
            request.setAttribute("msg", "登录失败，请确认用户名和密码");
            return modelAndView;
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.removeAttribute("user");
        return "../../index";
    }



    @RequestMapping("/addStudent")
    public String addStudent(StudentInfo studentInfo, HttpServletRequest request) {
        System.out.println(studentInfo.getName());
        studentInfo.setPassword(MD5Utils.md5Message(studentInfo.getPassword()));
        studentInfo.setCreate_time(new Date());
        adminService.addStudent(studentInfo);
        Long id = studentInfo.getId();
        if (id > 0) {
            request.setAttribute("msg", "添加成功");
        } else {
            request.setAttribute("msg", "添加失败");
        }
        return "redirect:/admin/queryStudent";
    }

    @RequestMapping("/addTeacher")
    public String addTeacher(TeacherInfo teacherInfo, HttpServletRequest request) {
        teacherInfo.setPassword(MD5Utils.md5Message(teacherInfo.getPassword()));
        teacherInfo.setCreate_time(new Date());
        adminService.addTeacher(teacherInfo);
        Long id = teacherInfo.getId();
        if (id > 0) {
            request.setAttribute("msg", "添加成功");
        } else {
            request.setAttribute("msg", "添加失败");
        }
        return "redirect:/admin/queryTeachers";
    }

    @RequestMapping("/addCourse")
    public String addCourse(String name, String take_time, String teacherId, HttpServletRequest request) {
        Course course = new Course();
        course.setName(name);
        course.setTake_time(take_time);
        course.setTeacherId(Integer.parseInt(teacherId));
        course.setCreate_time(new Date());
        adminService.addCourse(course);
        Long id = course.getId();
        if (id > 0) {
            request.setAttribute("msg", "添加成功");
        } else {
            request.setAttribute("msg", "添加失败");
        }
        return "redirect:/admin/queryCourse";
    }

    @RequestMapping(value = "/queryTeacher", produces = "application/json; charset=utf-8")
    public @ResponseBody
    String queryTeacher() {
        List<TeacherInfo> list = adminService.queryTeacher();
        Gson gson = new Gson();
        return gson.toJson(list);
    }

    @RequestMapping("queryStudent")
    public ModelAndView queryStudent() {
        List<StudentInfo> studentList = adminService.queryStudent();
        ModelAndView modelAndView = new ModelAndView("info/studentInfo");
        modelAndView.addObject("studentList", studentList);
        return modelAndView;
    }

    @RequestMapping("queryTeachers")
    public ModelAndView queryTeachers() {
        List<TeacherInfo> teacherList = adminService.queryTeacher();
        ModelAndView modelAndView = new ModelAndView("info/teacherInfo");
        modelAndView.addObject("teacherList", teacherList);
        return modelAndView;
    }


    @RequestMapping("queryCourse")
    public ModelAndView queryCourse() {
        List<Course> courseList = adminService.queryCourse();
        ModelAndView modelAndView = new ModelAndView("info/courseInfo");
        modelAndView.addObject("courseList", courseList);
        return modelAndView;
    }


    @RequestMapping("deleteStudent")
    public @ResponseBody
    String deleteStudent(String id) {
        Integer studentId = Integer.parseInt(id);
        adminService.deleteStudent(studentId);
        return "200";
    }

    @RequestMapping("deleteCourse")
    public @ResponseBody
    String deleteCourse(String id) {
        Integer courseId = Integer.parseInt(id);
        adminService.deleteCourse(courseId);
        return "200";
    }

    @RequestMapping("deleteTeacher")
    public @ResponseBody
    String deleteTeacher(String id) {
        Integer teacherId = Integer.parseInt(id);
        adminService.deleteTeacher(teacherId);
        return "200";
    }


    @RequestMapping("updateStudent")
    public ModelAndView updateStudent(String id, String name, String number, String clazz) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/queryStudent");
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setId(Long.parseLong(id));
        studentInfo.setClazz(clazz);
        studentInfo.setNumber(number);
        studentInfo.setName(name);
        studentInfo.setUpdate_time(new Date());
        adminService.updateStudent(studentInfo);
        modelAndView.addObject("msg", "修改成功");
        return modelAndView;
    }

    @RequestMapping("updateCourse")
    public ModelAndView updateCourse(String id, String name, String take_time, String teacherId) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/queryCourse");
        Course course = new Course();
        course.setName(name);
        course.setId(Long.parseLong(id));
        course.setTake_time(take_time);
        course.setTeacherId(Integer.parseInt(teacherId));
        course.setUpdate_time(new Date());
        adminService.updateCourse(course);
        modelAndView.addObject("msg", "修改成功");
        return modelAndView;
    }

    @RequestMapping("updateTeacher")
    public ModelAndView updateTeacher(String id, String name) {
        ModelAndView modelAndView = new ModelAndView("redirect:/admin/queryTeachers");
        TeacherInfo teacherInfo = new TeacherInfo();
        teacherInfo.setId(Long.parseLong(id));
        teacherInfo.setName(name);
        adminService.updateTeacher(teacherInfo);
        modelAndView.addObject("msg", "修改成功");
        return modelAndView;
    }

    @RequestMapping("addAudio")
    public String addAudio(String teacher, MultipartFile file, HttpServletRequest request) {
        String path = request.getServletContext().getRealPath("/audioUpload");
        System.out.println(path);
        try {
            FileUtils.writeByteArrayToFile(new File(path+"/"+ file.getOriginalFilename()),file.getBytes());
            Integer id = Integer.parseInt(teacher);
            String teacherName = studentService.getTeacherName(id);
            String courseName = getCourseName(id);
            AudioRecord audioRecord = new AudioRecord();
            audioRecord.setPath("/audioUpload/"+file.getOriginalFilename());
            audioRecord.setCourseName(courseName);
            audioRecord.setTeacherName(teacherName);
            audioRecord.setCreate_time(new Date());

            adminService.addAudio(audioRecord);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "admin/admin";
    }

    public String getCourseName(Integer id) {
        return adminService.getCourseName(id);
    }
}
