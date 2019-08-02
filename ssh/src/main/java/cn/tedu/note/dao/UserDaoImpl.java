package cn.tedu.note.dao;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;
import cn.tedu.note.entity.User;

@Repository("userDao")
public class UserDaoImpl implements UserDao{
	@Resource private HibernateTemplate hibernateTemplate;    //�����spring-orm.xml�ļ������ú��ˣ�����˵������ཻ����spring����
															//������,Ȼ����������@Resource��ע��
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
		map(id,name)����������ֵ��һ����id��һ����name,�����Ǳ�ʾid�Ǽ���name��ֵ
		{"id":"48595f52-b22c-4485-9244-f4004255b972"}
		{"name":"demo"}
		id as id,name as name  �����id��name�ֱ����idֵ��nameֵ�ļ��ı���
*/		
		//ִ�д�������HQL��ѯ  ��������name;����ִ�н����װ��map����
		String hql="select new map(id as id,name as name) from User where name like:name";
		List<Map<String,Object>> list = hibernateTemplate.findByNamedParam(hql, "name", name);
		return list;
	}
	
}
