package com.binzikeji.my.vue.service.admin.comtroller;

import com.binzikeji.my.vue.service.admin.dto.BaseRestult;
import com.binzikeji.my.vue.service.admin.entiey.TbSysUser;
import com.binzikeji.my.vue.service.admin.service.LoginService;
import com.binzikeji.my.vue.service.admin.service.RedisService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import utils.CookieUtils;
import utils.MapperUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @Description
 * @Author Bin
 * @Date 2019/4/27 15:01
 **/
@RestController
@RequestMapping(value = "v1/users")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisService redisService;

    /**
     * 登录请求
     * @param loginCode
     * @param password
     * @param url
     * @param request
     * @param response
     * @param redirectAttributes
     * @return
     */
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public BaseRestult login(@RequestBody Map<String, String> map, HttpServletRequest request, HttpServletResponse response){
        BaseRestult baseRestult = new BaseRestult();
        if (map.size() == 2){
            String loginCode = map.get("loginCode");
            String password = map.get("password");
            TbSysUser tbSysUser = loginService.login(loginCode, password);

            // 登录失败
            if (tbSysUser == null){
                return baseRestult.ok("用户名或密码错误");
            }

            // 登录成功
            else {
                String token = UUID.randomUUID().toString();
                String result = redisService.put(token, loginCode, 60 * 60 * 24);
                // 将 Token 放入缓存
                if (StringUtils.isNotBlank(result) && "ok".equals(result)){
                    CookieUtils.setCookie(request, response, "token", token, 60 * 60 * 24);
                    return baseRestult.ok(tbSysUser);
                }

                // 熔断处理
                else {
                    List<BaseRestult.Error> errors = new ArrayList<>();
                    errors.add(new BaseRestult.Error("500", "服务器异常,请稍后重试"));
                    return baseRestult.notOk(errors);
                }
            }
        } else {
            return baseRestult.ok("账号或密码不能为空");
        }
    }
}
