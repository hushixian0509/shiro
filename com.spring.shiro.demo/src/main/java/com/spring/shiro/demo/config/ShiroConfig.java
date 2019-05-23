package com.spring.shiro.demo.config;

import com.spring.shiro.demo.filter.RoleOrFilter;
import com.spring.shiro.demo.realm.UserRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author hushixian
 * @date 2019-04-29 19:07
 */
@Configuration
public class ShiroConfig {
    @Bean("hashedCredentialsMatcher")
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher =
                new HashedCredentialsMatcher();
        //指定加密方式为MD5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //加密次数
        credentialsMatcher.setHashIterations(1024);
        credentialsMatcher.setStoredCredentialsHexEncoded(true);
        return credentialsMatcher;
    }
    @Bean("userRealm")
    public UserRealm userRealm(@Qualifier("hashedCredentialsMatcher")
                                               HashedCredentialsMatcher matcher) {

        UserRealm userRealm = new UserRealm();
        userRealm.setCredentialsMatcher(matcher);
        return userRealm;
    }
    @Bean
    public ShiroFilterFactoryBean shirFilter(@Qualifier("securityManager")
                         DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // 设置SecurityManager
        bean.setSecurityManager(securityManager);
        // 设置登录成功跳转的url
        bean.setSuccessUrl("/main");
        // 设置登录跳转url
        bean.setLoginUrl("/toLogin");
        // 设置未授权提示的url
        bean.setUnauthorizedUrl("/erroe/unAuth");
        /**
         * anon：匿名用户可访问
         * authc：认证用户可访问
         * user：使用rememberMe可访问
         * perms：对应权限可访问
         * role：对应角色权限可访问
         **/

        Map<String, Filter> filtersMap = new LinkedHashMap<>();
        filtersMap.put("roleOrFilter",new RoleOrFilter());//可以配置RoleOrFilter的Bean
        bean.setFilters(filtersMap);

        Map<String,String> filterMap = new LinkedHashMap<>();
        filterMap.put("/login","anon");
        filterMap.put("/user/index","authc");

//        filterMap.put("/vip/index","roles[vip]");
//        filterMap.put("/vip/index","roles[管理员]");
//        filterMap.put("/vip/index","perms[管理员]");
//        filterMap.put("/vip/index","roles[矿井用户]");
        filterMap.put("/vip/index","roleOrFilter[管理员,矿井用户]");
//        filterMap.put("/vip/index","authc");
        filterMap.put("/druid/**", "anon");
        filterMap.put("/static/**","anon");

        filterMap.put("/**","authc");
        filterMap.put("/logout", "logout");

        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    /**
     * 注入 securityManager
     */
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(
            HashedCredentialsMatcher hashedCredentialsMatcher) {
        DefaultWebSecurityManager securityManager =
                new DefaultWebSecurityManager();
        // 关联realm.
        securityManager.setRealm(userRealm(hashedCredentialsMatcher));
        return securityManager;
    }

}
