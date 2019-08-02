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
			throw new RuntimeException("�û���������");
		}
		if(user.getPassword().equals(password)) {
			return user;
		}
		throw new RuntimeException("�������");
	}
	@Transactional
	public List<Map<String,Object>> listUsers(String name){
		if(name==null || name.trim().isEmpty()) {//���������ߵı��ʽ���ܽ���˳�򣬵�nameΪ�յ�ʱ��name.trim()�Ϳ��ܳ��ֿ�ָ���쳣
			throw new RuntimeException("��������Ϊ��");
		}
		return userDao.findUsersLikeName(name);
	}
}
