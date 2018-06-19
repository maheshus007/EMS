package com.codetreatise.service.impl;

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
	public void delete(Long id) {
		employeeRepository.delete(id);
	}

	@Override
	public Employee find(Long id) {
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
	
}
