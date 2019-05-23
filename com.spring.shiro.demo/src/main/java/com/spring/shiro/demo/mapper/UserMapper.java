package com.spring.shiro.demo.mapper;

import com.spring.shiro.demo.entity.UserBean;
import org.apache.ibatis.annotations.Param;

/**
 * @author hushixian
 * @date 2019-04-29 18:47
 */
public interface UserMapper {
    // 查询用户信息 userAccount 用户账户
    UserBean findByName(@Param("userAccount") String userAccount);

    // 查询用户信息、角色、权限
    UserBean findById(@Param("userId") String userId);
}
