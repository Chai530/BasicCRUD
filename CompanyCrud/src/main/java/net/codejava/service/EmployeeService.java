package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.Employee;
import net.codejava.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo em_repo;
	
	//employee
		public List<Employee> listAllEm(){
			return em_repo.findAll();
		}
		
		public void save_employee(Employee employee) {
			em_repo.save(employee);
		}
		
		public Employee get_employee(Long employee_id) {
			return em_repo.findById(employee_id).get();
		}
		
		public void delete_employee(Long employee_id) {
			em_repo.deleteById(employee_id);
		}
}
