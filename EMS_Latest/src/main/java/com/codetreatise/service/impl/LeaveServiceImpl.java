package com.codetreatise.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetreatise.bean.Employee;
import com.codetreatise.bean.LeaveData;
import com.codetreatise.repository.EmployeeRepository;
import com.codetreatise.repository.LeaveDataRepository;
import com.codetreatise.service.EmployeeService;
import com.codetreatise.service.LeaveService;

@Service
public class LeaveServiceImpl implements LeaveService {
	
	@Autowired
	private LeaveDataRepository employeeRepository;
	
	@Override
	public LeaveData save(LeaveData entity) {
		return employeeRepository.save(entity);
	}

	@Override
	public LeaveData update(LeaveData entity) {
		return employeeRepository.save(entity);
	}

	@Override
	public void delete(LeaveData entity) {
		employeeRepository.delete(entity);
	}

	@Override
	public void delete(int id) {
		employeeRepository.delete(id);
	}

	@Override
	public LeaveData find(int id) {
		return employeeRepository.findOne(id);
	}

	@Override
	public List<LeaveData> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<LeaveData> employee) {
		employeeRepository.deleteInBatch(employee);
	}

	@Override
	public LeaveData findById(String id) {
		return employeeRepository.findByStaffId(id);
	}
	
	@Override
	public List<LeaveData> findByName(String id) {
		return employeeRepository.findByName(id);
	}
}
