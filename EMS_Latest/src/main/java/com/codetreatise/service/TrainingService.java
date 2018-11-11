package com.codetreatise.service;

import java.time.LocalDate;
import java.util.List;

import com.codetreatise.bean.AllocationData;
import com.codetreatise.bean.TrainingData;
import com.codetreatise.generic.GenericService;


public interface TrainingService extends GenericService<TrainingData> {

	List<TrainingData> findByStaffId(String id);
	List<TrainingData> findByItem(String id,LocalDate date, String course);
	List<TrainingData> findByAllFields(String id,String name,String shift,String batch,String post,
			String major,String WorkingHr,String Mobile, LocalDate localDate, String string);
}
