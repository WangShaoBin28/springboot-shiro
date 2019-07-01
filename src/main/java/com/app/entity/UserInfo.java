package com.app.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @Package com.app.entity
 * @ClassName UserInfo
 * @Author shaobin.wang
 * @Date 2019/07/01 10:54
 * @Version 1.0
 * @Description:
 **/
@Data
@Entity(name = "user_info")
public class UserInfo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String password;

    private String salt;

    public UserInfo(String name, String password, String salt) {
        this.name = name;
        this.password = password;
        this.salt = salt;
    }

    public UserInfo() {
    }
}
