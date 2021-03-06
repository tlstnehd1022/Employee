package com.hybrid.mapper;

import java.util.List;

import com.hybrid.model.Emp;


public interface EmpMapper {
	
	List<Emp> selectAll();
	List<Emp> selectAllWithDept();
	
	List<Emp> selectByDeptno(int deptno);
	
	Emp selectByEmpno(int empno);
	Emp selectByEmpnoWithDept(int empno);
	
	int insert(Emp emp);
	
	int delete(Emp emp);
}
