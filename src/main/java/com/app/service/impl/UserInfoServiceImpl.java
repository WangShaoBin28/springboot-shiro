package com.app.service.impl;

import com.app.dao.UserInfoDao;
import com.app.entity.UserInfo;
import com.app.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @Package com.app.service.impl
 * @ClassName UserInfoServiceImpl
 * @Author shaobin.wang
 * @Date 2019/07/01 11:20
 * @Version 1.0
 * @Description:
 **/
@Service
@Slf4j
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int save() {

        UserInfo userInfo = new UserInfo("root", "root", "哈哈 盐");

        UserInfo save = userInfoDao.save(userInfo);

        return save.getId();
    }

    @Override
    public UserInfo getUserInfo(Integer userId) {
        Optional<UserInfo> byId = userInfoDao.findById(userId);

        if (byId.isPresent()) {
            log.info("存在");
            return byId.get();
        }
        log.info("不存在");
        return null;

    }

    @Override
    public UserInfo findByUsername(String username) {

        Optional<UserInfo> byName = userInfoDao.findByName(username);

        if (byName.isPresent()) {
            log.info("存在");
            return byName.get();
        }
        log.info("不存在");
        return null;
    }

}
