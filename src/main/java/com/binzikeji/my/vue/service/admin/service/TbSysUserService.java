package com.binzikeji.my.vue.service.admin.service;

import com.binzikeji.my.vue.service.admin.entiey.TbSysUser;
import org.springframework.stereotype.Component;

/**
 * @Description
 * @Author Bin
 * @Date 2019/4/27 12:19
 **/
public interface TbSysUserService {

    TbSysUser selectOne(TbSysUser tbSysUser);
}
