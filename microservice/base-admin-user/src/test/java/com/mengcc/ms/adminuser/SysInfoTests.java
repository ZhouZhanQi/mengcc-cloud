package com.mengcc.ms.adminuser;

import com.mengcc.ms.adminuser.model.domain.SysInfo;
import com.mengcc.ms.adminuser.service.ISysInfoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhouzq
 * @date 2019/8/29
 * @desc
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SysInfoTests {

    @Autowired
    private ISysInfoService sysInfoService;

    @Test
    public void testSysInfoSave(){
        SysInfo sysInfo = new SysInfo();
        sysInfoService.saveSysInfo(sysInfo);
    }
}
