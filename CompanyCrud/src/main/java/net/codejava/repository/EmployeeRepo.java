package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long>{
}
