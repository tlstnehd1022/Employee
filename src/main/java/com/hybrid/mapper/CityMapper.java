package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.City;
import com.hybrid.util.pagination;


public interface CityMapper {
	
	int selectCount();
	List<City> selectAll();
	List<City> selectPage(pagination paging);
	List<City> selectByCountryCode(String countryCode);
	
	int insert(City city);
	int deleteAll();
}
