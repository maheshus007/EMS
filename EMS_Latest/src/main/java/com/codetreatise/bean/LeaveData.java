package com.codetreatise.bean;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leavehistory")
public class LeaveData {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "leaveId", updatable = false, nullable = false)
	private int leaveId;
	
	private String staffId;
	
	private String staffName;
	
	private LocalDate fromDate;
	
	private LocalDate toDate;
	
	private LocalDate dateOfApproval;
	
	private String approverName;
	
	private String totalLeaveTaken;
	
	private String balLeave;
	
	private String shift;
	
	private String typeOfLeave;
	
	private String approveReject;

	public int getLeaveId() {
		return leaveId;
	}

	public void setLeaveId(int leaveId) {
		this.leaveId = leaveId;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public LocalDate getDateOfApproval() {
		return dateOfApproval;
	}

	public void setDateOfApproval(LocalDate dateOfApproval) {
		this.dateOfApproval = dateOfApproval;
	}

	public String getApproverName() {
		return approverName;
	}

	public void setApproverName(String approverName) {
		this.approverName = approverName;
	}

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

	public String getShift() {
		return shift;
	}

	public void setShift(String shift) {
		this.shift = shift;
	}

	public String getTypeOfLeave() {
		return typeOfLeave;
	}

	public void setTypeOfLeave(String typeOfLeave) {
		this.typeOfLeave = typeOfLeave;
	}

	public String getApproveReject() {
		return approveReject;
	}

	public void setApproveReject(String approveReject) {
		this.approveReject = approveReject;
	}

	@Override
	public String toString() {
		return "LeaveData [leaveId=" + leaveId + ", staffId=" + staffId + ", staffName=" + staffName + ", fromDate="
				+ fromDate + ", toDate=" + toDate + ", dateOfApproval=" + dateOfApproval + ", approverName="
				+ approverName + ", totalLeaveTaken=" + totalLeaveTaken + ", balLeave=" + balLeave + ", shift=" + shift
				+ ", typeOfLeave=" + typeOfLeave + ", approveReject=" + approveReject + "]";
	}
}
