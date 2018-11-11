package com.codetreatise.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "allocationdata")
public class AllocationData {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "allocationId", updatable = false, nullable = false)
	private int allocationId;

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

	private String week;

	private String major;

	private String workingHrs;

	private String mobile;

	private String month;
	
	private String year;

	public int getAllocationId() {
		return allocationId;
	}

	public void setAllocationId(int allocationId) {
		this.allocationId = allocationId;
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
	
	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	private String one;
	private String two;
	private String three;
	private String four;
	private String five;
	private String six;
	private String seven;
	private String eight;
	private String nine;
	private String ten;
	private String eleven;
	private String twelve;
	private String thirteen;
	private String fourteen;
	private String fifteen;
	private String sixteen;
	private String seventeen;
	private String eighteen;
	private String nineteen;
	private String twenty;
	private String twentyone;
	private String twentytwo;
	private String twentythree;
	private String twentyfour;
	private String twentyfive;
	private String twentysix;
	private String twentyseven;
	private String twentyeight;
	private String twentynine;
	private String thirty;
	private String thirtyone;

	public String getOne() {
		return one;
	}

	public void setOne(String one) {
		this.one = one;
	}

	public String getTwo() {
		return two;
	}

	public void setTwo(String two) {
		this.two = two;
	}

	public String getThree() {
		return three;
	}

	public void setThree(String three) {
		this.three = three;
	}

	public String getFour() {
		return four;
	}

	public void setFour(String four) {
		this.four = four;
	}

	public String getFive() {
		return five;
	}

	public void setFive(String five) {
		this.five = five;
	}

	public String getSix() {
		return six;
	}

	public void setSix(String six) {
		this.six = six;
	}

	public String getSeven() {
		return seven;
	}

	public void setSeven(String seven) {
		this.seven = seven;
	}

	public String getEight() {
		return eight;
	}

	public void setEight(String eight) {
		this.eight = eight;
	}

	public String getNine() {
		return nine;
	}

	public void setNine(String nine) {
		this.nine = nine;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public String getEleven() {
		return eleven;
	}

	public void setEleven(String eleven) {
		this.eleven = eleven;
	}

	public String getTwelve() {
		return twelve;
	}

	public void setTwelve(String twelve) {
		this.twelve = twelve;
	}

	public String getThirteen() {
		return thirteen;
	}

	public void setThirteen(String thirteen) {
		this.thirteen = thirteen;
	}

	public String getFourteen() {
		return fourteen;
	}

	public void setFourteen(String fourteen) {
		this.fourteen = fourteen;
	}

	public String getFifteen() {
		return fifteen;
	}

	public void setFifteen(String fifteen) {
		this.fifteen = fifteen;
	}

	public String getSixteen() {
		return sixteen;
	}

	public void setSixteen(String sixteen) {
		this.sixteen = sixteen;
	}

	public String getSeventeen() {
		return seventeen;
	}

	public void setSeventeen(String seventeen) {
		this.seventeen = seventeen;
	}

	public String getEighteen() {
		return eighteen;
	}

	public void setEighteen(String eighteen) {
		this.eighteen = eighteen;
	}

	public String getNineteen() {
		return nineteen;
	}

	public void setNineteen(String nineteen) {
		this.nineteen = nineteen;
	}

	public String getTwenty() {
		return twenty;
	}

	public void setTwenty(String twenty) {
		this.twenty = twenty;
	}

	public String getTwentyone() {
		return twentyone;
	}

	public void setTwentyone(String twentyone) {
		this.twentyone = twentyone;
	}

	public String getTwentytwo() {
		return twentytwo;
	}

	public void setTwentytwo(String twentytwo) {
		this.twentytwo = twentytwo;
	}

	public String getTwentythree() {
		return twentythree;
	}

	public void setTwentythree(String twentythree) {
		this.twentythree = twentythree;
	}

	public String getTwentyfour() {
		return twentyfour;
	}

	public void setTwentyfour(String twentyfour) {
		this.twentyfour = twentyfour;
	}

	public String getTwentyfive() {
		return twentyfive;
	}

	public void setTwentyfive(String twentyfive) {
		this.twentyfive = twentyfive;
	}

	public String getTwentysix() {
		return twentysix;
	}

	public void setTwentysix(String twentysix) {
		this.twentysix = twentysix;
	}

	public String getTwentyseven() {
		return twentyseven;
	}

	public void setTwentyseven(String twentyseven) {
		this.twentyseven = twentyseven;
	}

	public String getTwentyeight() {
		return twentyeight;
	}

	public void setTwentyeight(String twentyeight) {
		this.twentyeight = twentyeight;
	}

	public String getTwentynine() {
		return twentynine;
	}

	public void setTwentynine(String twentynine) {
		this.twentynine = twentynine;
	}

	public String getThirty() {
		return thirty;
	}

	public void setThirty(String thirty) {
		this.thirty = thirty;
	}

	public String getThirtyone() {
		return thirtyone;
	}

	public void setThirtyone(String thirtyone) {
		this.thirtyone = thirtyone;
	}

	@Override
	public String toString() {
		return "AllocationData [allocationId=" + allocationId + ", staffId=" + staffId + ", shift=" + shift
				+ ", staffName=" + staffName + ", batchNo=" + batchNo + ", post=" + post + ", week=" + week
				+ ", major=" + major + ", workingHrs=" + workingHrs + ", mobile=" + mobile + "]";
	}

}
