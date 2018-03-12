package com.iFox.hh.utils.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by exphuhong
 * Date 18-3-12.
 * Start
 */
public class AudioRecord implements Serializable {

    private static final long serialVersionUID = -8227117419384823752L;

    private Long id;
    private String path;
    private String teacherName;
    private String courseName;
    private Date create_time;
    private Date update_time;

    @Override
    public String toString() {
        return "AudioRecord{" +
                "id=" + id +
                ", path='" + path + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", courseName='" + courseName + '\'' +
                ", create_time=" + create_time +
                ", update_time=" + update_time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AudioRecord that = (AudioRecord) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (path != null ? !path.equals(that.path) : that.path != null) return false;
        if (teacherName != null ? !teacherName.equals(that.teacherName) : that.teacherName != null) return false;
        if (courseName != null ? !courseName.equals(that.courseName) : that.courseName != null) return false;
        if (create_time != null ? !create_time.equals(that.create_time) : that.create_time != null) return false;
        return update_time != null ? update_time.equals(that.update_time) : that.update_time == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (path != null ? path.hashCode() : 0);
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
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
}
