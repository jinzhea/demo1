package com.example.demo.entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 用户信息表
 * @author jinzhe
 * @email:jinzhe_java@163.com
 */
@Entity
@Table(name = "user")
public class User {


    private Integer id;//用户id
    @NotNull
    @Size(min = 3,max = 10,message = "名字长度为4-10位")
    private String username;//登录用户名
    @NotNull
    @Size(min = 3,max = 10,message = "密码长度为9-18位")
    private String password;//登录密码
    @NotNull
    @Size(min = 3,max = 10,message = "昵称长度为3-10位")
    private String nickname;//昵称
    @NotNull
    @Size(min = 2,max = 4,message = "姓名长度为2-4位")
    private String name;//姓名
    @NotNull
    private String sex;//性别
    @NotNull
    private String birthday;//出生年月
    @NotNull
    @Size(min = 11,max = 11,message = "手机号为11位")
    private String phone;//手机号
    @NotNull
    private String email;//电子邮件

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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
