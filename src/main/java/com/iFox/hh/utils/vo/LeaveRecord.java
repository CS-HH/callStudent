package com.iFox.hh.utils.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
public class LeaveRecord implements Serializable {

    private static final long serialVersionUID = 4990198217508023008L;

    private Long id;
    private String take_time;
    private String reason;
    private String  teacher;
    private String studentName;
    private String isAgree;
    private String courseName;

    public String getTake_time() {
        return take_time;
    }

    public void setTake_time(String take_time) {
        this.take_time = take_time;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    private Date create_time;
    private Date update_time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LeaveRecord that = (LeaveRecord) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (take_time != null ? !take_time.equals(that.take_time) : that.take_time != null) return false;
        if (reason != null ? !reason.equals(that.reason) : that.reason != null) return false;
        if (teacher != null ? !teacher.equals(that.teacher) : that.teacher != null) return false;
        if (studentName != null ? !studentName.equals(that.studentName) : that.studentName != null) return false;
        if (isAgree != null ? !isAgree.equals(that.isAgree) : that.isAgree != null) return false;
        if (create_time != null ? !create_time.equals(that.create_time) : that.create_time != null) return false;
        return update_time != null ? update_time.equals(that.update_time) : that.update_time == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (take_time != null ? take_time.hashCode() : 0);
        result = 31 * result + (reason != null ? reason.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        result = 31 * result + (studentName != null ? studentName.hashCode() : 0);
        result = 31 * result + (isAgree != null ? isAgree.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (update_time != null ? update_time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LeaveRecord{" +
                "id=" + id +
                ", take_time='" + take_time + '\'' +
                ", reason='" + reason + '\'' +
                ", teacher='" + teacher + '\'' +
                ", studentName='" + studentName + '\'' +
                ", isAgree='" + isAgree + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getIsAgree() {
        return isAgree;
    }

    public void setIsAgree(String isAgree) {
        this.isAgree = isAgree;
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

    public LeaveRecord() {

    }

}
