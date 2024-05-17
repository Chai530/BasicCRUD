package net.codejava.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Department {
  private Long department_id;
  @Column(name = "department_name")
  private String department_name;
  public Department() {
	
	// TODO Auto-generated constructor stub
}
  
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
public Long getDepartment_id() {
	return department_id;
}
public void setDepartment_id(Long department_id) {
	this.department_id = department_id;
}
public String getDepartment_name() {
	return department_name;
}
public void setDepartment_name(String department_name) {
	this.department_name = department_name;
}

public Department(Long department_id, String department_name) {
	this.department_id = department_id;
	this.department_name = department_name;
	
}
  
  
}

