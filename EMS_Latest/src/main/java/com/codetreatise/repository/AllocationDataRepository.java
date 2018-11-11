package com.codetreatise.repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.codetreatise.bean.AllocationData;

@Repository
public interface AllocationDataRepository extends JpaRepository<AllocationData, Integer>,JpaSpecificationExecutor<AllocationData> {

	@Query("SELECT a FROM AllocationData a WHERE a.staffId LIKE %:searchTerm%")
	List<AllocationData> findByStaffId(@Param("searchTerm") String searchTerm);

	@Query("SELECT a FROM AllocationData a WHERE a.month = :searchTerm1 and a.year = :searchTerm2")
	List<AllocationData> findByMonthYear(@Param("searchTerm1") String searchTerm1, @Param("searchTerm2") String searchTerm2);
	
	public class AllocationSpecification implements Specification<AllocationData> {

	    private String randomColumnName;
	    private String valueToSearchFor;
	    private String month;
	    private int year;

	    public AllocationSpecification(String randomColumnName, String valueToSearchFor, String month, int year) {
	        this.randomColumnName = randomColumnName;
	        this.valueToSearchFor = valueToSearchFor;
	        this.month = month;
	        this.year = year;
	    }
	    
	    @Override
	    public Predicate toPredicate(Root<AllocationData> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
	    	final Collection<Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isEmpty(this.month)) {
                final Predicate firstNmPredicate = builder.equal(root.get("month"), this.month);
                predicates.add(firstNmPredicate);
            }
            if (!StringUtils.isEmpty(this.year)) {
                final Predicate lastNmPredicate = builder.equal(root.get("year"), this.year);
                predicates.add(lastNmPredicate);
            }
            if (!StringUtils.isEmpty(this.valueToSearchFor)) {
                final Predicate dayPredicate = builder.equal(root.<String>get(this.randomColumnName), this.valueToSearchFor);
                predicates.add(dayPredicate);
            }
            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	}
	
	public class AllocationSpecification2 implements Specification<AllocationData> {

	    private String id;
	    private String name;
	    private String shift;
	    private String post;
	    private String major;
	    private String workinghr;
	    private String mobile;
	    private String month;
	    private String year;
	    private String batch;

	    public AllocationSpecification2(String id, String name, String month, String year, String shift, String batch, String post,String major,
	    		String workinghr,String mobile) {
	        this.id = id;
	        this.name = name;
	        this.shift = shift;
	        this.post = post;
	        this.major = major;
	        this.workinghr = workinghr;
	        this.mobile = mobile;
	        this.month = month;
	        this.year = year;
	        this.batch=batch;
	    }

	    @Override
	    public Predicate toPredicate(Root<AllocationData> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
	    	final Collection<Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isEmpty(this.month)) {
                final Predicate firstNmPredicate = builder.like(root.get("month"), this.month);
                predicates.add(firstNmPredicate);
            }
            if (!StringUtils.isEmpty(this.year)) {
                final Predicate lastNmPredicate = builder.like(root.get("year"), this.year);
                predicates.add(lastNmPredicate);
            }
            if (!StringUtils.isEmpty(this.name)) {
                final Predicate dayPredicate = builder.like(root.<String>get("staffName"), this.name);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.id)) {
                final Predicate dayPredicate = builder.like(root.<String>get("staffId"), this.id);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.shift)) {
                final Predicate dayPredicate = builder.like(root.<String>get("shift"), this.shift);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.post)) {
                final Predicate dayPredicate = builder.like(root.<String>get("post"), this.post);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.major)) {
                final Predicate dayPredicate = builder.like(root.<String>get("major"), this.major);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.workinghr)) {
                final Predicate dayPredicate = builder.like(root.<String>get("workingHrs"), this.workinghr);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.mobile)) {
                final Predicate dayPredicate = builder.like(root.<String>get("mobile"), this.mobile);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.batch)) {
                final Predicate dayPredicate = builder.like(root.<String>get("batchNo"), this.batch);
                predicates.add(dayPredicate);
            }
            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	}
}
