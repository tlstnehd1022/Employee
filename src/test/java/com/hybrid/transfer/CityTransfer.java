package com.hybrid.transfer;

import java.util.List;
import java.util.function.Consumer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;
import com.hybrid.util.pagination;

public class CityTransfer {

	static Log log = LogFactory.getLog(CityTransfer.class);
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = null;
		ctx = new GenericXmlApplicationContext("spring/beans_mysql.xml",
											   "spring/beans_oracle.xml");

		//리스트 추가햇을때 경로가 달라졌을때.
//		SqlSessionTemplate sqlSession = (SqlSessionTemplate) ctx.getBean("mysqlSqlSession");
//		List<City> list = sqlSession.selectList("com.hybrid.mapper.CityMapper.selectAll");
		
		CityMapper mysqlCityMapper = (CityMapper) ctx.getBean("mysqlCityMapper");
		CityMapper oracleCityMapper = (CityMapper) ctx.getBean("oracleCityMapper");
		
		oracleCityMapper.deleteAll();
		
//		List<City> list = mysqlCityMapper.selectAll();
		
		pagination paging = new pagination();
		paging.setTotalItem(4079);
		paging.setPageNo(2);
		List<City> list = mysqlCityMapper.selectPage(paging);
		
		log.info("City size = " + list.size());

		System.out.println();
		
		list.forEach(new Consumer<City>() {

			@Override
			public void accept(City t) {
				
				System.out.print(".");
				System.out.flush();
				oracleCityMapper.insert(t);
				
			}
		});
		
		
		
		
		
		ctx.close();

	}

}
