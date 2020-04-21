package com.cg;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("SBU")
public class SBU {

	@Value("${sbuId}")
	private String sbuId;
	
	@Value("${sbuName}")
	private String sbuName;
	
	@Value("${sbuHead}")
	private String sbuHead;

	private List<Employee> empList = new ArrayList<>();
	
	public List<Employee> getEmpList() {
		return empList;
	}

	public void setEmpList(List<Employee> empList) {
		this.empList = empList;
	}

	public String getSbuId() {
		return sbuId;
	}

	public void setSbuId(String sbuId) {
		this.sbuId = sbuId;
	}

	public String getSbuName() {
		return sbuName;
	}

	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}

	public String getSbuHead() {
		return sbuHead;
	}

	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}
	
	
}
