package com.codetreatise.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "assessmentdata")
public class AssessmentData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "assessmentId", updatable = false, nullable = false)
	private int assessmentId;

	private String staffId;

	private String shift;

	private String staffName;

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	private String batchNo;

	private String post;

	private String major;

	private String workingHrs;

	private String mobile;
	
	private String assessmentModule;
	
	private String assessor;
	
	public String getAssessor() {
		return assessor;
	}

	public void setAssessor(String assessor) {
		this.assessor = assessor;
	}

	public String getAssessmentModule() {
		return assessmentModule;
	}

	public void setAssessmentModule(String assessmentModule) {
		this.assessmentModule = assessmentModule;
	}

	private LocalDate date;

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getBatchNo() {
		return batchNo;
	}

	public void setBatchNo(String batchNo) {
		this.batchNo = batchNo;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getWorkingHrs() {
		return workingHrs;
	}

	public void setWorkingHrs(String workingHrs) {
		this.workingHrs = workingHrs;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(int assessmentId) {
		this.assessmentId = assessmentId;
	}

	@Override
	public String toString() {
		return "AssessmentData [assessmentId=" + assessmentId + ", staffId=" + staffId + ", shift=" + shift
				+ ", staffName=" + staffName + ", batchNo=" + batchNo + ", post=" + post + ", major=" + major
				+ ", workingHrs=" + workingHrs + ", mobile=" + mobile + ", assessmentModule=" + assessmentModule
				+ ", assessor=" + assessor + ", date=" + date + "]";
	}


}
