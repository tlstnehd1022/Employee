package com.hybrid.mapper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.model.Member;

public class MemberMapperSpringTest {

	static Log log = LogFactory.getLog(MemberMapperSpringTest.class);
	
	public static void main(String[] args) throws SQLException {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml");
		
		MemberMapper membermapper = (MemberMapper) ctx.getBean(MemberMapper.class);
		
		List<Member> list = membermapper.selectAll();
		
		list.forEach(new Consumer<Member>() {

			@Override
			public void accept(Member m) {
				log.info("id = " + m.getId());
				
			}
			
		});
		
		//	test1();
	//  	test2();
	//	test3();
		
	}
		
		
	static void test3() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml");
		
		SqlSession sqlsession = (SqlSession) ctx.getBean(SqlSessionTemplate
				.class);
		
		List<Member> list = sqlsession.selectList("com.hybrid.mapper.MemberMapper.selectAll");
		
		list.forEach(new Consumer<Member>() {

			@Override
			public void accept(Member m) {
				log.info("id = " + m.getId());
				
			}
			
		});
		
	
		
	}

		
	static void test2(){
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml");
		
		SqlSessionFactory sqlSessionFactory = ctx.getBean(SqlSessionFactory.class);
		SqlSession sqlsession = sqlSessionFactory.openSession();
		
		List<Member> list = sqlsession.selectList("com.hybrid.mapper.MemberMapper.selectAll");
		
		list.forEach(new Consumer<Member>() {

			@Override
			public void accept(Member m) {
				log.info("id = " + m.getId());
				
			}
		});
		
	
	}	
	
	
	static void test1() throws SQLException {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("spring/beans_dao.xml");
		
		BasicDataSource dataSource = (BasicDataSource) ctx.getBean("dataSource");
		// findviewbyid 처럼 bean을 읽는거
		// BasicDataSource dataSource = ctx.getBean(BasicDataSource.class);
		// 위에거랑 같은건데 타입으로 가져오는 방식, 타입케스팅은 안하지만 2개이상의 빈이 있을때 에러가 난다.
		
		log.info("className = " + dataSource.getDriverClassName());
		log.info("url = " + dataSource.getUrl());
		log.info("username = " + dataSource.getUsername());
		log.info("password = " + dataSource.getPassword());
		
		Connection con = dataSource.getConnection();
		String productName = con.getMetaData().getDatabaseProductName();
		String databaseVersion = con.getMetaData().getDatabaseProductVersion();
		
		log.info("productName = " + productName);
		log.info("dbversion = " + databaseVersion);
		
		BasicDataSource dataSource2 = (BasicDataSource) ctx.getBean("oracleDataSource");
		
		log.info("===========================oracle========================");
		log.info("className = " + dataSource2.getDriverClassName());
		log.info("url = " + dataSource2.getUrl());
		log.info("username = " + dataSource2.getUsername());
		log.info("password = " + dataSource2.getPassword());
		
		Connection con2 = dataSource2.getConnection();
		String productName2 = con2.getMetaData().getDatabaseProductName();
		String databaseVersion2 = con2.getMetaData().getDatabaseProductVersion();
		
		log.info("productName = " + productName2);
		log.info("dbversion = " + databaseVersion2);
		

	}

}
