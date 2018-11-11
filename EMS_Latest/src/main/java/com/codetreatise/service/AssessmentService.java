package com.codetreatise.service;

import java.time.LocalDate;
import java.util.List;

import com.codetreatise.bean.AssessmentData;
import com.codetreatise.generic.GenericService;


public interface AssessmentService extends GenericService<AssessmentData> {

	List<AssessmentData> findByStaffId(String id);
	List<AssessmentData> findByItem(String id,LocalDate date, String course);
	List<AssessmentData> findByAllFields(String id,String name,String shift,String batch,String post,
			String major,String WorkingHr,String Mobile, LocalDate localDate, String string, String string2);
}
