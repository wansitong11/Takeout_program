package com.stone.filter;

import com.alibaba.fastjson.JSON;
import com.stone.common.BaseContext;
import com.stone.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.LogRecord;

@WebFilter(filterName = "loginCheckFilter", urlPatterns = "/*")
@Slf4j
public class LoginCheckFilter implements Filter {

    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        //获取本次请求的uri
        String uri = request.getRequestURI();

        //定义不需要处理的请求路径
        String[] urls = new String[]{
                "/employee/login",
                "/employee/logout",
                "/backend/**",
                "/front/**",
                "/common/**",
                "/user/sendMsg",
                "/user/login"
        };

        //进行路径匹配
        boolean check = check(urls, uri);
        //匹配上表示该路径不需要处理
        if(check){
            log.info("请求{}不需要处理", uri);
            filterChain.doFilter(request, response);
            return;
        }
        //判断后台用户是否已经登录，已经登录则放行
        if(request.getSession().getAttribute("employee") != null){
            log.info("已登录，请求{}不需要处理", request.getSession().getAttribute("employee"));

            Long empId = (Long) request.getSession().getAttribute("employee");
            BaseContext.setCurrentId(empId);

            filterChain.doFilter(request, response);
            return;
        }

        //判断前端用户是否已经登录，已经登录则放行
        if(request.getSession().getAttribute("user") != null){
            log.info("已登录，请求{}不需要处理", request.getSession().getAttribute("user"));

            Long userId = (Long) request.getSession().getAttribute("user");
            BaseContext.setCurrentId(userId);

            filterChain.doFilter(request, response);
            return;
        }

        log.info("未登录");
        response.getWriter().write(JSON.toJSONString(Result.error("NOTLOGIN")));

    }

    boolean check(String[] urls, String uri){
        for(String url : urls){
            boolean match = PATH_MATCHER.match(url, uri);
            if(match) return true;
        }
        return false;
    }
}
