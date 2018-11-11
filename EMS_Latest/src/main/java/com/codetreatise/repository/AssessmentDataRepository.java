package com.codetreatise.repository;

import java.time.LocalDate;
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

import com.codetreatise.bean.AssessmentData;

@Repository
public interface AssessmentDataRepository extends JpaRepository<AssessmentData, Integer>,JpaSpecificationExecutor<AssessmentData> {
	

	@Query("SELECT a FROM AssessmentData a WHERE a.staffId LIKE %:searchTerm%")
	List<AssessmentData> findByStaffId(@Param("searchTerm") String searchTerm);

	
	@Query("SELECT a FROM AssessmentData a WHERE a.staffId = :searchTerm1 and a.date = :searchTerm2 and a.assessmentModule= :searchTerm3")
	List<AssessmentData> findByItem(@Param("searchTerm1") String searchTerm1,@Param("searchTerm2") LocalDate searchTerm2,@Param("searchTerm3") String searchTerm3);

	public class AssessmentSpecification implements Specification<AssessmentData> {

	    private String id;
	    private String name;
	    private String shift;
	    private String post;
	    private String major;
	    private String workinghr;
	    private String mobile;
	    private String batch;
	    private LocalDate date;
	    private String assessmentModule;
	    private String assessor;

	    public AssessmentSpecification(String id, String name, String shift, String batch, String post,String major,
	    		String workinghr,String mobile,LocalDate date, String assessmentModule, String assessor) {
	        this.id = id;
	        this.name = name;
	        this.shift = shift;
	        this.post = post;
	        this.major = major;
	        this.workinghr = workinghr;
	        this.mobile = mobile;
	        this.batch=batch;
	        this.date=date;
	        this.assessmentModule = assessmentModule;
	        this.assessor=assessor;
	    }
	    @Override
	    public Predicate toPredicate(Root<AssessmentData> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
	    	final Collection<Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isEmpty(this.date)) {
                final Predicate lastNmPredicate = builder.equal(root.get("date"), this.date);
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
            if (!StringUtils.isEmpty(this.assessmentModule)) {
                final Predicate dayPredicate = builder.like(root.<String>get("assessmentModule"), this.assessmentModule);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.assessor)) {
                final Predicate dayPredicate = builder.like(root.<String>get("assessor"), this.assessor);
                predicates.add(dayPredicate);
            }
            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	}

}
