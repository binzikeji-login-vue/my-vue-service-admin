package com.binzikeji.my.vue.service.admin.comtroller;

import com.binzikeji.my.vue.service.admin.dto.BaseRestult;
import com.binzikeji.my.vue.service.admin.entiey.TbSysUser;
import com.binzikeji.my.vue.service.admin.service.LoginService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import utils.MapperUtils;

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

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public BaseRestult login(@RequestParam(value = "loginCode") String loginCode, String password){
        BaseRestult baseRestult = new BaseRestult();
        if (StringUtils.isNotBlank(loginCode) && StringUtils.isNotBlank(password)){
            TbSysUser tbSysUser = loginService.login(loginCode, password);
            return baseRestult.ok(tbSysUser);
        } else {
            return baseRestult.ok("账号或密码不能为空");
        }
    }
}
