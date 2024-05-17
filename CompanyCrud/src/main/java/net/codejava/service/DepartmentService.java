package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Department;
import net.codejava.repository.DepartmentRepo;
@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepo repo;
	
	
	//department
	public List<Department> listAll(){
		return repo.findAll();
	}
	
	public void save_department(Department department) {
		repo.save(department);
	}
	
	public Department get_department(Long department_id) {
		return repo.findById(department_id).get();
	}
	
	public void delete_department(Long department_id) {
		repo.deleteById(department_id);
	}
	
	
}

