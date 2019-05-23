package com.spring.shiro.demo.controller;

import com.spring.shiro.demo.entity.UserBean;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author hushixian
 * @date 2019-04-30 15:28
 * 用户页面跳转
 */
@Controller
public class UserController {

    /**
     * 个人中心，需认证可访问
     */
    @RequestMapping("/user/index")
    public String add(HttpServletRequest request){
        UserBean bean = (UserBean) SecurityUtils.getSubject().getPrincipal();
        request.setAttribute("userName",bean.getUserAccount());
        return "/user/index";
    }

    /**
     * 会员中心，需认证且角色为vip可访问
     */
    @RequestMapping("/vip/index")
    public String update(){
        return "/vip/index";
    }
}
