package com.codetreatise.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codetreatise.bean.AreaOfWork;
import com.codetreatise.repository.AreaOfWorkRepository;
import com.codetreatise.service.AreaOfWorkService;

@Service
public class AreaOfWorkServiceImpl implements AreaOfWorkService {
	
	@Autowired
	private AreaOfWorkRepository repository;
	
	@Override
	public AreaOfWork find(int id) {
		return repository.findOne(id);
	}

	@Override
	public List<AreaOfWork> findAll() {
		return repository.findAll();
	}

	@Override
	public AreaOfWork save(AreaOfWork entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AreaOfWork update(AreaOfWork entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(AreaOfWork entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteInBatch(List<AreaOfWork> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AreaOfWork findById(String p) {
		// TODO Auto-generated method stub
		return null;
	}
}
