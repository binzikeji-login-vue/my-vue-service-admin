package com.binzikeji.my.vue.service.admin.interceptor;

import com.binzikeji.my.vue.service.admin.dto.BaseRestult;
import com.binzikeji.my.vue.service.admin.entiey.TbSysUser;
import com.binzikeji.my.vue.service.admin.service.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import utils.CookieUtils;
import utils.MapperUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebAdminInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean f = false;

        String token = CookieUtils.getCookieValue(request, "token");
        if (StringUtils.isNotBlank(token)){
            String loginCode = redisService.get(token);
            if (StringUtils.isNotBlank(loginCode)){
                String json = redisService.get(loginCode);
                if (StringUtils.isNotBlank(json)){
                    f = true;
                }
            }
        }

        // 二次确认是否有用户信息
        if (!f){
            response.setContentType("text/html;charset=UTF-8");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().print(MapperUtils.obj2json(BaseRestult.ok("登录过期请从新登录")));
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}