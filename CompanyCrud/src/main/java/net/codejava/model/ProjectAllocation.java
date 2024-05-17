package net.codejava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProjectAllocation {
	private Long project_allocation_id;
	@Column(name="project_id")
	private Long project_id;
	@Column(name="employee_id")
	private Long employee_id;
	public ProjectAllocation() {
		// TODO Auto-generated constructor stub
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getProject_allocation_id() {
		return project_allocation_id;
	}
	public void setProject_allocation_id(Long project_allocation_id) {
		this.project_allocation_id = project_allocation_id;
	}
	public Long getProject_id() {
		return project_id;
	}
	public void setProject_id(Long project_id) {
		this.project_id = project_id;
	}
	public Long getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Long employee_id) {
		this.employee_id = employee_id;
	}
}
