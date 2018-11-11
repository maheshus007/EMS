package com.codetreatise.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.codetreatise.bean.TrainingData;
import com.codetreatise.repository.TrainingDataRepository;
import com.codetreatise.repository.TrainingDataRepository.TrainingSpecification;
import com.codetreatise.service.TrainingService;

@Service
public class TrainingServiceImpl implements TrainingService {
	
	@Autowired
	private TrainingDataRepository trainingRepository;
	
	@Override
	public TrainingData save(TrainingData entity) {
		return trainingRepository.save(entity);
	}

	@Override
	public TrainingData update(TrainingData entity) {
		return trainingRepository.save(entity);
	}

	@Override
	public void delete(TrainingData entity) {
		trainingRepository.delete(entity);
	}

	@Override
	public void delete(int id) {
		trainingRepository.delete(id);
	}

	@Override
	public TrainingData find(int id) {
		return trainingRepository.findOne(id);
	}

	@Override
	public List<TrainingData> findAll() {
		return trainingRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<TrainingData> employee) {
		trainingRepository.deleteInBatch(employee);
	}

	@Override
	public List<TrainingData> findByAllFields(String id, String name, String shift,
			String batch, String post, String major, String WorkingHr, String Mobile,LocalDate date, String course) {
		TrainingSpecification cs = new TrainingSpecification(id, name, shift, batch, post, major,
				WorkingHr, Mobile, date, course);
		return trainingRepository.findAll(cs);
	}

	@Override
	public List<TrainingData> findByStaffId(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<TrainingData> findByItem(String id, LocalDate date, String course) {
		return trainingRepository.findByItem(id,date,course);
	}

	@Override
	public TrainingData findById(String p) {
		// TODO Auto-generated method stub
		return null;
	}
}
