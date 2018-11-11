package com.codetreatise.service;

import java.util.List;

import com.codetreatise.bean.AllocationData;
import com.codetreatise.generic.GenericService;
import com.codetreatise.repository.AllocationDataRepository.AllocationSpecification;


public interface AllocationService extends GenericService<AllocationData> {

	
	List<AllocationData> findByStaffId(String id);
	List<AllocationData> findByMonthYear(String month, String year);
	List<AllocationData> findByAllFields(String id,String name,String month,String year,String shift,String batch,String post,
			String major,String WorkingHr,String Mobile);
	List<AllocationData> findbyDate(String columName, String selectedItem,String month,int year);
	int updateByDate(String day, String activity, String formattedMonth, String formattedMonth2, int year);
}
