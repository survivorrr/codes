package cn.tedu.note.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.tedu.note.dao.UserDao;
import cn.tedu.note.entity.User;
@Service("userService")
public class UserServiceImpl implements UserService{
	@Resource private UserDao userDao;
	
	@Transactional
	public User login(String username,String password) {
		User user = userDao.findUserByName(username);
		if(user==null) {
			throw new RuntimeException("用户名不存在");
		}
		if(user.getPassword().equals(password)) {
			return user;
		}
		throw new RuntimeException("密码错误");
	}
	@Transactional
	public List<Map<String,Object>> listUsers(String name){
		if(name==null || name.trim().isEmpty()) {//或运算两边的表达式不能交换顺序，当name为空的时候，name.trim()就可能出现空指针异常
			throw new RuntimeException("参数不能为空");
		}
		return userDao.findUsersLikeName(name);
	}
}
