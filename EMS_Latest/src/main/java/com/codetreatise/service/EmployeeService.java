package com.codetreatise.service;

import java.util.Date;
import java.util.List;

import com.codetreatise.bean.Employee;
import com.codetreatise.generic.GenericService;


public interface EmployeeService extends GenericService<Employee> {

//	boolean authenticate(String email, String password);
	
	Employee findById(String id);
	List<Employee> findByName(String id);
	List<Employee> findByAreaOfWork(String id);
	List<Employee> findByUAEID(String id);
	List<Employee> findByLineManager(String id);
	List<Employee> findByEmail(String id);
	List<Employee> findByBatch(String id);
	List<Employee> findByContact(String id);
	List<Employee> findByDesignation(String id);
	List<Employee> findByPassport(String id);
	List<Employee> findByLicense(String id);
	List<Employee> findByDepartment(String id);
	List<Employee> findByDoj(String id);
	List<Employee> findByOjtStart(Date text);
	List<Employee> findByOjtEnd(String id);
	List<Employee> findByNsStatus(String id);
	List<Employee> findByNsStart(String id);
	List<Employee> findByNsEnd(String id);
}
