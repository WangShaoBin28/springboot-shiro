package com.app.controller;

import com.app.entity.UserInfo;
import com.app.service.UserInfoService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @Package com.app.controller
 * @ClassName UserController
 * @Author shaobin.wang
 * @Date 2019/07/01 11:18
 * @Version 1.0
 * @Description:
 **/
@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;


    @RequestMapping("save")
    @ResponseBody
    public String save() {
        int save = userInfoService.save();
        System.out.println(save);
        return "ok";
    }


    @RequestMapping("getUser/{userId}")
    public String getUser(ModelMap modelMap, @PathVariable("userId") Integer userId) {
        UserInfo userInfo = userInfoService.getUserInfo(userId);
        modelMap.addAttribute("userInfo", userInfo);
        return "userInfo";
    }

    @RequestMapping("getUserByName")
    public String getUserByName(ModelMap modelMap) {
        UserInfo userInfo = userInfoService.findByUsername("root2");
        modelMap.addAttribute("userInfo", userInfo);
        return "userInfo";
    }
    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String username, String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);
        //根据权限，指定返回数据
//        String role = userMapper.getRole(username);
//        if ("user".equals(role)) {
//            return resultMap.success().message("欢迎登陆");
//        }
//        if ("admin".equals(role)) {
//            return resultMap.success().message("欢迎来到管理员页面");
//        }
        return null;
    }

}
