package com.zkjl.wf_clserver;

import com.zkjl.wf_clserver.core.entity.Admins;
import com.zkjl.wf_clserver.core.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = WfClserverApplication.class)
public class WfClserverApplicationTests {

	@Autowired
	private AdminService adminService;

	@Test
	public void contextLoads() {
		List<Admins> admins = adminService.find();
		System.out.println(admins);
	}

}
