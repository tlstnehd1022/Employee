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

public class CityTransferOracle {

	static Log log = LogFactory.getLog(CityTransferOracle.class);
	
	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = null;
		ctx = new GenericXmlApplicationContext("spring/beans_mysql.xml",
											   "spring/beans_oracle.xml");

		// Oracle ==> MySQL

		
		CityMapper mysqlCityMapper = (CityMapper) ctx.getBean("mysqlCityMapper");
		CityMapper oracleCityMapper = (CityMapper) ctx.getBean("oracleCityMapper");
		
		int deleteCount = mysqlCityMapper.deleteAll();
		log.info("MySQL City Delete Count = " + deleteCount);
		
		List<City> list = oracleCityMapper.selectAll();
//		
//		pagination paging = new pagination();
//		paging.setTotalItem(4079);
//		paging.setPageNo(2);
//		List<City> list = mysqlCityMapper.selectPage(paging);
		
		log.info("City size = " + list.size());

		System.out.println();
		
		list.forEach(new Consumer<City>() {

			@Override
			public void accept(City t) {
				
				System.out.print(".");
				System.out.flush();
				
				if( t.getDistrict() == null)
					t.setDistrict("");
				
				int rtn = oracleCityMapper.insert(t);
				log.info("rtn = " + rtn);
				
			}
		});
		
		int cityCount = mysqlCityMapper.selectCount();
		log.info("MYSQL City Total Count = " + cityCount);
		
		
		
		ctx.close();

	}

}
