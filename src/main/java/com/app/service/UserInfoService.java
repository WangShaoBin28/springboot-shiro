package com.app.service;

import com.app.entity.UserInfo;

/**
 * @Package com.app.service
 * @ClassName UserInfoService
 * @Author shaobin.wang
 * @Date 2019/07/01 11:20
 * @Version 1.0
 * @Description:
 **/
public interface UserInfoService {

    int save();

    UserInfo getUserInfo(Integer userId);

    UserInfo findByUsername(String username);
}
