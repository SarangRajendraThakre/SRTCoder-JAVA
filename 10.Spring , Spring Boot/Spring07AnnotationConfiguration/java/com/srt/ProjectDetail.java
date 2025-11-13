




package com.srt;

import org.springframework.stereotype.Component;

@Component
public class ProjectDetail {
	
	private String projectName;
	private int projectAmount;
	
	public ProjectDetail() {
		// TODO Auto-generated constructor stub
		System.out.println("projectDetail Object is created ");
	}
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getProjectAmount() {
		return projectAmount;
	}
	public void setProjectAmount(int projectAmount) {
		this.projectAmount = projectAmount;
	}
	
	

}
