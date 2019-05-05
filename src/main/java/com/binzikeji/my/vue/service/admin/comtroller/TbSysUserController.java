package com.binzikeji.my.vue.service.admin.comtroller;

import com.binzikeji.my.vue.service.admin.dto.BaseRestult;
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
@RequestMapping(value = "v1/users")
public class TbSysUserController {

    @Autowired
    private TbSysUserService tbSysUserService;

    @RequestMapping(value = "get/{loginCode}")
    public BaseRestult getUser(@PathVariable(value = "loginCode") String loginCode){
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setLoginCode(loginCode);
        tbSysUser = tbSysUserService.selectOne(tbSysUser);
        return BaseRestult.ok(tbSysUser);
    }
}
