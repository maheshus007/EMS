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

import com.codetreatise.bean.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>,JpaSpecificationExecutor<Employee> {

	Employee findByStaffId(String id);
	
	@Query("SELECT e FROM Employee e WHERE e.staffName = :searchTerm")
	List<Employee> findByName(@Param("searchTerm") String searchTerm);

	public class EmployeeSpecification implements Specification<Employee> {

	    private String id;
	    private String name;
	    private String uaeid;
	    private String batch;
	    private String gender;
	    private LocalDate ojtstartdate;
	    private String designation;
	    private String staffgrade;
	    private String nationality;
	    private String department;
	    private String contact;
	    private String passport;
	    private String placeofbirth;
	    private String academicqualification;
	    private String drivinglicense;
	    private String linemanager;
	    private String areaofwork;
	    private String _300hrs;
	    private String collegemodules;
	    private String logbook;
	    private String major;
	    private String workinghrs;
	    private String nSstatus;
	    private String specifymodules;
	    private String email;
	    private String post;
	    private String shift;
	    
	    private LocalDate ojtenddate;
	    private LocalDate doj;
	    private LocalDate nS_end_date;
	    private LocalDate nSstartdate;
	    private LocalDate dob;

	    public EmployeeSpecification(String id, String name, String uaeid, String batch, String gender, String designation, String staffgrade, 
	    		String nationality, String department, String contact, String passport, 
	    		String placeofbirth, String academicqualification, String drivinglicense, String linemanager, String areaofwork, String _300hrs, 
	    		String collegemodules, String logbook, String major, String workinghrs, String nSstatus, String specifymodules, String email, 
	    		String post, String shift, LocalDate ojtstartdate, LocalDate ojtenddate, LocalDate doj, LocalDate nS_end_date, 
	    		LocalDate nSstartdate, LocalDate dob) {
	        this.id = id;
	        this.name = name;
	        this.uaeid = uaeid;
	        this.batch = batch;
	        this.gender = gender;
	        this.designation = designation;
	        this.staffgrade=staffgrade;
	        this.nationality=nationality;
	        this.department=department;
	        this.contact=contact;
	        this.passport=passport;
	        this.placeofbirth=placeofbirth;
	        this.academicqualification=academicqualification;
	        this.drivinglicense=drivinglicense;
	        this.linemanager=linemanager;
	        this.areaofwork=areaofwork;
	        this._300hrs=_300hrs;
	        this.collegemodules=collegemodules;
	        this.logbook=logbook;
	        this.major=major;
	        this.workinghrs=workinghrs;
	        this.nSstatus=nSstatus;
	        this.specifymodules=specifymodules;
	        this.email=email;
	        this.post=post;
	        this.shift=shift;
	        
	        this.ojtstartdate = ojtstartdate;
	        this.ojtenddate=ojtenddate;
	        this.dob=dob;
	        this.doj=doj;
	        this.nS_end_date=nS_end_date;
	        this.nSstartdate=nSstartdate;
	    }

	    @Override
	    public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
	    	final Collection<Predicate> predicates = new ArrayList<>();
            if (!StringUtils.isEmpty(this.id)) {
                final Predicate firstNmPredicate = builder.like(root.get("staffId"), this.id);
                predicates.add(firstNmPredicate);
            }
            if (!StringUtils.isEmpty(this.name)) {
                final Predicate lastNmPredicate = builder.like(root.get("staffName"), this.name);
                predicates.add(lastNmPredicate);
            }
            if (!StringUtils.isEmpty(this.uaeid)) {
                final Predicate dayPredicate = builder.like(root.<String>get("uaeid"), this.uaeid);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.batch)) {
                final Predicate dayPredicate = builder.like(root.<String>get("batch"), this.batch);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.gender)) {
                final Predicate dayPredicate = builder.like(root.<String>get("gender"), this.gender);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.designation)) {
                final Predicate dayPredicate = builder.like(root.<String>get("designation"), this.designation);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.staffgrade)) {
                final Predicate dayPredicate = builder.like(root.<String>get("staffgrade"), this.staffgrade);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.nationality)) {
                final Predicate dayPredicate = builder.like(root.<String>get("nationality"), this.nationality);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.department)) {
                final Predicate dayPredicate = builder.like(root.<String>get("department"), this.department);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.contact)) {
                final Predicate dayPredicate = builder.like(root.<String>get("contact"), this.contact);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.passport)) {
                final Predicate dayPredicate = builder.like(root.<String>get("passport"), this.passport);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.gender)) {
                final Predicate dayPredicate = builder.like(root.<String>get("gender"), this.gender);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.placeofbirth)) {
                final Predicate dayPredicate = builder.like(root.<String>get("placeofbirth"), this.placeofbirth);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.academicqualification)) {
                final Predicate dayPredicate = builder.like(root.<String>get("academicqualification"), this.academicqualification);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.drivinglicense)) {
                final Predicate dayPredicate = builder.like(root.<String>get("drivingLicense"), this.drivinglicense);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.linemanager)) {
                final Predicate dayPredicate = builder.like(root.<String>get("linemanager"), this.linemanager);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.areaofwork)) {
                final Predicate dayPredicate = builder.like(root.<String>get("areaofwork"), this.areaofwork);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this._300hrs)) {
                final Predicate dayPredicate = builder.like(root.<String>get("_300hrs"), this._300hrs);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.collegemodules)) {
                final Predicate dayPredicate = builder.like(root.<String>get("collegemodules"), this.collegemodules);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.logbook)) {
                final Predicate dayPredicate = builder.like(root.<String>get("logbook"), this.logbook);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.major)) {
                final Predicate dayPredicate = builder.like(root.<String>get("major"), this.major);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.workinghrs)) {
                final Predicate dayPredicate = builder.like(root.<String>get("workinghrs"), this.workinghrs);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.nSstatus)) {
                final Predicate dayPredicate = builder.like(root.<String>get("NSstatus"), this.nSstatus);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.specifymodules)) {
                final Predicate dayPredicate = builder.like(root.<String>get("specifymodules"), this.specifymodules);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.email)) {
                final Predicate dayPredicate = builder.like(root.<String>get("email"), this.email);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.post)) {
                final Predicate dayPredicate = builder.like(root.<String>get("post"), this.post);
                predicates.add(dayPredicate);
            }if (!StringUtils.isEmpty(this.shift)) {
                final Predicate dayPredicate = builder.like(root.<String>get("shift"), this.shift);
                predicates.add(dayPredicate);
            }
            
            if (!StringUtils.isEmpty(this.ojtstartdate)) {
                final Predicate dayPredicate = builder.equal(root.<LocalDate>get("ojtstartdate"), this.ojtstartdate);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.ojtenddate)) {
                final Predicate dayPredicate = builder.equal(root.<LocalDate>get("ojtenddate"), this.ojtenddate);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.dob)) {
                final Predicate dayPredicate = builder.equal(root.<LocalDate>get("dob"), this.dob);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.doj)) {
                final Predicate dayPredicate = builder.equal(root.<LocalDate>get("doj"), this.doj);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.nS_end_date)) {
                final Predicate dayPredicate = builder.equal(root.<LocalDate>get("NS_end_date"), this.nS_end_date);
                predicates.add(dayPredicate);
            }
            if (!StringUtils.isEmpty(this.nSstartdate)) {
                final Predicate dayPredicate = builder.equal(root.<LocalDate>get("NSstartdate"), this.nSstartdate);
                predicates.add(dayPredicate);
            }
            return builder.and(predicates.toArray(new Predicate[predicates.size()]));
	    }
	}
}
