package cn.tedu.test.service;


import org.junit.Before;
import org.junit.Test;

import cn.tedu.note.entity.User;
import cn.tedu.note.service.UserService;
import cn.tedu.test.dao.TestBase;

public class TestUserService extends TestBase{
	UserService userService;
	@Before
	public void initCase() {
		init();
		userService = ac.getBean("userService",UserService.class);
	}
	
	@Test
	public void TestService() {
		User user = userService.login("Robin", "123");
		System.out.println(user);
	}
}
