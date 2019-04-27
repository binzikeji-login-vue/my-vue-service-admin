package com.binzikeji.my.vue.service.admin.service.impl;

import com.binzikeji.my.vue.service.admin.mapper.TbSysUserMapper;
import com.binzikeji.my.vue.service.admin.entiey.TbSysUser;
import com.binzikeji.my.vue.service.admin.service.TbSysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description
 * @Author Bin
 * @Date 2019/4/27 12:21
 **/
@Service
public class TbSysUserServicesImpl implements TbSysUserService {

    @Autowired
    private TbSysUserMapper tbSysUserMapper;

    @Override
    public TbSysUser selectOne(TbSysUser tbSysUser) {
        return tbSysUserMapper.selectOne(tbSysUser);
    }
}
