package com.codetreatise.service.impl;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.codetreatise.bean.AllocationData;
import com.codetreatise.repository.AllocationDataRepository;
import com.codetreatise.repository.AllocationDataRepository.AllocationSpecification;
import com.codetreatise.repository.AllocationDataRepository.AllocationSpecification2;
import com.codetreatise.service.AllocationService;

@Service
public class AllocationServiceImpl implements AllocationService {

	@PersistenceContext
	EntityManager em = null;

	@Autowired
	private AllocationDataRepository allocationRepository;

	@Override
	public AllocationData save(AllocationData entity) {
		return allocationRepository.save(entity);
	}

	@Override
	public AllocationData update(AllocationData entity) {
		return allocationRepository.save(entity);
	}

	@Override
	public void delete(AllocationData entity) {
		allocationRepository.delete(entity);
	}

	@Override
	public void delete(int id) {
		allocationRepository.delete(id);
	}

	@Override
	public AllocationData find(int id) {
		return allocationRepository.findOne(id);
	}

	@Override
	public List<AllocationData> findAll() {
		return allocationRepository.findAll();
	}

	@Override
	public void deleteInBatch(List<AllocationData> allocData) {
		allocationRepository.deleteInBatch(allocData);
	}

	@Override
	public List<AllocationData> findByStaffId(String id) {
		return allocationRepository.findByStaffId(id);
	}

	@Override
	public AllocationData findById(String p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AllocationData> findByMonthYear(String month, String year) {
		return allocationRepository.findByMonthYear(month, year);
	}

	@Override
	public List<AllocationData> findByAllFields(String id, String name, String month, String year, String shift,
			String batch, String post, String major, String WorkingHr, String Mobile) {
		AllocationSpecification2 cs = new AllocationSpecification2(id, name, month, year, shift, batch, post, major,
				WorkingHr, Mobile);
		return allocationRepository.findAll(cs);
	}

	@Override
	public List<AllocationData> findbyDate(String randomColumnName, String valueToSearchFor, String month, int year) {
		AllocationSpecification cs = new AllocationSpecification(randomColumnName, valueToSearchFor, month, year);
		return allocationRepository.findAll(cs);
	}

	@Transactional
	public int updateByDate(String day, String id, String activity, String formattedMonth, int year) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaUpdate<AllocationData> q = cb.createCriteriaUpdate(AllocationData.class);
		Root<AllocationData> root = q.from(AllocationData.class);

		q.set(root.get(day), activity).where(root.get("staffId").in(id),root.get("month").in(formattedMonth),root.get("year").in(year));

		int result = em.createQuery(q).executeUpdate();
		return result;
	}
}
