package com.codetreatise.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "trainingdata")
public class TrainingData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "trainingId", updatable = false, nullable = false)
	private int trainingId;

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
	
	private String course;
	
	private LocalDate date;


	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
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
	

	@Override
	public String toString() {
		return "TrainingData [trainingId=" + trainingId + ", staffId=" + staffId + ", shift=" + shift + ", staffName="
				+ staffName + ", batchNo=" + batchNo + ", post=" + post + ", major=" + major + ", workingHrs="
				+ workingHrs + ", mobile=" + mobile + ", course=" + course + ", date=" + date + "]";
	}

}
