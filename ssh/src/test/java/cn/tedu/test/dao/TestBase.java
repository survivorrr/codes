package cn.tedu.test.dao;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBase {

	protected ClassPathXmlApplicationContext ac;

	public TestBase() {
		super();
	}
	public void init() {
		String[] cfg = {"conf/spring-orm.xml","conf/spring-service.xml"};
		ac = new ClassPathXmlApplicationContext(cfg);
	}

}