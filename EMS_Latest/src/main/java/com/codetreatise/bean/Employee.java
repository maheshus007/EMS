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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "employeeId", updatable = false, nullable = false)
	private int employeeId;
	
	private String staffId;
	
	private String staffName;
	
	private String uaeId;
	
	private String gender;
	
	private String history;
	
	public String getHistory() {
		return history;
	}

	public void setHistory(String history) {
		this.history = history;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	private String batch;
	
	private String contact;
	
	private String placeofbirth;
	
	private String email;
	
	private String designation;
	
	private String staffgrade;
	
	private String nationality;
	
	private String department;

	private String academicqualification;
	
	private String passport;
	
	private String drivingLicense;
	
	private LocalDate dob;
	
	private LocalDate doj;
	
	private LocalDate ojtstartdate;
	
	private LocalDate ojtenddate;
	
	private String areaofwork;
	
	private String NSstatus;
	
	private LocalDate NSstartdate;
	
	private LocalDate NS_end_date;
	
	private String _300hrs;
	
	private String logbook;
	
	private String major;
	
	private String linemanager;
	
	private String workinghrs;
	
	private String collegemodules;
	
	private String specifymodules;

	private String basicLicense;
	
	private String l3CourseType;
	
	private String a380Project;
	
	private String rfidProjectMember;
	
	private String engineChangeProject;
	
	private String corCertificate;
	
	private String post;
	
	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	private String shift;
	
	public String getTotalLeaveTaken() {
		return totalLeaveTaken;
	}

	public void setTotalLeaveTaken(String totalLeaveTaken) {
		this.totalLeaveTaken = totalLeaveTaken;
	}

	public String getBalLeave() {
		return balLeave;
	}

	public void setBalLeave(String balLeave) {
		this.balLeave = balLeave;
	}

	private String totalLeaveTaken;
	
	private String balLeave;
	
	public int getId() {
		return employeeId;
	}

	public void setId(int id) {
		this.employeeId = id;
	}

	
	public String getBasicLicense() {
		return basicLicense;
	}
	
	public String getBasicLicense1() {
		if(basicLicense.equals("Yes")){
			return "true";
		}
		else 
			return "false";
	}

	public void setBasicLicense(String basicLicense) {
		this.basicLicense = basicLicense;
	}

	public String getL3CourseType() {
		return l3CourseType;
	}
	
	public String getL3CourseType1() {
		if(l3CourseType.equals("Yes")){
			return "true";
		}
		else 
			return "false";
	}

	public void setL3CourseType(String l3CourseType) {
		this.l3CourseType = l3CourseType;
	}

	public String getA380Project() {
		return a380Project;
	}
	
	public String getA380Project1() {
		if(a380Project.equals("Yes")){
			return "true";
		}
		else 
			return "false";
	}

	public void setA380Project(String a380Project) {
		this.a380Project = a380Project;
	}

	public String getRfidProjectMember() {
		return rfidProjectMember;
	}
	
	public String getRfidProjectMember1() {
		if(rfidProjectMember.equals("Yes")){
			return "true";
		}
		else 
			return "false";
	}

	public void setRfidProjectMember(String rfidProjectMember) {
		this.rfidProjectMember = rfidProjectMember;
	}

	public String getEngineChangeProject() {
		return engineChangeProject;
	}
	
	public String getEngineChangeProject1() {
		if(engineChangeProject.equals("Yes")){
			return "true";
		}
		else 
			return "false";
	}

	public void setEngineChangeProject(String engineChangeProject) {
		this.engineChangeProject = engineChangeProject;
	}

	public String getCorCertificate() {
		return corCertificate;
	}
	
	public String getCorCertificate1() {
		if(corCertificate.equals("Yes")){
			return "true";
		}
		else 
			return "false";
	}

	public void setCorCertificate(String corCertificate) {
		this.corCertificate = corCertificate;
	}

	public String getStaffid() {
		return staffId;
	}

	public void setStaffid(String string) {
		this.staffId = string;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getUaeid() {
		return uaeId;
	}

	public void setUaeid(String uaeid) {
		this.uaeId = uaeid;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
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
		return drivingLicense;
	}

	public void setDrivinglicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public LocalDate getDoj() {
		return doj;
	}

	public void setDoj(LocalDate doj) {
		this.doj = doj;
	}

	public LocalDate getOjtstartdate() {
		return ojtstartdate;
	}

	public void setOjtstartdate(LocalDate ojtstartdate) {
		this.ojtstartdate = ojtstartdate;
	}

	public LocalDate getOjtenddate() {
		return ojtenddate;
	}

	public void setOjtenddate(LocalDate ojtenddate) {
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

	public LocalDate getNSstartdate() {
		return NSstartdate;
	}

	public void setNSstartdate(LocalDate nSstartdate) {
		NSstartdate = nSstartdate;
	}

	public LocalDate getNS_end_date() {
		return NS_end_date;
	}

	public void setNSenddate(LocalDate nS_end_date) {
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
		return "Employee [employeeId=" + employeeId + ", staffId=" + staffId + ", staffName=" + staffName + ", uaeId="
				+ uaeId + ", gender=" + gender + ", history=" + history + ", batch=" + batch + ", contact=" + contact
				+ ", placeofbirth=" + placeofbirth + ", email=" + email + ", designation=" + designation
				+ ", staffgrade=" + staffgrade + ", nationality=" + nationality + ", department=" + department
				+ ", academicqualification=" + academicqualification + ", passport=" + passport + ", drivingLicense="
				+ drivingLicense + ", dob=" + dob + ", doj=" + doj + ", ojtstartdate=" + ojtstartdate + ", ojtenddate="
				+ ojtenddate + ", areaofwork=" + areaofwork + ", NSstatus=" + NSstatus + ", NSstartdate=" + NSstartdate
				+ ", NS_end_date=" + NS_end_date + ", _300hrs=" + _300hrs + ", logbook=" + logbook + ", major=" + major
				+ ", linemanager=" + linemanager + ", workinghrs=" + workinghrs + ", collegemodules=" + collegemodules
				+ ", specifymodules=" + specifymodules + ", basicLicense=" + basicLicense + ", l3CourseType="
				+ l3CourseType + ", a380Project=" + a380Project + ", rfidProjectMember=" + rfidProjectMember
				+ ", engineChangeProject=" + engineChangeProject + ", corCertificate=" + corCertificate + ", post="
				+ post + ", shift=" + shift + ", totalLeaveTaken=" + totalLeaveTaken + ", balLeave=" + balLeave + "]";
	}

}
