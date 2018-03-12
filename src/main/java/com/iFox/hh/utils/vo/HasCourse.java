package com.iFox.hh.utils.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by exphuhong
 * Date 18-3-11.
 * Start
 */
public class HasCourse implements Serializable {

    private static final long serialVersionUID = -8776812149472361808L;

    private Long id;
    private String name;
    private String take_time;
    private String teacher;

    private Date create_time;

    private String studentName;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    private Long courseId;

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HasCourse hasCourse = (HasCourse) o;

        if (id != null ? !id.equals(hasCourse.id) : hasCourse.id != null) return false;
        if (name != null ? !name.equals(hasCourse.name) : hasCourse.name != null) return false;
        if (take_time != null ? !take_time.equals(hasCourse.take_time) : hasCourse.take_time != null) return false;
        return teacher != null ? teacher.equals(hasCourse.teacher) : hasCourse.teacher == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (take_time != null ? take_time.hashCode() : 0);
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HasCourse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", take_time='" + take_time + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTake_time() {
        return take_time;
    }

    public void setTake_time(String take_time) {
        this.take_time = take_time;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public HasCourse() {

    }
}
