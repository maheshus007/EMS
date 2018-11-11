package com.codetreatise.service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.codetreatise.bean.AllocationData;
import com.codetreatise.bean.Employee;
import com.codetreatise.generic.GenericService;


public interface EmployeeService extends GenericService<Employee> {

	Employee findById(String id);
	List<Employee> findByName(String id);
	
	List<Employee> findByAllFields(String id, String name,String uaeid,String batch, String gender, String designation, String staffgrade, String nationality, String department, String contact, String passport, String placeofbirth, String academicqualification, 
			String drivinglicense, String linemanager, String areaofwork, String _300hrs, String collegemodules, String logbook, 
			String major, String workinghrs, String NSstatus, String specifymodules, String email, String post, 
			String shift, LocalDate ojtstartdate, LocalDate ojtenddate, LocalDate doj, 
			LocalDate NS_end_date, LocalDate NSstartdate, LocalDate dob);
}
