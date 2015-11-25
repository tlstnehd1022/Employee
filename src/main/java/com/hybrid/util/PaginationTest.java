package com.hybrid.util;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.hybrid.mapper.CityMapper;
import com.hybrid.model.City;

public class PaginationTest {

   public static void main(String[] args) {
	   GenericXmlApplicationContext ctx = null;
	   ctx = new GenericXmlApplicationContext("spring/beans_mysql.xml");

	   
	   CityMapper cityMapper = ctx.getBean(CityMapper.class);
	   int totalItem = cityMapper.selectCount();
	   System.out.println("totalItem = " + totalItem);
	   
      pagination paging = new pagination();
      
      Scanner scan = new Scanner(System.in);
      while(true){
      System.out.println("PageNo = ");
      int PageNo = scan.nextInt();
      
      paging.setPageNo(PageNo);
      paging.setTotalItem(totalItem);
      
      List<City> list = cityMapper.selectPage(paging);
      
      
      for(int i = paging.getFirstItem(); i<=paging.getLastItem(); i++){
    	  System.out.println("item index = " + list.get(i).getId()); 
      }
         
      
      if(!paging.isFristGroup())
         System.out.print("[이전]");
      else System.out.println("   ");
      
      for(int i=paging.getFirstPage(); i<=paging.getLastPage(); i++) {
         System.out.printf("[%03d]",i);
      }
      
      if(!paging.isLastGroup())
         System.out.println("[다음] ");
      else System.out.println("    ");
      
      System.out.println();
   }
}
   
   static void test1() {
      
      pagination paging = new pagination();
      
      for(int i =-2; i<20; i++){
         paging.setPageNo(i);
         paging.setTotalItem(175);
      
      String line =" totalPage = " + paging.getTotalPage() 
               +", firstGroup = " + paging.isFristGroup()
               +", firstItem = " + paging.getFirstItem()
               +", lastItem = "+ paging.getLastItem()
               +", pageNo = "+ paging.getPageNo()
               +", firstPage = " + paging.getFirstPage()
               +", lastPage = " + paging.getLastPage()
               +", lastGroup = " + paging.isLastGroup();
      System.out.println(line);
      }
   }

}