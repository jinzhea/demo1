package com.example.demo.entity;

import org.hibernate.validator.constraints.*;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "userinfo", uniqueConstraints = @UniqueConstraint(columnNames = "username"))
public class User {

    private Integer id;
    @Size(min = 4, max = 15, message = "用户名长度为4-15位")
    private String username;
    @Size(min = 6, max = 18, message = "密码长度为6-18位")
    private String password;
    @Pattern(regexp = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", message = "邮箱格式不正确")
    private String email;
    @Pattern(regexp = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$", message = "手机号填写错误")
    private String phone;
    @NotBlank(message = "性别不能为空")
    private String sex;
    private Date creat_time;
    private Date update_time;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Date creat_time) {
        this.creat_time = creat_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public User(String username, String password, String email, String phone, String sex, Date creat_time, Date update_time) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
        this.sex = sex;
        this.creat_time = creat_time;
        this.update_time = update_time;
    }


    public User() {
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", sex='" + sex + '\'' +
                ", creat_time=" + creat_time +
                ", update_time=" + update_time +
                '}';
    }
}
