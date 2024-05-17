package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.model.ProjectAllocation;

public interface ProjectAllocationRepo extends JpaRepository<ProjectAllocation,Long>{

}
