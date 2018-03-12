package com.iFox.hh.utils.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
public class Attendance implements Serializable {

    private static final long serialVersionUID = -8590553083387845817L;

    private Long id;
    private String studentName;
    private String teacher;
    private String courseName;
    private Date create_time;
    private Date update_time;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Attendance{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", teacher='" + teacher + '\'' +
                ", courseName='" + courseName + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attendance that = (Attendance) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (studentName != null ? !studentName.equals(that.studentName) : that.studentName != null) return false;
        if (teacher != null ? !teacher.equals(that.teacher) : that.teacher != null) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
        if (create_time != null ? !create_time.equals(that.create_time) : that.create_time != null) return false;
        return update_time != null ? update_time.equals(that.update_time) : that.update_time == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (courseName != null ? courseName.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (update_time != null ? update_time.hashCode() : 0);
        return result;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Attendance() {

    }
}
