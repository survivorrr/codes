package cn.tedu.note.dao;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import cn.tedu.note.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	@Resource private HibernateTemplate hibernateTemplate;    //这个在spring-orm.xml文件中配置好了，就是说把这个类交给了spring容器
															//来管理,然后在这里用@Resource来注入
	public void addUser(User user) {
		hibernateTemplate.save(user);
	}

	public void deleteUser(User user) {
		hibernateTemplate.delete(user);
	}

	public void updateUser(User user) {
		hibernateTemplate.update(user);
	}

	public User findUserById(String id) {
		return hibernateTemplate.get(User.class, id);
	}

	public User findUserByName(String name) {
		//HQL
		//select * from cn_user where cn_user_name=?
		//         from User where name = ?
		String hql = "from User where name = ?";
		List<User> list = hibernateTemplate.find(hql,name);
		if(list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
	public List<Map<String,Object>> findUsersLikeName(String name){
		name="%"+name+"%";
		/*select new map(id,name) from User where name like= ?   
		map(id,name)代表有两种值，一种是id，一种是name,而不是表示id是键，name是值
		{"id":"48595f52-b22c-4485-9244-f4004255b972"}
		{"name":"demo"}
		id as id,name as name  后面的id和name分别代表id值和name值的键的别名
*/		
		//执行带参数的HQL查询  参数名：name;并把执行结果封装成map对象
		String hql="select new map(id as id,name as name) from User where name like:name";
		List<Map<String,Object>> list = hibernateTemplate.findByNamedParam(hql, "name", name);
		return list;
	}
	
}
