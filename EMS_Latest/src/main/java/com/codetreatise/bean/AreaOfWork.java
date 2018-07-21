package com.codetreatise.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="areaofwork")
public class AreaOfWork {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	private String areaOfWork;
	
	private int count;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaOfWork() {
		return areaOfWork;
	}

	public void setAreaOfWork(String areaOfWork) {
		this.areaOfWork = areaOfWork;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "AreaOfWork [id=" + id + ", areaOfWork=" + areaOfWork + ", count=" + count + "]";
	}
	
	
}
