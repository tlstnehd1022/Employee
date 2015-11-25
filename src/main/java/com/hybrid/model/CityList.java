package com.hybrid.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name="Response")	// xml로 변환대상이다 라는 의미   ## 필수
@XmlAccessorType(XmlAccessType.FIELD) // 필드로 읽어라
public class CityList {
	
	@XmlElementWrapper(name="citys")	//wrapping 하는거 위에 태그를 하나 더둠
	@XmlElement(name="city")			// 태그의 이름을 바꿈
	List<City> citys;

	public List<City> getCitys() {
		return citys;
	}

	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	
	
}
