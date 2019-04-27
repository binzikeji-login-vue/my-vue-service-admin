package com.binzikeji.my.vue.service.admin.service;

import com.binzikeji.my.vue.service.admin.entiey.TbSysUser;

public interface LoginService {

    /**
     * 登录
     * @param loginCode 账号
     * @param password 密码
     * @return
     */
    TbSysUser login(String loginCode, String password);
}
