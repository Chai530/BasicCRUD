package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.model.Department;

public interface DepartmentRepo extends JpaRepository<Department,Long>{
}