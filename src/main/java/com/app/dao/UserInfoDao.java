package com.app.dao;

import com.app.entity.UserInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Package com.app.dao
 * @ClassName UserInfoDao
 * @Author shaobin.wang
 * @Date 2019/07/01 11:01
 * @Version 1.0
 * @Description:
 **/
@Repository
public interface UserInfoDao extends CrudRepository<UserInfo,Integer> {

    Optional<UserInfo>  findByName(String username);

}
