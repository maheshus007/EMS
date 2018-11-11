package com.codetreatise.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetreatise.bean.AssessmentData;
import com.codetreatise.repository.AssessmentDataRepository;
import com.codetreatise.repository.AssessmentDataRepository.AssessmentSpecification;
import com.codetreatise.service.AssessmentService;

@Service
public class AssessmentServiceImpl implements AssessmentService {
	
	@Autowired
	private AssessmentDataRepository assessmentRepository;
	
	@Override
	public AssessmentData save(AssessmentData entity) {
		return assessmentRepository.save(entity);
	}

	@Override
	public AssessmentData update(AssessmentData entity) {
		return assessmentRepository.save(entity);
	}

	@Override
	public void delete(AssessmentData entity) {
		assessmentRepository.delete(entity);
	}

	@Override
	public void delete(int id) {
		assessmentRepository.delete(id);
	}

	@Override
	public AssessmentData find(int id) {
		return assessmentRepository.findOne(id);
	}

	@Override
	public List<AssessmentData> findAll() {
		return assessmentRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<AssessmentData> employee) {
		assessmentRepository.deleteInBatch(employee);
	}

	@Override
	public List<AssessmentData> findByAllFields(String id, String name, String shift,
			String batch, String post, String major, String WorkingHr, String Mobile,LocalDate date, String assessmentModule,String assessor) {
		AssessmentSpecification cs = new AssessmentSpecification(id, name, shift, batch, post, major,
				WorkingHr, Mobile, date, assessmentModule, assessor);
		return assessmentRepository.findAll(cs);
	}

	@Override
	public List<AssessmentData> findByStaffId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AssessmentData> findByItem(String id, LocalDate date, String course) {
		return assessmentRepository.findByItem(id,date,course);
	}

	@Override
	public AssessmentData findById(String p) {
		// TODO Auto-generated method stub
		return null;
	}
}
