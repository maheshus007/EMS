package com.codetreatise.service.impl;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetreatise.bean.AllocationData;
import com.codetreatise.bean.Employee;
import com.codetreatise.repository.EmployeeRepository;
import com.codetreatise.repository.EmployeeRepository.EmployeeSpecification;
import com.codetreatise.repository.AllocationDataRepository.AllocationSpecification;
import com.codetreatise.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee entity) {
		return employeeRepository.save(entity);
	}

	@Override
	public Employee update(Employee entity) {
		return employeeRepository.save(entity);
	}

	@Override
	public void delete(Employee entity) {
		employeeRepository.delete(entity);
	}

	@Override
	public void delete(int id) {
		employeeRepository.delete(id);
	}

	@Override
	public Employee find(int id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<Employee> employee) {
		employeeRepository.deleteInBatch(employee);
	}

	@Override
	public Employee findById(String id) {
		return employeeRepository.findByStaffId(id);
	}

	@Override
	public List<Employee> findByName(String id) {
		return employeeRepository.findByName(id);
	}

	@Override
	public List<Employee> findByAllFields(String id, String name,String uaeid,String batch, String gender, String designation, String staffgrade, String nationality, String department, String contact, String passport, String placeofbirth, String academicqualification, 
			String drivinglicense, String linemanager, String areaofwork, String _300hrs, String collegemodules, String logbook, 
			String major, String workinghrs, String NSstatus, String specifymodules, String email, String post, 
			String shift, LocalDate ojtstartdate, LocalDate ojtenddate, LocalDate doj, 
			LocalDate NS_end_date, LocalDate NSstartdate, LocalDate dob)
	{
		EmployeeSpecification cs = new EmployeeSpecification(id, name,uaeid,batch, gender, designation, staffgrade, nationality, department, contact, passport, placeofbirth, academicqualification, 
				drivinglicense, linemanager, areaofwork, _300hrs, collegemodules, logbook,major, workinghrs, NSstatus, specifymodules, email, post, shift, 
				ojtstartdate, ojtenddate, doj,NS_end_date, NSstartdate,dob);
		return employeeRepository.findAll(cs);
	}
}
