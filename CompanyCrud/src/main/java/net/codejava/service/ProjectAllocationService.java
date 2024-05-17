package net.codejava.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.codejava.model.ProjectAllocation;
import net.codejava.repository.ProjectAllocationRepo;

@Service
public class ProjectAllocationService {
	@Autowired
	private ProjectAllocationRepo pa_repo;
	
	//project allocation
		public List< ProjectAllocation> listAllPA(){
			return pa_repo.findAll();
		}
		
		public void save_projectallocation(ProjectAllocation projectallocation) {
			pa_repo.save(projectallocation);
		}
		
		public ProjectAllocation get_projectallocation(Long project_allocation_id) {
			return pa_repo.findById(project_allocation_id).get();
		}
		
		public void delete_projectallocation(Long project_allocation_id) {
			pa_repo.deleteById(project_allocation_id);
		}
}