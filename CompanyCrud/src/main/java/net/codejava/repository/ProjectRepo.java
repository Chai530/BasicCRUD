package net.codejava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.codejava.model.Project;

public interface ProjectRepo extends JpaRepository<Project,Long>{

}
