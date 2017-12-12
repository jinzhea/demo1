package com.example.demo.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 收货地址表
 * @author jinzhe
 * @email  jinzhe_jiava@163.com
 */


@Entity
@Table(name = "address")
public class Address {

    private Integer id;//地址id
    @NotNull
    private String tonsignee;//收货人
    @NotNull
    @Size(min = 11,max = 11)
    private String telephone;//收货人电话
    @NotNull
    private String province;//省份
    @NotNull
    private String city;//市
    @NotNull
    private String dist;//区
    @NotNull
    private String address;//详细地址
    private Integer state;//地址状态,1为默认地址，0为普通地址


    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTonsignee() {
        return tonsignee;
    }

    public void setTonsignee(String tonsignee) {
        this.tonsignee = tonsignee;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDist() {
        return dist;
    }

    public void setDist(String dist) {
        this.dist = dist;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", tonsignee='" + tonsignee + '\'' +
                ", telephone='" + telephone + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", dist='" + dist + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                '}';
    }
}
