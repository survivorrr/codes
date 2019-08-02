package cn.tedu.note.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.tedu.note.entity.User;
import cn.tedu.note.service.UserService;

@Controller
@Scope("prototype")
public class UserAction extends JsonAction{
	@Resource private UserService userService;
	
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	//这两个方法其实都要写try...catch的，但是可以把try...catch用拦截器来实现
	public String login() {
		User user = userService.login(username, password);
		//登录成功
		setResult(user);
		return JSON;
	}
	
	public String list() {
		List<Map<String,Object>> list = userService.listUsers(username);
		setResult(list);
		return JSON;
	}
	
}
