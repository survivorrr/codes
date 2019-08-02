package cn.tedu.note.service;

import java.util.List;
import java.util.Map;

import cn.tedu.note.entity.User;

public interface UserService {
	public User login(String name,String password);
	
	List<Map<String,Object>> listUsers(String name);
}
