package cn.tedu.test.dao;

import java.sql.Connection;

import javax.sql.DataSource;

import org.junit.Test;


public class TestCase extends TestBase {
	@Test
	public void testDataSource() throws Exception{
		DataSource ds = ac.getBean("dbcp",DataSource.class);
		Connection conn = ds.getConnection();
		System.out.println(conn);
		conn.close();
	}
}
