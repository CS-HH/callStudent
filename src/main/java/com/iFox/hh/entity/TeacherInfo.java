package com.iFox.hh.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by exphuhong
 * Date 18-3-8.
 * Start
 */
public class TeacherInfo implements Serializable {

    private static final long serialVersionUID = 3315287564188922306L;

    private Long id;
    private String name;
    private String account;
    private String password;
    private Date create_time;
    private Date update_time;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeacherInfo that = (TeacherInfo) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (create_time != null ? !create_time.equals(that.create_time) : that.create_time != null) return false;
        return update_time != null ? update_time.equals(that.update_time) : that.update_time == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (create_time != null ? create_time.hashCode() : 0);
        result = 31 * result + (update_time != null ? update_time.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeacherInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public TeacherInfo() {

    }
}
