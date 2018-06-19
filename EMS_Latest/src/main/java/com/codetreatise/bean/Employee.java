package com.codetreatise.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "staff_id", updatable = false, nullable = false)
	private long staffId;
	
	private String staffName;
	
	private String uaeid;
	
	private String batch;
	
	private int contact;
	
	private String placeofbirth;
	
	private String email;
	
	private String designation;
	
	private String staffgrade;
	
	private String nationality;
	
	private String department;

	private String academicqualification;
	
	private String passport;
	
	private String drivinglicense;
	
	private String dob;
	
	private String doj;
	
	private String ojtstartdate;
	
	private String ojtenddate;
	
	private String areaofwork;
	
	private String NSstatus;
	
	private String NSstartdate;
	
	private String NS_end_date;
	
	private String _300hrs;
	
	private String logbook;
	
	private String major;
	
	private String linemanager;
	
	private String workinghrs;
	
	private String collegemodules;
	
	private String specifymodules;

	public long getStaffid() {
		return staffId;
	}

	public void setStaffid(long string) {
		this.staffId = string;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getUaeid() {
		return uaeid;
	}

	public void setUaeid(String uaeid) {
		this.uaeid = uaeid;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public int getContact() {
		return contact;
	}

	public void setContact(int contact) {
		this.contact = contact;
	}

	public String getPlaceofbirth() {
		return placeofbirth;
	}

	public void setPlaceofbirth(String placeofbirth) {
		this.placeofbirth = placeofbirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getStaffgrade() {
		return staffgrade;
	}

	public void setStaffgrade(String staffgrade) {
		this.staffgrade = staffgrade;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getAcademicqualification() {
		return academicqualification;
	}

	public void setAcademicqualification(String academicqualification) {
		this.academicqualification = academicqualification;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getDrivinglicense() {
		return drivinglicense;
	}

	public void setDrivinglicense(String drivinglicense) {
		this.drivinglicense = drivinglicense;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getDoj() {
		return doj;
	}

	public void setDoj(String doj) {
		this.doj = doj;
	}

	public String getOjtstartdate() {
		return ojtstartdate;
	}

	public void setOjtstartdate(String ojtstartdate) {
		this.ojtstartdate = ojtstartdate;
	}

	public String getOjtenddate() {
		return ojtenddate;
	}

	public void setOjtenddate(String ojtenddate) {
		this.ojtenddate = ojtenddate;
	}

	public String getAreaofwork() {
		return areaofwork;
	}

	public void setAreaofwork(String areaofwork) {
		this.areaofwork = areaofwork;
	}

	public String getNSstatus() {
		return NSstatus;
	}

	public void setNSstatus(String nSstatus) {
		NSstatus = nSstatus;
	}

	public String getNSstartdate() {
		return NSstartdate;
	}

	public void setNSstartdate(String nSstartdate) {
		NSstartdate = nSstartdate;
	}

	public String getNS_end_date() {
		return NS_end_date;
	}

	public void setNS_end_date(String nS_end_date) {
		NS_end_date = nS_end_date;
	}

	public String get_300hrs() {
		return _300hrs;
	}

	public void set_300hrs(String _300hrs) {
		this._300hrs = _300hrs;
	}

	public String getLogbook() {
		return logbook;
	}

	public void setLogbook(String logbook) {
		this.logbook = logbook;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getLinemanager() {
		return linemanager;
	}

	public void setLinemanager(String linemanager) {
		this.linemanager = linemanager;
	}

	public String getWorkinghrs() {
		return workinghrs;
	}

	public void setWorkinghrs(String workinghrs) {
		this.workinghrs = workinghrs;
	}

	public String getCollegemodules() {
		return collegemodules;
	}

	public void setCollegemodules(String collegemodules) {
		this.collegemodules = collegemodules;
	}

	public String getSpecifymodules() {
		return specifymodules;
	}

	public void setSpecifymodules(String specifymodules) {
		this.specifymodules = specifymodules;
	}

	@Override
	public String toString() {
		return "Employee [staffid=" + staffId + ", staffName=" + staffName + ", uaeid=" + uaeid + ", batch=" + batch
				+ ", contact=" + contact + ", placeofbirth=" + placeofbirth + ", email=" + email + ", designation="
				+ designation + ", staffgrade=" + staffgrade + ", nationality=" + nationality + ", department="
				+ department + ", academicqualification=" + academicqualification + ", passport=" + passport
				+ ", drivinglicense=" + drivinglicense + ", dob=" + dob + ", doj=" + doj + ", ojtstartdate="
				+ ojtstartdate + ", ojtenddate=" + ojtenddate + ", areaofwork=" + areaofwork + ", NSstatus=" + NSstatus
				+ ", NSstartdate=" + NSstartdate + ", NS_end_date=" + NS_end_date + ", _300hrs=" + _300hrs
				+ ", logbook=" + logbook + ", major=" + major + ", linemanager=" + linemanager + ", workinghrs="
				+ workinghrs + ", collegemodules=" + collegemodules + ", specifymodules=" + specifymodules + "]";
	}
}
