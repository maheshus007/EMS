package com.codetreatise.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetreatise.bean.Employee;
import com.codetreatise.repository.EmployeeRepository;
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
	public List<Employee> findByAreaOfWork(String id) {
		return employeeRepository.findByAreaOfWork(id);
	}

	@Override
	public List<Employee> findByUAEID(String id) {
		return employeeRepository.findByUAEID(id);
	}

	@Override
	public List<Employee> findByLineManager(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByLineManager(id);
	}

	@Override
	public List<Employee> findByEmail(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByEmail(id);
	}

	@Override
	public List<Employee> findByBatch(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByBatch(id);
	}

	@Override
	public List<Employee> findByContact(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByContact(id);
	}

	@Override
	public List<Employee> findByDesignation(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByDesignation(id);
	}

	@Override
	public List<Employee> findByPassport(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByPassport(id);
	}

	@Override
	public List<Employee> findByLicense(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByLicense(id);
	}

	@Override
	public List<Employee> findByDepartment(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByDepartment(id);
	}

	@Override
	public List<Employee> findByDoj(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByDoj(id);
	}

	@Override
	public List<Employee> findByOjtStart(Date id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByOjtStart(id);
	}

	@Override
	public List<Employee> findByOjtEnd(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByOjtEnd(id);
	}

	@Override
	public List<Employee> findByNsStatus(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByNsStatus(id);
	}

	@Override
	public List<Employee> findByNsStart(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByNsStart(id);
	}

	@Override
	public List<Employee> findByNsEnd(String id) {
		// TODO Auto-generated method stub
		return employeeRepository.findByNsEnd(id);
	}
}
