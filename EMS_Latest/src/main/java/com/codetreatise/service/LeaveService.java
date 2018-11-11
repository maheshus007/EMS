package com.codetreatise.service;

import java.util.Date;
import java.util.List;

import com.codetreatise.bean.Employee;
import com.codetreatise.bean.LeaveData;
import com.codetreatise.generic.GenericService;


public interface LeaveService extends GenericService<LeaveData> {

//	boolean authenticate(String email, String password);
	
	LeaveData findById(String id);
	List<LeaveData> findByName(String id);
}
