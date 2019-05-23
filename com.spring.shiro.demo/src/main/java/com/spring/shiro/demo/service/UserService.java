package com.spring.shiro.demo.service;

import com.spring.shiro.demo.entity.UserBean;

/**
 * @author hushixian
 * @date 2019-04-29 19:38
 * UserService抽象接口
 */
public interface UserService {

    UserBean findByName(String userAccount);
}
