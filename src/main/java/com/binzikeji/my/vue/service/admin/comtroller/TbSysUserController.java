package com.binzikeji.my.vue.service.admin.comtroller;

import com.binzikeji.my.vue.service.admin.ServiceAdminApplication;
import com.binzikeji.my.vue.service.admin.entiey.TbSysUser;
import com.binzikeji.my.vue.service.admin.service.TbSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author Bin
 * @Date 2019/4/27 12:59
 **/
@RestController
public class TbSysUserController {

    @Autowired
    private TbSysUserService tbSysUserService;

    public String getUser(@PathVariable(value = "loginCode") String loginCode){
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setLoginCode(loginCode);
        return tbSysUserService.selectOne(tbSysUser).toString();
    }
}
