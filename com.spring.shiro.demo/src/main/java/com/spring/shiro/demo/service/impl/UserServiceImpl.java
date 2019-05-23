package com.spring.shiro.demo.service.impl;

import com.spring.shiro.demo.entity.UserBean;
import com.spring.shiro.demo.mapper.UserMapper;
import com.spring.shiro.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author hushixian
 * @date 2019-04-29 19:38
 * UserService实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserBean findByName(String userAccount) {
        // 查询用户是否存在
        UserBean bean = userMapper.findByName(userAccount);
        if (bean != null) {
            // 查询用户信息、角色、权限
            bean = userMapper.findById(bean.getUserId());
        }
        return bean;
    }
}
