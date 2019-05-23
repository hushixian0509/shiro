package com.spring.shiro.demo.filter;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.AuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @author hushixian
 * @date 2019-05-08 10:44
 */
public class RoleOrFilter extends AuthorizationFilter {
    @Override
    protected boolean isAccessAllowed(ServletRequest servletRequest, ServletResponse servletResponse, Object mappedValue) throws Exception {
        Subject subject = getSubject(servletRequest,servletResponse);
        String[] roles = (String[])mappedValue;
        if(roles == null || roles.length ==0){
            return true;
        }
        for(String role:roles){
            if(subject.hasRole(role)){
                return true;
            }
        }
        return false;
    }
}
