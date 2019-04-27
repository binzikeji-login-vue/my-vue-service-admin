package com.binzikeji.my.vue.service.admin;

import com.binzikeji.my.vue.service.admin.entiey.TbSysUser;
import com.binzikeji.my.vue.service.admin.service.TbSysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description
 * @Author Bin
 * @Date 2019/4/27 12:25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)
@Transactional
@Rollback
public class TbSysUserServiceTest {

    @Autowired
    private TbSysUserService tbSysUserService;

    @Test
    public void selectOneTest(){
        TbSysUser tbSysUser = new TbSysUser();
        tbSysUser.setLoginCode("binzikeji@qq.com");
        TbSysUser tbSysUser1 = tbSysUserService.selectOne(tbSysUser);
        System.out.printf("111111");

    }
}
