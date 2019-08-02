package cn.tedu.test.dao;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;

public class UserDaoTestCase extends TestBase{
	UserDao dao;
	@Before
	public void initDao() {
		init();
		dao = ac.getBean("userDao",UserDao.class);
	}
	
	@Test
	public void testAddUser() {
		User user = new User("600","Robin","123","","");
		dao.addUser(user);
	}
	
	@Test
	public void testFindByName() {
		User user = dao.findUserByName("Robin");
		System.out.println(user);
	}
	
	@Test
	public void testFindUserLikeName() {
		List<Map<String,Object>> list = dao.findUsersLikeName("o");
		for(Map<String,Object> map:list) {
			System.out.println(map);
			System.out.println(map.get("name"));
		}
	}
}
